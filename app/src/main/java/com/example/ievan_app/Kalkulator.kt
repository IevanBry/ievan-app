package com.example.ievan_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class Kalkulator : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kalkulator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var input1: EditText = findViewById(R.id.input1)
        var input2: EditText = findViewById(R.id.input2)
        var button1 : Button = findViewById(R.id.pangkat)
        var button2: Button = findViewById(R.id.tambah)
        var button3: Button = findViewById(R.id.next)
        var logout: Button = findViewById(R.id.logout)
        var hasil1: TextView = findViewById(R.id.hasilPangkat)
        var hasil2: TextView = findViewById(R.id.hasil)

        button1.setOnClickListener{
            if(input1.text.toString().isEmpty()){
                hasil1.setText("Tolong inputkan sesuatu")
            }
            else{
                var a = input1.text.toString()
                var c = a.toInt() * a.toInt()
                hasil1.setText(c.toString())
            }
        }

        button2.setOnClickListener{
            if(input1.text.toString().isEmpty() || input2.text.toString().isEmpty()){
                hasil2.setText("Tolong inputkan sesuatu")
            }
            else{
                var a = input1.text.toString()
                var b = input2.text.toString()

                var c = a.toInt() + b.toInt()
                hasil2.setText(c.toString())

            }
        }
        button3.setOnClickListener{
            var i = Intent(this, activity_kedua::class.java)
            startActivity(i)
        }

        logout.setOnClickListener{
            finish()
        }
    }
}