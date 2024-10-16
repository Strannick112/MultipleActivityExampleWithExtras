package com.example.myapplication3

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication3.databinding.Layout2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: Layout2Binding

    class Chair(var height: Int, var color: Color, var material: String): Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readInt(),
            Color.valueOf(parcel.readFloat(), parcel.readFloat(), parcel.readFloat()),
            parcel.readString() ?: "")

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(height)
            parcel.writeFloat(color.red())
            parcel.writeFloat(color.green())
            parcel.writeFloat(color.blue())
            parcel.writeString(material)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Chair> {
            override fun createFromParcel(parcel: Parcel): Chair {
                return Chair(parcel)
            }

            override fun newArray(size: Int): Array<Chair?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = Layout2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.myButton34.setOnClickListener(fun (view: View){
            val intent: Intent = Intent()
            val chair: Chair = Chair(10, Color.valueOf(1F, 1F, 1F), "Дерево")
            val parcel: Parcel = Parcel.obtain()
            chair.writeToParcel(parcel, 0)
            val bundle = Bundle().apply {
                putParcelable("Разобранный стул", chair)
            }
            intent.putExtra("Верминская", binding.gift.text.toString())
            intent.putExtra("Стул", bundle)
            setResult(RESULT_OK, intent)
            finish()
        })
    }
}
