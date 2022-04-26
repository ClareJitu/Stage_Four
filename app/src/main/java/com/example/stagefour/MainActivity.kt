package com.example.stagefour

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


private const val STATE_OPERAND1 = "Operand1"
private const val STATE_OPERAND1_STORED = "Operand1_STORED"

class MainActivity : AppCompatActivity() {
    private lateinit var result: EditText
    private lateinit var inputNumber: EditText

    private var operand1: Double? = null
    private val unit = 3.28084


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val buttonDot: Button = findViewById(R.id.buttonDot)
        val button10: Button = findViewById(R.id.button10)
        val buttonX: Button = findViewById(R.id.buttonX)
        val buttonClear: Button = findViewById(R.id.buttonClear)
        val buttonR: Button = findViewById(R.id.buttonR)
        val buttonConvert: Button = findViewById(R.id.buttonConvert)
        val buttonRate: Button = findViewById(R.id.buttonRate)
        val buttonCalculator: Button = findViewById(R.id.buttonCalculator)

        val listener = View.OnClickListener { v ->
            v as Button
            result.setText(" ")
        }
        button7.setOnClickListener(listener)
        button8.setOnClickListener(listener)
        button9.setOnClickListener(listener)
        button6.setOnClickListener(listener)
        button5.setOnClickListener(listener)
        button4.setOnClickListener(listener)
        button3.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button1.setOnClickListener(listener)
        button10.setOnClickListener(listener)
        buttonDot.setOnClickListener(listener)
        buttonRate.setOnClickListener(listener)
        buttonCalculator.setOnClickListener(listener)
        buttonConvert.setOnClickListener{ convertUnit() }
        buttonClear.setOnClickListener{ clearInput() }
        buttonX.setOnClickListener{ deleteNumber() }
        buttonR.setOnClickListener{ clearAll() }

    }
    private fun clearInput(){
        inputNumber.setText("")//clear input when clicked
    }
    private fun clearAll(){
        inputNumber.setText("")
        result.setText("")
        //clear both sections when clicked
    }
    private fun deleteNumber(){
        val value :Editable = inputNumber.text
        if(value.isNotEmpty()){
         inputNumber.text = value.dropLast(1) as Editable?
    }
}
    private fun convertUnit(){
        val value = inputNumber.text.toString().toDoubleOrNull()

        val result = value!! * unit
        if (operand1!= null){
            kotlin.math.ceil(result)

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (operand1 != null){
            outState.putDouble(STATE_OPERAND1, operand1!!)
            outState.putBoolean(STATE_OPERAND1_STORED, true)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        operand1 = if (savedInstanceState.getBoolean(STATE_OPERAND1_STORED, false )) {
            savedInstanceState.getDouble(STATE_OPERAND1)
        } else {
            null
        }
    }

}