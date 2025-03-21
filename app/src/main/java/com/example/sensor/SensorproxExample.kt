package com.example.sensor

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SensorproxExample : AppCompatActivity(), SensorEventListener {


    private lateinit var sensorManager: SensorManager
    private var proximitySensor: Sensor? = null
    private lateinit var layout: ConstraintLayout
    private lateinit var proximityTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sensorprox_example)


        layout = findViewById(R.id.layout)
        proximityTextView = findViewById(R.id.proximityTextView)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)


        if (proximitySensor == null) {
            proximityTextView.text = "Proximity sensor not availabe"
        }
    }


    override fun onResume() {
        super.onResume()

        proximitySensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)

        }

    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_PROXIMITY) {
            val distance = event.values[0]
            proximitySensor?.let { sensor ->
                if (distance < sensor.maximumRange) {
                    layout.setBackgroundColor(Color.RED)
                    proximityTextView.text = "Object is near: $distance"
                } else {
                    layout.setBackgroundColor(Color.YELLOW)
                    proximityTextView.text = "Object is far: $distance"
                }


            } ?: run {
                proximityTextView.text = "Proximity sensor is not available"
            }
        }


    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }
}

