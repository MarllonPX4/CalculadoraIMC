package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCalcular: Button
    private lateinit var editPeso: EditText
    private lateinit var editAltura: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcular = findViewById(R.id.button_Calcular)
        editPeso = findViewById(R.id.edit_Peso)
        editAltura = findViewById(R.id.edit_Altura)

        buttonCalcular.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            val peso = editPeso.text.toString()
            val altura = editAltura.text.toString()
            if (peso.isNotEmpty() && altura.isNotEmpty()){
                intent.putExtra("peso", peso.toDouble())
                intent.putExtra("altura", altura.toDouble())
            }

            startActivity(intent)
        }

    }
}