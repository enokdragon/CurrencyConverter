package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val convertMoney = findViewById<EditText>(R.id.txtAmount)
        val radioBtn1 = findViewById<RadioButton>(R.id.radioBtn1)
        val radioBtn2 = findViewById<RadioButton>(R.id.radioBtn2)
        val result = findViewById<TextView>(R.id.txtResult)
        val convertIt = findViewById<Button>(R.id.idBtnConvert)

        convertIt.setOnClickListener{
            val currencyFormat = DecimalFormat("$##,###.##")
            val conversionAmt = convertMoney.text.toString().toDouble()
            val conversionRate = 1.53 //american:aus, 1:1.53
            var finalNumber: Double?

            if (radioBtn1.isChecked) {
                if (conversionAmt <= 10000) {
                    finalNumber = conversionAmt * conversionRate
                    val finalFormat = currencyFormat.format(finalNumber)
                    result.text = "$finalFormat USD"
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Amount must be less than 10,000.01",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            if (radioBtn2.isChecked) {
                if (conversionAmt <= 10000) {
                    finalNumber = conversionAmt / conversionRate
                    val finalFormat = currencyFormat.format(finalNumber)
                    result.text = finalFormat + " AUD"
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Amount must be less than 10,000.01",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    }
}