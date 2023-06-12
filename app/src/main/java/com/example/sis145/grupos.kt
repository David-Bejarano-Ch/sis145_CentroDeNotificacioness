package com.example.sis145
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat

class grupos : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grupos)
        //barra de estado color transparente
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.apply {
                addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                statusBarColor = Color.TRANSPARENT
            }
        }

        //toolbar
        toolbar = findViewById(R.id.toolbar2)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
        //cambia color al navigation icon
        toolbar.navigationIcon?.setColorFilter(0xFF000000.toInt(), PorterDuff.Mode.SRC_ATOP)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
