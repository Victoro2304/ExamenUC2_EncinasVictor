package mx.edu.itson.examen_uc2_encinasvctor

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Productos : AppCompatActivity() {

    var adapter: ProductosAdapter? = null
    var productos = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)

        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductos(menuOption)

        adapter = ProductosAdapter(this, productos)
        var gridProductoos: GridView = findViewById(R.id.gridView)

        gridProductoos.adapter = adapter

    }

    fun agregarProductos(option: String?) {
        val titulo: ImageView = findViewById(R.id.imageView) as ImageView

        when (option) {
            "Cold Drinks" -> {
                titulo.setImageResource(R.drawable.colddrinks)
                productos.add(Producto("Caramel Frap", R.drawable.caramelfrap, 5.0))
                productos.add(Producto("Chocolate Frap", R.drawable.chocolatefrap, 6.0))
                productos.add(Producto("Cold Brew", R.drawable.coldbrew, 3.0))
                productos.add(Producto("Matcha Latte", R.drawable.matcha, 4.0))
                productos.add(Producto("Oreo Milkshake", R.drawable.oreomilkshake, 7.0))
                productos.add(Producto("Peanut Milkshake", R.drawable.peanutmilkshake, 7.0))
            }

            "Hot Drinks" -> {
                titulo.setImageResource(R.drawable.hotdrinks)
                productos.add(Producto("Latte", R.drawable.latte, 6.0))
                productos.add(Producto("Hot Chocolate", R.drawable.hotchocolate, 5.0))
                productos.add(Producto("Espresso", R.drawable.espresso, 4.0))
                productos.add(Producto("Chai Latte", R.drawable.chailatte, 6.0))
                productos.add(Producto("Capuccino", R.drawable.capuccino, 7.0))
                productos.add(Producto("American Coffee", R.drawable.americano, 2.0))
            }

            "Sweets" -> {
                titulo.setImageResource(R.drawable.sweets)
                productos.add(Producto("Blueberry Cake", R.drawable.blueberrycake, 6.0))
                productos.add(Producto("Chocolate Cupcake", R.drawable.chocolatecupcake, 3.0))
                productos.add(Producto("Lemon Tartalette", R.drawable.lemontartalette, 4.0))
                productos.add(Producto("Red Velvet Cake", R.drawable.redvelvetcake, 6.0))
                productos.add(Producto("Cherry Cheesecake", R.drawable.strawberrycheesecake, 7.0))
                productos.add(Producto("Tiramisu", R.drawable.tiramisu, 6.0))
            }

            "Salties" -> {
                titulo.setImageResource(R.drawable.salties)
                productos.add(Producto("Chicken Crepes", R.drawable.chickencrepes, 6.0))
                productos.add(Producto("Club Sandwich", R.drawable.clubsandwich, 5.0))
                productos.add(Producto("Panini", R.drawable.hampanini, 4.0))
                productos.add(Producto("Philly Cheese Steak", R.drawable.phillycheesesteak, 6.0))
                productos.add(Producto("Nachos", R.drawable.nachos, 7.0))
            }
        }
    }
}

class ProductosAdapter: BaseAdapter {
    var productos = ArrayList<Producto>()
    var context : Context? = null

    constructor(context: Context, producto: ArrayList<Producto>){
        this.productos = producto
        this.context = context
    }

    override fun getCount(): Int {
        return productos.size
    }

    override fun getItem(position: Int): Any {
        return productos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var prod = productos[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var vista = inflator.inflate(R.layout.producto_view, null)

        var imagen = vista.findViewById(R.id.producto_img) as ImageView
        var nombre = vista.findViewById(R.id.producto_nombre) as TextView

        imagen.setImageResource(prod.image)
        nombre.setText(prod.name)

        imagen.setOnClickListener() {
            val intento = Intent(context, detalle_producto::class.java)
            intento.putExtra("nombre", prod.name)
            intento.putExtra("imagen", prod.image)
            intento.putExtra("precio", "$${prod.price}")
            context!!.startActivity(intento)
        }

        return vista
    }
}
