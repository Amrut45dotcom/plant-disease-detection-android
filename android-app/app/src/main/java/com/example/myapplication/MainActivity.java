package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.tensorflow.lite.Interpreter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button camera, gallery;
    ImageView imageView;
    TextView result;

    int imageSize = 128;
    Interpreter tflite;
    List<String> labels;

    ActivityResultLauncher<Intent> cameraLauncher;
    ActivityResultLauncher<Intent> galleryLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera = findViewById(R.id.button);
        gallery = findViewById(R.id.button2);
        result = findViewById(R.id.result);
        imageView = findViewById(R.id.imageView);

        try {
            tflite = new Interpreter(loadModelFile());
            labels = loadLabels();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Model or labels not loaded", Toast.LENGTH_LONG).show();
        }

        // ---------- GALLERY RESULT ----------
        galleryLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri uri = result.getData().getData();
                        try {
                            Bitmap image = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                            imageView.setImageBitmap(image);
                            classifyImage(image);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        // ---------- CAMERA RESULT ----------
        cameraLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bundle extras = result.getData().getExtras();
                        if (extras != null) {
                            Bitmap image = (Bitmap) extras.get("data");
                            imageView.setImageBitmap(image);
                            classifyImage(image);
                        }
                    }
                }
        );

        // ---------- BUTTON CLICKS ----------
        camera.setOnClickListener(view -> {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                openCamera();
            } else {
                requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
            }
        });

        gallery.setOnClickListener(view -> openGallery());
    }

    // ---------- OPEN GALLERY ----------
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        galleryLauncher.launch(intent);
    }

    // ---------- OPEN CAMERA ----------
    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraLauncher.launch(intent);
    }

    // ---------- LOAD MODEL ----------
    private MappedByteBuffer loadModelFile() throws IOException {
        AssetFileDescriptor fileDescriptor = getAssets().openFd("plant_disease_int8.tflite");
        FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
        FileChannel fileChannel = inputStream.getChannel();
        long startOffset = fileDescriptor.getStartOffset();
        long declaredLength = fileDescriptor.getDeclaredLength();
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
    }

    // ---------- LOAD LABELS ----------
    private List<String> loadLabels() throws IOException {
        List<String> labels = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("labels.txt")));
        String line;
        while ((line = reader.readLine()) != null) {
            labels.add(line);
        }
        reader.close();
        return labels;
    }

    // ---------- CLASSIFICATION ----------
    public void classifyImage(Bitmap image) {

        Bitmap resized = Bitmap.createScaledBitmap(image, imageSize, imageSize, true);

        ByteBuffer inputBuffer = ByteBuffer.allocateDirect(1 * imageSize * imageSize * 3);
        inputBuffer.order(ByteOrder.nativeOrder());

        int[] intValues = new int[imageSize * imageSize];
        resized.getPixels(intValues, 0, imageSize, 0, 0, imageSize, imageSize);

        int pixel = 0;
        for (int i = 0; i < imageSize; i++) {
            for (int j = 0; j < imageSize; j++) {
                int val = intValues[pixel++];

                inputBuffer.put((byte) ((val >> 16) & 0xFF));
                inputBuffer.put((byte) ((val >> 8) & 0xFF));
                inputBuffer.put((byte) (val & 0xFF));
            }
        }

        byte[][] output = new byte[1][labels.size()];
        tflite.run(inputBuffer, output);

        float maxConfidence = -1;
        int maxIndex = -1;

        for (int i = 0; i < output[0].length; i++) {
            float confidence = (output[0][i] & 0xFF) * 0.00390625f;

            if (confidence > maxConfidence) {
                maxConfidence = confidence;
                maxIndex = i;
            }
        }

        String predictedLabel = labels.get(maxIndex);
        result.setText(predictedLabel + "\nConfidence: " + String.format("%.2f", maxConfidence));
    }
}
