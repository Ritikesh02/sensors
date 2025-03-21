package com.example.sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SensorLightExample : AppCompatActivity(), SensorEventListener {
    private var sensorManager: SensorManager? = null
    private var sensor: Sensor? = null
    private var image: ImageView? = null
    private var bulb: Boolean = true
    private var cameraManager: CameraManager? = null
    private var cameraId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sensor_light_example)

        image = findViewById(R.id.imageView)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager?.getDefaultSensor(Sensor.TYPE_LIGHT)


        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            cameraId = cameraManager?.cameraIdList?.get(0)
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            val lightValue = event.values[0]

            //Toast.makeText(this, "Light Intensity: $lightValue lx", Toast.LENGTH_SHORT).show()

            if (lightValue > 18) {
                if (bulb) {
                    image?.setImageResource(R.drawable.bulb)
                    controlFlashlight(true)
                    bulb = false
                }
            } else {
                bulb = true
                image?.setImageResource(R.drawable.bulb2)
                controlFlashlight(false)
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }


    private fun controlFlashlight(turnOn: Boolean) {
        try {
            cameraId?.let {
                cameraManager?.setTorchMode(it, turnOn)
            }
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }
}
