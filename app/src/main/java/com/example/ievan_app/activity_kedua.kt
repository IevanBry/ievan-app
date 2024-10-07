package com.example.ievan_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class activity_kedua : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kedua)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var button1 : Button = findViewById(R.id.kembali)
        var button2 : Button = findViewById(R.id.snackBar)
        var button3 : Button =  findViewById(R.id.snackBar2)
        var button4 : Button = findViewById(R.id.alert)

        button1.setOnClickListener{
            finish()
        }

        button2.setOnClickListener{
            val view = this.findViewById<View>(android.R.id.content)
            val snackbar = Snackbar.make(view, "Hallo, ini Snackbar!", Snackbar.LENGTH_LONG)

            snackbar.setAction("Undo"){
                Toast.makeText(this, "Tombol Undo di-klik", Toast.LENGTH_LONG).show()
            }

            snackbar.show()
        }

        button3.setOnClickListener{
            showSnackBar("Snackbar dengan menggunakan function")
        }

        button4.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("Ini Judul Alert Box")
                .setMessage("Apakah anda yakin!")
                .setPositiveButton("yes"){dialogInterface, which->
                    dialogInterface.dismiss()
                    Toast.makeText(this, "Oke", Toast.LENGTH_LONG).show()
                }
                .setNegativeButton("No", null)
                .show()
        }
    }
    private fun showSnackBar(message: String)
    {
        val view = this.findViewById<View>(android.R.id.content)
        val snackbar = Snackbar.make(view,message,Snackbar.LENGTH_LONG)

        snackbar.show()
    }

}