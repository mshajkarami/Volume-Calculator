package ir.hajkarami.volumecalculator

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ir.hajkarami.volumecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var shapeArrayList: ArrayList<Shape>
    private lateinit var adapter: MyCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        shapeArrayList = ArrayList()

        val shape1: Shape = Shape("Sphere", R.drawable.sphere)
        val shape2: Shape = Shape("Cylinder", R.drawable.cylinder)
        val shape3: Shape = Shape("Cube", R.drawable.cube)
        val shape4: Shape = Shape("Prism", R.drawable.prism)



        shapeArrayList.add(shape1)
        shapeArrayList.add(shape2)
        shapeArrayList.add(shape3)
        shapeArrayList.add(shape4)

        adapter = MyCustomAdapter(this,shapeArrayList)

        binding.apply {
            gridView.adapter = adapter
            gridView.numColumns = 2
        }

    }
}