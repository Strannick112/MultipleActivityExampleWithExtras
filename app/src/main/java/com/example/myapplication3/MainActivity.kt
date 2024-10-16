package com.example.myapplication3

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val login = "Stanislav"
    val password = "admin"

    companion object{
        const val REQUEST_VERMINSKAYA_SATELITE = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submit.setOnClickListener(fun (view: View){
            if(binding.login.text.toString() != login){
                val toast: Toast = Toast.makeText(this, "Неверный логин", Toast.LENGTH_SHORT)
                toast.show()
                return
            }
            if(binding.password.text.toString() != password){
                val toast: Toast = Toast.makeText(this, "Неверный пароль", Toast.LENGTH_SHORT)
                toast.show()
                return
            }
            val intent = android.content.Intent(this, MainActivity2::class.java)
            startActivityForResult(intent, REQUEST_VERMINSKAYA_SATELITE)

        })
    }

    override fun onActivityResult(otkudaPriletelResultat: Int, vseHoroso: Int, intentResultat: android.content.Intent?) {
        if(otkudaPriletelResultat == REQUEST_VERMINSKAYA_SATELITE){
            if(intentResultat == null){
                val toast: Toast = Toast.makeText(this, "Нет не то что памятника, вселенную снесли", Toast.LENGTH_SHORT)
                toast.show()
                return
            }
            if(vseHoroso == RESULT_OK){
                val toast: Toast = Toast.makeText(this, intentResultat!!.getStringExtra("Верминская"), Toast.LENGTH_SHORT)
                val bundle: Bundle = intentResultat!!.getBundleExtra("Стул")!!
                val parcelable: Parcelable = bundle.getParcelable<MainActivity2.Chair>("Разобранный стул")!!
                val chair: MainActivity2.Chair = parcelable as MainActivity2.Chair
                Log.d("Chair", "chair.material = ${chair.material}")
                toast.show()
            } else{
                val toast: Toast = Toast.makeText(this, "Памятник снесли и сдали на металлолом", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }
}

