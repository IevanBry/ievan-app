package com.example.ievan_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
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

        var username: TextView = findViewById(R.id.sessionUsername)
        var input1: EditText = findViewById(R.id.input1)
        var input2: EditText = findViewById(R.id.input2)
        var button1 : Button = findViewById(R.id.pangkat)
        var button2: Button = findViewById(R.id.tambah)
        var button3: Button = findViewById(R.id.next)
        var logout: Button = findViewById(R.id.logout)
        var hasil1: TextView = findViewById(R.id.hasilPangkat)
        var hasil2: TextView = findViewById(R.id.hasil)

        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val usernameVal = sharedPref.getString("username", null)

        username.text = "Hai, $usernameVal"

        button1.setOnClickListener{
            if(input1.text.toString().isEmpty()){
//                hasil1.setText("Tolong inputkan sesuatu")
                showSnackBar("Ada kolom yang belum kamu input")
            }
            else{
                var a = input1.text.toString()
                var c = a.toInt() * a.toInt()
                hasil1.setText(c.toString())
            }
        }

        button2.setOnClickListener{
            if(input1.text.toString().isEmpty() || input2.text.toString().isEmpty()){
//                hasil2.setText("Tolong inputkan sesuatu")
                showSnackBar("Ada kolom yang belum kamu input")
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
            i.putExtra("username", "Ievan")
            i.putExtra("password", "ievan")
            startActivity(i)
        }

        logout.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("System")
                .setMessage("Apakah anda yakin ingin logout!")
                .setPositiveButton("yes"){dialogInterface, which->
                    Toast.makeText(this, "Berhasil Logout!", Toast.LENGTH_LONG).show()
                    finish()
                }
                .setNegativeButton("No", null)
                .show()
        }
    }
    private fun showSnackBar(message: String)
    {
        val view = this.findViewById<View>(android.R.id.content)
        val snackbar = Snackbar.make(view,message, Snackbar.LENGTH_LONG)

        snackbar.show()
    }
}