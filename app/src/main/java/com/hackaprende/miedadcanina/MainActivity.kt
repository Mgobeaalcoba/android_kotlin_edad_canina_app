package com.hackaprende.miedadcanina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.hackaprende.miedadcanina.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //  Metodo onCreate de la clase MainActivity asocia un layout XML con lógica Kotlin:
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Sumo el data binding que incorporé previamente en build.gradle:
        val binding = ActivityMainBinding.inflate(layoutInflater) // Inflar en Android: Formar un layout en memoria.
        //setContentView(R.layout.activity_main) -> No lo voy a usar mas porque me voy a conectar vía binding para cargar el layout en tiempo de compilación
        setContentView(binding.root) // Linkeo con el layout de esta forma. Es decir, de forma indirecta a traves del ActivityMainBinding

        /* Variables para escuchar los eventos en el layout creadas mediante "findViewById":

        val ageEdit = findViewById<EditText>(R.id.age_edit) // linkeo mi variable con una view del XML
        val resultText = findViewById<TextView>(R.id.result_text)
        val button = findViewById<Button>(R.id.button) // Listo. Tengo las variables para escuchar los eventos en mi layout.

        */

        // Variables para escuchar los eventos en el layout creadas mediante binding:

        val ageEdit = binding.ageEdit // linkeo mi variable con una view del XML
        val resultText = binding.resultText
        val button = binding.button

        Log.v("MainActivity","Activity created with success!!!")

        button.setOnClickListener {
            val ageString = ageEdit.text.toString()
            if (ageString.isNotEmpty()) {
                val ageInt = ageString.toInt()
                val result = ageInt * 7
                resultText.text = getString(R.string.result_string, result)
            } else {
                Log.w("MainActivity","Age is empty")
                Toast.makeText(this, getString(R.string.you_must_insert_your_age),Toast.LENGTH_SHORT).show()
            }
        }
    }
}