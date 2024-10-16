package com.example.myapplication3

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("ActivityLife", "onCreate")
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myButton.setOnClickListener(fun (view: View){
            val intent = android.content.Intent(this, MainActivity2::class.java)
            Log.d("WhatIsHappUning", "binding.myTextEdit.text: ${binding.myTextEdit.text}")
            intent.putExtra("myLittleTextForSecondActivity", binding.myTextEdit.text.toString())
            startActivity(intent)
        })

        binding.myButton3.setOnClickListener(fun (view: View){
            var intent = android.content.Intent(this, MainActivity3::class.java)
            startActivity(intent)
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLife", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLife", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLife", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLife", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityLife", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLife", "onDestroy")
    }
}

