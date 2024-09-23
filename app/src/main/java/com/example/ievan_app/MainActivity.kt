package com.example.ievan_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
        var input1: EditText = findViewById(R.id.editTextNumber)
        var input2: EditText = findViewById(R.id.editTextNumber2)
        var btnHitung1: Button = findViewById(R.id.button)
        var btnHitung2: Button = findViewById(R.id.button3)
        var result1: TextView = findViewById(R.id.textView)
        var result2: TextView = findViewById(R.id.textView3)

        btnHitung1.setOnClickListener {
            if (input1.text.toString() == "" || input2.text.toString() == "") {
                result1.setText("Tolong inputkan angka")
            } else {
                var a = input1.text.toString()
                var c = input2.text.toString()
                var b = a.toInt() * c.toInt()

                result1.setText(b.toString())
                println("Masuk pak eko ! angkanya: " + a)
            }
        }

        btnHitung2.setOnClickListener({
            if (input2.text.toString() == "") {
                result2.setText("Tolong inputkan angka")
            } else {
                var a = input2.text.toString()
                var b = a.toInt() * a.toInt()

                result2.setText(b.toString())
            }
        })
    }
}