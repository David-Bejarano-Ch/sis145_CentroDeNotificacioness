package com.example.sis145

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu

class MainActivity : AppCompatActivity() {
    //variable del image button declarada
    private lateinit var imageButton2: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // vuelve transparente los iconos del movil (Donde sale la hora,la señal,etc,etc)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.apply {
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                statusBarColor = Color.WHITE
                statusBarColor = Color.TRANSPARENT// Reemplaza con el color que desees utilizar
            }
        }
        //

        setContentView(R.layout.activity_main)

        /*creacion de los botones*/

        val btn_grupos = findViewById<Button>(R.id.btn_grupos) as Button
        val btn_temas = findViewById<Button>(R.id.btn_temas) as Button


    // botones de la pagina principal que llevan a sus propias pantallas
        btn_grupos.setOnClickListener() {
            val intent = Intent(this@MainActivity, grupos::class.java)
            startActivity(intent)
        }
        btn_temas.setOnClickListener() {
            val intent = Intent(this@MainActivity, temas::class.java)
            startActivity(intent)
        }


        imageButton2 = findViewById(R.id.imageButton2)
        imageButton2.setOnClickListener {
            showPopupMenu()
        }

    }

    //Crea el menu desplazable
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_dropdown, menu)
        return true
    }

    //menu desplazable llamadas a sus IDs.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item1 -> {
                // Acción para la opción 1
                true
            }
            R.id.menu_item2 -> {
                // Acción para la opción 2 (llamada a la clase AcercaDe archivo .kt)
                val intent = Intent(this, AcercaDe::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_item3 -> {
                // Acción para la opción 2
                true
            }
            R.id.menu_item4 -> {
                // Acción para la opción 3
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //metodo clic al boton imagen desplazable
    private fun showPopupMenu() {
        val popupMenu = PopupMenu(this, imageButton2, Gravity.END)
        popupMenu.menuInflater.inflate(R.menu.menu_dropdown, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            onOptionsItemSelected(item)
        }
        popupMenu.show()
    }

}