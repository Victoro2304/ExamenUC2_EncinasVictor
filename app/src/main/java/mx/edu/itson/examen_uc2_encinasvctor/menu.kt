package mx.edu.itson.examen_uc2_encinasvctor

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        var btnColdDrinks = findViewById<Button>(R.id.btnColdDrinks)
        var btnHotDrinks = findViewById<Button>(R.id.btnHotDrinks)
        var btnSweets = findViewById<Button>(R.id.btnSweets)
        var btnSalties = findViewById<Button>(R.id.btnSalties)


        btnColdDrinks.setOnClickListener {
            var intent: Intent = Intent(this, Productos::class.java)
            intent.putExtra("menuType", "Cold Drinks")
            startActivity(intent)
        }

        btnHotDrinks.setOnClickListener {
            var intent: Intent = Intent(this, Productos::class.java)
            intent.putExtra("menuType", "Hot Drinks")
            startActivity(intent)
        }

        btnSweets.setOnClickListener {
            var intent: Intent = Intent(this, Productos::class.java)
            intent.putExtra("menuType", "Sweets")
            startActivity(intent)
        }

        btnSalties.setOnClickListener {
            var intent: Intent = Intent(this, Productos::class.java)
            intent.putExtra("menuType", "Salties")
            startActivity(intent)
        }

    }
}