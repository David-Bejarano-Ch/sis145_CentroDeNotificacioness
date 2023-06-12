package com.example.sis145

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager

class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //pantalla grande o full screen
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        Handler().postDelayed({
            val intent = Intent(this@splashScreen, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)

    }
}