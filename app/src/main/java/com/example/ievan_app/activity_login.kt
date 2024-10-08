package com.example.ievan_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class activity_login : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var button1 : Button = findViewById(R.id.kalkulator)
        var button2 : Button = findViewById(R.id.regist)
        var username: TextView = findViewById(R.id.username)
        var password: TextView = findViewById(R.id.password)

//        val sharedPref: SharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val usernameVal = sharedPref.getString("username", null)
        val passwordVal = sharedPref.getString("password", null)
        
        button1.setOnClickListener{
            val a = username.text.toString()
            val b = password.text.toString()

            if(a == usernameVal && b == passwordVal){

                // Penggunaan Shared Preferences
//                val editor = sharedPref.edit()
//                editor.putString("username", a)
//                editor.apply()

                val i = Intent(this, Kalkulator::class.java)
                startActivity(i)
            } else {
                showSnackBar("Username atau password salah")
            }
        }

        button2.setOnClickListener{
            val i = Intent(this, activity_registrasi::class.java)
            startActivity(i)
        }
    }
    
    private fun showSnackBar(message: String)
    {
        val view = this.findViewById<View>(android.R.id.content)
        val snackbar = Snackbar.make(view,message, Snackbar.LENGTH_LONG)

        snackbar.show()
    }
}