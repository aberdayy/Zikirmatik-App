package com.example.zikirmatik

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

var gelenZikir:Int? = null
val KEY_NAME = "zikir"

class MainActivity : AppCompatActivity() {

    lateinit var sharedPref : SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = applicationContext.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        gelenZikir = sharedPref.getInt(KEY_NAME,0)

        if (gelenZikir != null){
            textView.text = "${gelenZikir}"
        }
    }

    fun Ekle(view : View){

        gelenZikir = gelenZikir!! + 1

        val editor = sharedPref.edit()

        editor.putInt(KEY_NAME, gelenZikir!!)
        editor.apply()
        textView.text = "${gelenZikir}"

    }
    fun Sil(view : View){

        val editor = sharedPref.edit()
        gelenZikir = sharedPref.getInt(KEY_NAME,0)

        if (gelenZikir == 0){
            Toast.makeText(this,"Silinecek bir deger bulunamadi!", Toast.LENGTH_SHORT).show()
        }else{
            textView.text = "0"
            editor.remove(KEY_NAME)
            editor.apply()
            Toast.makeText(this,"Zikir silindi!", Toast.LENGTH_SHORT).show()
            gelenZikir = 0
        }

    }
}