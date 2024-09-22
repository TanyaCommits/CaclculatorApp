package com.cs407.caclculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editText1 = findViewById<EditText>(R.id.number1)
        val editText2 = findViewById<EditText>(R.id.number2)
        val button1 = findViewById<Button>(R.id.addbutton)
        val button2 = findViewById<Button>(R.id.subtractbutton)
        val button3 = findViewById<Button>(R.id.multiplybutton)
        val button4 = findViewById<Button>(R.id.dividebutton)

        button1.setOnClickListener{
            val userInput1 = editText1.text.toString().toInt()
            val userInput2 = editText2.text.toString().toInt()

            val result = userInput1 + userInput2
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("ANSWER", result)
            startActivity(intent)

        }

        button2.setOnClickListener{
            val userInput1 = editText1.text.toString().toInt()
            val userInput2 = editText2.text.toString().toInt()

            val result = userInput1 - userInput2
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("ANSWER", result)
            startActivity(intent)

        }

        button3.setOnClickListener{
            val userInput1 = editText1.text.toString().toInt()
            val userInput2 = editText2.text.toString().toInt()

            val result = userInput1 * userInput2
            val intent = Intent(this, CalculatorResult::class.java)
            intent.putExtra("ANSWER", result)
            startActivity(intent)

        }

        button4.setOnClickListener{
            val userInput1 = editText1.text.toString().toInt()
            val userInput2 = editText2.text.toString().toInt()

            if (userInput2 != 0){
                val result = userInput1 / userInput2
                val intent = Intent(this, CalculatorResult::class.java)
                intent.putExtra("ANSWER", result)
                startActivity(intent)
            }

            else{
                Toast.makeText(this, "error: divide-by-zero", Toast.LENGTH_LONG).show()
        }

        }

    }
}