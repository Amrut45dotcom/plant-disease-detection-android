**# Plant Disease Detection Android Application**



**## Overview**

**This project is an Android-based plant disease detection system that uses a**

**Convolutional Neural Network (CNN) deployed via TensorFlow Lite.**



**The application performs \*\*on-device inference\*\* to classify plant leaf images**

**and predict the corresponding disease along with a confidence score.**



**The system supports both \*\*camera capture\*\* and \*\*gallery image selection\*\*,**

**enabling offline and real-time disease detection on mobile devices.**



**---**



**## Objectives**

**- Detect plant diseases from leaf images using deep learning**

**- Deploy a trained CNN model on Android using TensorFlow Lite**

**- Perform fast, offline inference directly on the device**

**- Provide a simple user interface for image-based disease prediction**



**---**



**## System Workflow**

**1. User captures an image using the camera or selects one from the gallery**

**2. Image is resized and preprocessed on the device**

**3. TensorFlow Lite model performs inference**

**4. Predicted disease label and confidence score are displayed**



**---**



**## Model Description**

**- \*\*Model Type:\*\* Convolutional Neural Network (CNN)**

**- \*\*Framework:\*\* TensorFlow / Keras**

**- \*\*Deployment Format:\*\* Quantized TensorFlow Lite model (int8)**

**- \*\*Input Size:\*\* 128 × 128 × 3 RGB image**

**- \*\*Output:\*\* Confidence scores for each disease class**



**The model is quantized to reduce memory footprint and improve inference speed**

**on mobile devices.**



**---**



**## Android Application Implementation**



**### Image Input**

**- Camera capture using `MediaStore.ACTION\_IMAGE\_CAPTURE`**

**- Gallery image selection using `Intent.ACTION\_PICK`**



**### Preprocessing**

**- Input image resized to 128 × 128**

**- RGB pixel values extracted per channel**

**- Data loaded into a direct `ByteBuffer` using native byte order**



**### Inference**

**- TensorFlow Lite `Interpreter` loads the model from the assets directory**

**- Output tensor provides quantized confidence values**

**- Top prediction is selected using maximum confidence score**



**### Output**

**- Predicted disease label**

**- Confidence score displayed to the user**



**---**



**## User Interface**

**The user interface is implemented using XML layouts with `ConstraintLayout` and includes:**

**- Image preview display**

**- Button to capture image via camera**

**- Button to select image from gallery**

**- Text view displaying predicted disease and confidence score**



**---**



**## Project Structure**

**plant-disease-detection-android/**

**│**

**├── android-app/**

**│ ├── app/**

**│ │ ├── src/main/java/ # Java source code**

**│ │ ├── src/main/res/ # XML layouts and UI resources**

**│ │ ├── src/main/assets/ # TFLite model and labels**

**│ │ └── AndroidManifest.xml**

**│ │**

**│ ├── gradle/**

**│ ├── build.gradle.kts**

**│ ├── settings.gradle.kts**

**│ └── gradlew**

**│**

**├── docs/**

**│ └── screenshots/**

**│**

**├── .gitignore**

**└── README.md**



**---**



**## Dataset**

**The dataset used to train the model is \*\*not included\*\* in this repository.**



**Typical dataset structure:**

**dataset/**

**├── Disease\_Class\_1/**

**├── Disease\_Class\_2/**

**└── Disease\_Class\_N/**



**Public datasets such as PlantVillage or custom-collected datasets may be used.**



**---**



**## Setup and Execution**

**1. Clone the repository**

**2. Open the `android-app/` directory in Android Studio**

**3. Allow Gradle to sync**

**4. Run the application on an emulator or physical Android device**



**Ensure the following files exist in:**

**android-app/app/src/main/assets/**

**- `plant\_disease\_int8.tflite`**

**- `labels.txt`**



**---**



**## Limitations**

**- Prediction limited to trained disease classes**

**- Accuracy depends on image quality and lighting conditions**

**- Disease severity estimation is not implemented**



**---**



**## Future Enhancements**

**- Disease severity estimation**

**- Model explainability using Grad-CAM**

**- Support for additional crops and diseases**

**- Improved UI/UX and multilingual support**



**---**



**## Author**

**\*\*Amrutanshu Sahoo\*\***



**Final-year engineering project on plant disease detection using deep learning**

**and mobile deployment.**



