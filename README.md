                                                        Light Sensor Example 💡📱
This Android app demonstrates how to use the light sensor to detect ambient light levels and control a flashlight (torch) accordingly. It also updates an image of a bulb to indicate the flashlight's status.

📌 Features
Uses the light sensor to measure ambient light intensity.

Turns the flashlight (torch) ON when light intensity is greater than 18 lx.

Turns the flashlight OFF when light intensity is lower than 18 lx.

Changes the bulb image based on the flashlight's state.

Works with the device's camera flash to simulate a real flashlight.

🛠 Technologies Used
Kotlin

Android Sensor API

Camera2 API

ConstraintLayout

📜 Code Explanation
SensorLightExample.kt (Main Activity)
This class implements SensorEventListener to listen for light sensor changes.

🔹 onCreate()
Initializes the SensorManager to access the light sensor.

Finds the ImageView for displaying a bulb image.

Initializes the CameraManager to control the device’s flashlight.

🔹 onResume()
Registers the light sensor listener when the app resumes.

🔹 onPause()
Unregisters the sensor listener when the app is paused to save battery.

🔹 onSensorChanged()
Reads the light intensity value from the sensor.

If the value is greater than 18 lx, it:

Turns on the flashlight.

Updates the bulb image to show a lit bulb.

If the value is less than 18 lx, it:

Turns off the flashlight.

Updates the bulb image to show a dimmed bulb.

🔹 controlFlashlight()
Uses the Camera2 API to turn the device’s flashlight ON or OFF.

📷 Screenshots
(Add screenshots of your app here if available)

🚀 How to Run
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/light-sensor-app.git
Open the project in Android Studio.

Run the app on a real device (emulators don’t have light sensors or flashlights).

Test the sensor by covering or exposing the phone’s light sensor.

📜 License
This project is open-source and free to use.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                                        Proximity Sensor Example 📱🔍
This Android app demonstrates how to use the proximity sensor to detect objects near the device and change the background color accordingly.

📌 Features
Uses the proximity sensor to detect nearby objects.

Changes the background color based on object distance:

Red when an object is near.

Yellow when an object is far.

Displays real-time distance readings from the sensor.

Checks if the device has a proximity sensor and informs the user if unavailable.

🛠 Technologies Used
Kotlin

Android Sensor API

ConstraintLayout

📜 Code Explanation
SensorproxExample.kt (Main Activity)
This class implements SensorEventListener to listen for proximity sensor events.

🔹 onCreate()
Initializes the SensorManager to access the proximity sensor.

Finds the ConstraintLayout and TextView for UI updates.

Checks if the device has a proximity sensor and displays a message if unavailable.

🔹 onResume()
Registers the proximity sensor listener when the app resumes.

🔹 onPause()
Unregisters the sensor listener when the app is paused to save battery.

🔹 onSensorChanged()
Reads the distance value from the proximity sensor.

If the object is near, it:

Changes the background color to red.

Updates the text to "Object is near".

If the object is far, it:

Changes the background color to yellow.

Updates the text to "Object is far".

📷 Screenshots
(Add screenshots of your app here if available)

🚀 How to Run
Clone the repository:

bash
Copy
Edit
git clone https://github.com/yourusername/proximity-sensor-app.git
Open the project in Android Studio.

Run the app on a real device (emulators do not support proximity sensors).

Place an object close to the phone’s sensor (usually near the earpiece) to see the background change.

📜 License
This project is open-source and free to use.
