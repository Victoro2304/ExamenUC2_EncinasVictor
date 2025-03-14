package mx.edu.itson.examen_uc2_encinasvctor

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class detalle_producto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_producto)

        val ivImagen: ImageView = findViewById(R.id.ivComidaImagen)
        val tvNombre: TextView = findViewById(R.id.tvNombreComida)
        val tvPrecio : TextView = findViewById(R.id.tvPrecioComida)

        val bundle = intent.extras
        if (bundle!=null){
            ivImagen.setImageResource(bundle.getInt("imagen"))
            tvNombre.setText(bundle.getString("nombre"))
            tvPrecio.setText(bundle.getString("precio"))
        }
    }
}