package com.example.myapplication3

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication3.databinding.Layout2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: Layout2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = Layout2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val message: String = intent.extras?.getString("myLittleTextForSecondActivity") ?: ""
        binding.myTextView.text = message

        binding.myButton34.setOnClickListener(fun (view: View){
            val intent = android.content.Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
}
