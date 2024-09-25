package com.example.cc17_3k_pacalsojjc_act4

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.text.Typography.times

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val costOfService = findViewById<EditText>(R.id.editText)
        val tipAmazing = findViewById<RadioButton>(R.id.radioButton)
        val tipGood = findViewById<RadioButton>(R.id.radioButton2)
        val tipOk = findViewById<RadioButton>(R.id.radioButton3)
        val roundUpSwitch = findViewById<Switch>(R.id.switch1)
        val calcButton = findViewById<Button>(R.id.button2)
        val tipResult = findViewById<TextView>(R.id.textView)

        calcButton.setOnClickListener{
            val cost1 = costOfService.text.toString()

            if (cost1.isBlank()){
                tipResult.text = " "
                return@setOnClickListener
            }
            val cost2 = cost1.toDouble()
            if(cost2.toDouble() == null || cost2.toDouble() <= 0){
                tipResult.text = "Input wrong "
                return@setOnClickListener
            }

            val Percentage:Double = when{
                tipAmazing.isChecked -> 0.2
                tipGood.isChecked -> 0.18
                tipOk.isChecked -> 0.15
                else -> 0.0
            }
            var tip = Percentage.times(cost2)
            if(roundUpSwitch.isChecked){
               tip = kotlin.math.ceil(tip)
            }
            tipResult.text = "Tip Amount :$tip"


        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}