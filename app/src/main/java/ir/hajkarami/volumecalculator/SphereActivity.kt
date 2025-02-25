package ir.hajkarami.volumecalculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ir.hajkarami.volumecalculator.databinding.ActivitySphereBinding

class SphereActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySphereBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySphereBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.apply {
            btnCalculate.setOnClickListener {
                val radius = binding.inputEditTest.text.toString()
                val r = radius.toDoubleOrNull()

                if (r == null || r <= 0) {
                    textResult.text = "Please enter a valid value."
                    return@setOnClickListener
                }

                val volume = (4.0 / 3.0) * Math.PI * r * r * r
                textResult.text = "V = %.2f m³".format(volume)
            }
        }
    }
}
