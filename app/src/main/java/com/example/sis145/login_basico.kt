package com.example.sis145

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class login_basico : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_basico)

        //vuelve transparente la barra de estado(donde esta lso iconos de señal,bateria,etc )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.apply {
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                statusBarColor = Color.TRANSPARENT
            }
        }

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val button_registrar = findViewById<View>(R.id.button_registrar)
        button_registrar.setOnClickListener {
            val etNombre = findViewById<EditText>(R.id.etNombre)
            val nombre = etNombre.text.toString()
            saveName(nombre)
            finish()
        }

    }

    private fun saveName(nombre: String) {
        val editor = sharedPreferences.edit()
        editor.putString("nombre", nombre)
        editor.apply()
    }
}