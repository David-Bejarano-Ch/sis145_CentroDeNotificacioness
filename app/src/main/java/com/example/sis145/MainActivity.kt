package com.example.sis145

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class MainActivity : AppCompatActivity() {
    //variable del image button declarada
    private lateinit var imageButton2: ImageButton
    private lateinit var sharedPreferences: SharedPreferences



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

                //codigo bienvenida saludo
                sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                val nombre = getSavedName()
                showSaludo(nombre)


                /*creacion de los botones*/

                val btn_grupos = findViewById<Button>(R.id.btn_grupos) as Button
                val btn_calendario = findViewById<Button>(R.id.btn_calendario) as Button


            // botones de la pagina principal que llevan a sus propias pantallas
                btn_grupos.setOnClickListener() {
                    val intent = Intent(this@MainActivity, grupos::class.java)
                    startActivity(intent)
                }
                btn_calendario.setOnClickListener() {
                    val intent = Intent(this@MainActivity, calendario::class.java)
                    startActivity(intent)
                }


                imageButton2 = findViewById(R.id.imageButton2)
                imageButton2.setOnClickListener {
                    showPopupMenu()
                }



    }
        //Codigo aviso de bienvenida
    private fun getSavedName(): String {
        return sharedPreferences.getString("nombre", "") ?: ""
    }
    private fun showSaludo(nombre: String) {
        val saludo = "Hola, $nombre!!"
        Toast.makeText(this, saludo, Toast.LENGTH_SHORT).show()
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
                val intent = Intent(this, login_basico::class.java)
                startActivity(intent)
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
                val intent = Intent(this, Ayuda::class.java)
                startActivity(intent)
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