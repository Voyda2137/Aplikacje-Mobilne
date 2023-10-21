package com.example.zadanie2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var fahrenheitView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        try{
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            editText = findViewById(R.id.editText)
            button = findViewById(R.id.button)
            textView = findViewById(R.id.textView)
            fahrenheitView = findViewById(R.id.fahrenheitView)
            button.setOnClickListener {
                val enteredText = editText.text
                if (enteredText.isNotBlank()) {
                    val degreesCelsius = enteredText.toString().toFloat()
                    GlobalScope.launch(Dispatchers.Default) {
                        val fahrenheit = calculateFahrenheit(degreesCelsius)
                        withContext(Dispatchers.Main) {
                            textView.text = "Podane stopnie $degreesCelsius°C"
                            fahrenheitView.text = fahrenheit
                        }
                    }
                }
            }
        }
         catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun calculateFahrenheit(degrees: Float): String {
        var degreesInFahrenheit = (degrees * 9 / 5) + 32
        return "Przekonwertowane stopnie $degreesInFahrenheit°F"
    }
}
