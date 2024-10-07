package com.example.ievan_app

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class activity_registrasi : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registrasi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username : EditText = findViewById(R.id.username)
        val password : EditText = findViewById(R.id.password)
        val confirmPassword : EditText = findViewById(R.id.confirmPassword)
        val regist : Button = findViewById(R.id.regist)

        val sharedPref: SharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        regist.setOnClickListener{
            val a = username.text.toString()
            val b = password.text.toString()
            val c = confirmPassword.text.toString()

            if(a.isNotEmpty() && b.isNotEmpty() && c.isNotEmpty()){
                if(b == c){
                    val editor = sharedPref.edit()
                    editor.putString("username", a)
                    editor.putString("password", b)
                    editor.apply()

                    showSnackBar("User Berhasil di buat")
                    val i = Intent(this, activity_login::class.java)
                    startActivity(i)
                    finish()
                } else {
                    showSnackBar("Password dan Confirm Password belum sama")
                }
            } else {
                showSnackBar("Tolong inputkan kolom yang belum diisi")
            }
        }

    }
    private fun showSnackBar(message: String)
    {
        val view = this.findViewById<View>(android.R.id.content)
        val snackbar = Snackbar.make(view,message, Snackbar.LENGTH_LONG)

        snackbar.show()
    }
}