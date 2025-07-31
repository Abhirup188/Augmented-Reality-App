🛠️ AR Drill Selection App
An Android Augmented Reality (AR) application that allows users to select different types of drills, view detailed information about them, and visualize a placeholder drill in their physical environment using AR.

📱 Features
🔽 Drill Selector UI

Dropdown list with mock drill types: Corded Electric Drill, Rotary Hammer Drill, Impact Percussion Drill.

Displays:

Image of the selected drill

Description

Usage Tips

Back navigation support

📷 AR Integration

Built with Sceneform and ARCore

Camera permission handling

Tap on flat surface to place a colored cube representing the selected drill

Only one cube can be placed at a time

💡 State Handling

Preserves state (drill details) across screen rotations

Uses Jetpack Compose for modern UI design

🧰 Tech Stack
Kotlin

Jetpack Compose

Android Navigation Compose

Sceneform 1.17.1

ARCore

AppCompat + Lifecycle KTX

🚀 How to Use
Clone the repo and open in Android Studio.

Ensure your physical device supports ARCore.

Install the app on a real device.

Select a drill from the dropdown.

Tap Start AR Drill to open the camera.

Tap on any flat surface to place a colored cube.

✅ Completed Assignment Requirements
✔️ Drill selector UI with dropdown
✔️ Drill-specific page with image, description, and tips
✔️ AR screen with camera + tap-to-place drill representation
✔️ Mock drill names
✔️ One drill object placement logic
✔️ State persistence on rotation
✔️ Clean and modular codebase
✔️ Only One Drill can be placed

🏁 Future Improvements
Replace placeholder cubes with 3D drill models (.glb/.gltf)

Add real-time drill scaling or rotation gestures

Upload user's own drill images

Add audio instructions or voice-over

🛡️ Permissions
android.permission.CAMERA – Required for ARCore to access the device camera.

🧑‍💻 Author
Abhirup Chakraborty
Final Year BTech, NIT Silchar
