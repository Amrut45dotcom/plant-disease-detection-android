**# 🌿 Plant Disease Detection Android Application**



**\[!\[Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com/)**

**\[!\[TensorFlow Lite](https://img.shields.io/badge/TensorFlow-Lite-orange.svg)](https://www.tensorflow.org/lite)**

**\[!\[License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)**



**An Android-based plant disease detection system powered by deep learning that enables farmers and gardeners to identify plant diseases in real-time using their smartphone cameras.**



**!\[App Demo](docs/screenshots/demo.gif)**



**## 📋 Table of Contents**



**- \[Overview](#overview)**

**- \[Features](#features)**

**- \[System Architecture](#system-architecture)**

**- \[Model Details](#model-details)**

**- \[Installation](#installation)**

**- \[Usage](#usage)**

**- \[Project Structure](#project-structure)**

**- \[Dataset](#dataset)**

**- \[Technology Stack](#technology-stack)**

**- \[Limitations](#limitations)**

**- \[Future Enhancements](#future-enhancements)**

**- \[Contributing](#contributing)**

**- \[License](#license)**

**- \[Author](#author)**



**## 🔍 Overview**



**This project implements an on-device plant disease detection system using a Convolutional Neural Network (CNN) deployed via TensorFlow Lite. The application performs real-time inference on mobile devices, enabling offline disease detection without requiring an internet connection.**



**### Key Highlights**



**- ✅ \*\*On-device inference\*\* - No internet connection required**

**- ✅ \*\*Real-time detection\*\* - Fast predictions using quantized models**

**- ✅ \*\*Dual input modes\*\* - Camera capture and gallery selection**

**- ✅ \*\*Lightweight deployment\*\* - Optimized TensorFlow Lite model**

**- ✅ \*\*User-friendly interface\*\* - Simple and intuitive design**



**## ✨ Features**



**- 📸 \*\*Camera Integration\*\*: Capture leaf images directly using your device camera**

**- 🖼️ \*\*Gallery Support\*\*: Select and analyze existing images from your photo library**

**- 🤖 \*\*Deep Learning Powered\*\*: CNN-based disease classification**

**- ⚡ \*\*Fast Inference\*\*: Optimized int8 quantized model for quick predictions**

**- 📊 \*\*Confidence Scores\*\*: View prediction confidence for each diagnosis**

**- 📱 \*\*Offline Capability\*\*: Works without internet connectivity**

**- 🎯 \*\*Accurate Detection\*\*: Trained on extensive plant disease datasets**



**## 🏗️ System Architecture**



**```**

**┌─────────────────────────────────────────────────────────┐**

**│                    User Interface                        │**

**│  (Camera Capture / Gallery Selection / Results Display) │**

**└──────────────────────┬──────────────────────────────────┘**

                       **│**

                       **▼**

**┌─────────────────────────────────────────────────────────┐**

**│              Image Preprocessing Layer                   │**

**│         (Resize to 128×128, RGB Normalization)          │**

**└──────────────────────┬──────────────────────────────────┘**

                       **│**

                       **▼**

**┌─────────────────────────────────────────────────────────┐**

**│           TensorFlow Lite Interpreter                    │**

**│              (Quantized CNN Model)                       │**

**└──────────────────────┬──────────────────────────────────┘**

                       **│**

                       **▼**

**┌─────────────────────────────────────────────────────────┐**

**│              Post-Processing Layer                       │**

**│    (Confidence Calculation / Label Mapping)             │**

**└─────────────────────────────────────────────────────────┘**

**```**



**### Workflow**



**1. \*\*Image Acquisition\*\*: User captures or selects a plant leaf image**

**2. \*\*Preprocessing\*\*: Image is resized to 128×128 and normalized**

**3. \*\*Inference\*\*: TensorFlow Lite model performs on-device prediction**

**4. \*\*Output\*\*: Disease label and confidence score are displayed**



**## 🧠 Model Details**



**| Parameter | Value |**

**|-----------|-------|**

**| \*\*Model Type\*\* | Convolutional Neural Network (CNN) |**

**| \*\*Framework\*\* | TensorFlow / Keras |**

**| \*\*Deployment Format\*\* | TensorFlow Lite (int8 quantized) |**

**| \*\*Input Shape\*\* | 128 × 128 × 3 (RGB) |**

**| \*\*Output\*\* | Confidence scores per disease class |**

**| \*\*Model Size\*\* | ~1-2 MB (quantized) |**



**### Quantization Benefits**



**- 🔽 \*\*Reduced Memory Footprint\*\*: 4× smaller than FP32 models**

**- ⚡ \*\*Faster Inference\*\*: Optimized for mobile CPUs**

**- 🔋 \*\*Lower Power Consumption\*\*: Extended battery life**

**- 📱 \*\*Better Performance\*\*: Smooth user experience**



**## 🚀 Installation**



**### Prerequisites**



**- Android Studio (latest version)**

**- Android SDK (API Level 21+)**

**- Physical Android device or emulator**

**- Git**



**### Steps**



**1. \*\*Clone the repository\*\***

   **```bash**

   **git clone https://github.com/yourusername/plant-disease-detection-android.git**

   **cd plant-disease-detection-android**

   **```**



**2. \*\*Open in Android Studio\*\***

   **- Launch Android Studio**

   **- Select "Open an existing project"**

   **- Navigate to the `android-app/` directory**



**3. \*\*Sync Gradle\*\***

   **- Allow Android Studio to sync Gradle dependencies**

   **- Wait for the build to complete**



**4. \*\*Verify Assets\*\***

   

   **Ensure the following files exist in `android-app/app/src/main/assets/`:**

   **- `plant\_disease\_int8.tflite` - The trained model**

   **- `labels.txt` - Disease class labels**



**5. \*\*Run the Application\*\***

   **- Connect your Android device or start an emulator**

   **- Click the "Run" button in Android Studio**

   **- Grant camera and storage permissions when prompted**



**## 📱 Usage**



**1. \*\*Launch the Application\*\***

   **- Open the app on your Android device**



**2. \*\*Capture or Select an Image\*\***

   **- \*\*Camera\*\*: Tap the camera button to capture a new image**

   **- \*\*Gallery\*\*: Tap the gallery button to select an existing image**



**3. \*\*View Results\*\***

   **- The predicted disease name will be displayed**

   **- Confidence score shows prediction certainty**

   **- Higher confidence indicates more reliable predictions**



**### Example Output**



**```**

**Prediction: Tomato Early Blight**

**Confidence: 94.7%**

**```**



**## 📂 Project Structure**



**```**

**plant-disease-detection-android/**

**│**

**├── android-app/**

**│   ├── app/**

**│   │   ├── src/**

**│   │   │   ├── main/**

**│   │   │   │   ├── java/              # Java source code**

**│   │   │   │   │   └── com/plantdisease/**

**│   │   │   │   │       ├── MainActivity.java**

**│   │   │   │   │       └── ImageClassifier.java**

**│   │   │   │   ├── res/               # UI resources**

**│   │   │   │   │   ├── layout/        # XML layouts**

**│   │   │   │   │   ├── drawable/      # Images and icons**

**│   │   │   │   │   └── values/        # Strings, colors, themes**

**│   │   │   │   ├── assets/            # Model files**

**│   │   │   │   │   ├── plant\_disease\_int8.tflite**

**│   │   │   │   │   └── labels.txt**

**│   │   │   │   └── AndroidManifest.xml**

**│   │   │   └── test/                  # Unit tests**

**│   │   └── build.gradle.kts           # App-level Gradle**

**│   │**

**│   ├── gradle/                        # Gradle wrapper**

**│   ├── build.gradle.kts               # Project-level Gradle**

**│   ├── settings.gradle.kts**

**│   └── gradlew**

**│**

**├── docs/**

**│   └── screenshots/                   # App screenshots**

**│**

**├── .gitignore**

**├── LICENSE**

**└── README.md**

**```**



**## 📊 Dataset**



**The model was trained on a comprehensive plant disease dataset. The training data is \*\*not included\*\* in this repository due to size constraints.**



**### Recommended Datasets**



**- \*\*\[PlantVillage Dataset](https://github.com/spMohanty/PlantVillage-Dataset)\*\*: 54,000+ images across 38 disease classes**

**- \*\*Custom datasets\*\*: Collect region-specific plant disease images**



**### Expected Dataset Structure**



**```**

**dataset/**

**├── Tomato\_Early\_Blight/**

**│   ├── image001.jpg**

**│   ├── image002.jpg**

**│   └── ...**

**├── Potato\_Late\_Blight/**

**│   └── ...**

**└── Healthy/**

    **└── ...**

**```**



**## 🛠️ Technology Stack**



**### Mobile Development**

**- \*\*Language\*\*: Java**

**- \*\*IDE\*\*: Android Studio**

**- \*\*UI Framework\*\*: Android XML Layouts (ConstraintLayout)**



**### Machine Learning**

**- \*\*Framework\*\*: TensorFlow / Keras**

**- \*\*Deployment\*\*: TensorFlow Lite**

**- \*\*Optimization\*\*: Post-training int8 quantization**



**### Key Libraries**

**- `org.tensorflow:tensorflow-lite` - Model inference**

**- `androidx.appcompat` - Modern Android components**

**- `androidx.constraintlayout` - Flexible UI layouts**



**## ⚠️ Limitations**



**- 🎯 \*\*Class Limitation\*\*: Predictions limited to trained disease classes**

**- 💡 \*\*Lighting Sensitivity\*\*: Accuracy depends on image quality and lighting**

**- 🔍 \*\*No Severity Estimation\*\*: Cannot assess disease progression stage**

**- 🌾 \*\*Crop Specific\*\*: Model trained on specific plant species**

**- 📐 \*\*Image Quality\*\*: Blurry or low-resolution images may reduce accuracy**



**## 🔮 Future Enhancements**



**- \[ ] \*\*Disease Severity Estimation\*\*: Assess progression stages (early/mid/late)**

**- \[ ] \*\*Model Explainability\*\*: Integrate Grad-CAM for visual explanations**

**- \[ ] \*\*Expanded Crop Support\*\*: Add more plant species and diseases**

**- \[ ] \*\*Treatment Recommendations\*\*: Suggest remedies for detected diseases**

**- \[ ] \*\*History Tracking\*\*: Save and track disease detections over time**

**- \[ ] \*\*Multi-language Support\*\*: Localization for different regions**

**- \[ ] \*\*Cloud Sync\*\*: Optional cloud backup and analytics**

**- \[ ] \*\*Improved UI/UX\*\*: Material Design 3 implementation**

**- \[ ] \*\*Social Features\*\*: Community-driven disease reporting**



**## 🤝 Contributing**



**Contributions are welcome! Please follow these steps:**



**1. Fork the repository**

**2. Create a feature branch (`git checkout -b feature/AmazingFeature`)**

**3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)**

**4. Push to the branch (`git push origin feature/AmazingFeature`)**

**5. Open a Pull Request**



**Please ensure your code follows the existing style and includes appropriate tests.**



**## 📄 License**



**This project is licensed under the MIT License - see the \[LICENSE](LICENSE) file for details.**



**## 👨‍💻 Author**



**\*\*Amrutanshu Sahoo\*\***



**Final-year engineering project on plant disease detection using deep learning and mobile deployment.**



**- 📧 Email: \[your.email@example.com](mailto:your.email@example.com)**

**- 🔗 LinkedIn: \[your-linkedin-profile](https://linkedin.com/in/your-profile)**

**- 🐱 GitHub: \[@yourusername](https://github.com/yourusername)**



**---**



**## 📸 Screenshots**



**<div align="center">**



**| Home Screen | Camera Capture | Results Display |**

**|-------------|----------------|-----------------|**

**| !\[Home](docs/screenshots/home.png) | !\[Camera](docs/screenshots/camera.png) | !\[Results](docs/screenshots/results.png) |**



**</div>**



**---**



**## 🙏 Acknowledgments**



**- TensorFlow team for TensorFlow Lite**

**- PlantVillage dataset contributors**

**- Android developer community**

**- All contributors and testers**



**---**



**<div align="center">**



**\*\*If you find this project helpful, please consider giving it a ⭐!\*\***



**Made with ❤️ for sustainable agriculture**



**</div>**



