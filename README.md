Plant Disease Detection Android Application

Overview



This project is an Android-based plant disease detection system that uses a Convolutional Neural Network (CNN) deployed via TensorFlow Lite. The application performs on-device inference to classify plant leaf images and predict the corresponding disease along with a confidence score.



The system supports both camera capture and gallery image selection, enabling offline and real-time disease detection on mobile devices.



Objectives



Detect plant diseases from leaf images using deep learning



Deploy a trained CNN model on Android using TensorFlow Lite



Perform fast, offline inference directly on the device



Provide a simple user interface for image-based disease prediction



System Workflow



User captures an image using the camera or selects one from the gallery



Image is resized and preprocessed on the device



TensorFlow Lite model performs inference



Predicted disease label and confidence score are displayed



Model Description



Model Type: Convolutional Neural Network (CNN)



Framework: TensorFlow / Keras



Deployment Format: Quantized TensorFlow Lite model (int8)



Input Size: 128 × 128 × 3 RGB image



Output: Probability scores for each disease class



The model is quantized to improve inference speed and reduce memory usage on mobile devices.



Android Application Implementation

Image Input



Camera capture using MediaStore.ACTION\_IMAGE\_CAPTURE



Gallery image selection using Intent.ACTION\_PICK



Preprocessing



Input image resized to 128 × 128



RGB pixel values extracted per channel



Data loaded into a direct ByteBuffer in native byte order



Inference



TensorFlow Lite Interpreter loads the model from the assets directory



Output tensor provides quantized confidence values



Confidence scores are dequantized and compared to select the top prediction



Output



Predicted disease label



Confidence score formatted and displayed to the user



User Interface



The application interface includes:



Image preview display



Button to capture image via camera



Button to select image from gallery



Text view displaying predicted disease and confidence score



UI is implemented using XML layouts with ConstraintLayout.



plant-disease-detection-android/

│

├── android-app/

│   ├── app/

│   │   ├── src/main/java/        # Java source code

│   │   ├── src/main/res/         # XML layouts and UI resources

│   │   ├── src/main/assets/      # TFLite model and labels

│   │   └── AndroidManifest.xml

│   ├── gradle/

│   ├── build.gradle.kts

│   ├── settings.gradle.kts

│   └── gradlew

│

├── ml-model/

│   ├── training/                # Model training scripts (not included)

│   ├── inference/               # Model conversion scripts

│   └── requirements.txt

│

├── docs/

│   └── screenshots/             # Application screenshots

│

├── .gitignore

└── README.md





Dataset



The dataset used to train the model is not included in this repository.



Typical dataset structure:

dataset/

├── Disease\_Class\_1/

├── Disease\_Class\_2/

└── Disease\_Class\_N/

Public datasets such as PlantVillage or custom-collected images may be used.



Setup and Execution



Clone the repository



Open the android-app/ directory in Android Studio



Allow Gradle to sync



Run the application on an emulator or physical Android device



Ensure the following files exist in:

android-app/app/src/main/assets/



plant\_disease\_int8.tflite



labels.txt



Limitations



Model predicts only among trained disease classes



Performance depends on image quality and lighting conditions



No severity estimation is currently implemented



Future Enhancements



Disease severity estimation



Explainability using Grad-CAM



Support for additional crops and diseases



Improved UI/UX and multilingual support



Author



Amrutanshu Sahoo



Final-year engineering project on plant disease detection using deep learning and mobile deployment.

