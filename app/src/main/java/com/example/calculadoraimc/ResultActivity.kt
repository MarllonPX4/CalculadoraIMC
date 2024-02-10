package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResult: TextView
    private lateinit var textDiagnostico: TextView
    private lateinit var buttonVoltar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textPeso = findViewById(R.id.text_Peso_Informado)
        textAltura = findViewById(R.id.text_Altura_Informada)
        textResult = findViewById(R.id.text_Result)
        textDiagnostico = findViewById(R.id.text_Diagnostico)
        buttonVoltar = findViewById(R.id.button_Voltar)

        val bundle = intent.extras
        if (bundle != null) {
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado: $peso kg"
            textAltura.text = "Altura informada: $altura m"

            val imc = peso / (altura * altura)
            /*  if (imc < 18.5){
                  textResult.text = "Baixo"
              }else if(imc in 18.5 .. 24.9){
                  textResult.text = "Normal"
              }else if (imc in 25.0 .. 29.9){
                  textResult.text = "Sobrepeso"
              }else{
                  textResult.text = "Obeso"
              }*/
            /*textResult.text = if (imc < 18.5) {
                "Baixo"
            } else if (imc in 18.5..24.9) {
                "Normal"
            } else if (imc in 25.0..29.9) {
                "Sobrepeso"
            } else {
                "Obeso"
            }*/
            val diagnostico = if (imc < 18.5) {
                "IMC: Baixo"
            } else if (imc in 18.5..24.99) {
                "IMC: Normal"
            } else if (imc in 25.0..29.99) {
                "IMC: Sobrepeso"
            } else {
                "IMC: Obeso"
            }
            textDiagnostico.text = diagnostico
            textResult.text = imc.toString()

        }

        buttonVoltar.setOnClickListener {
            finish()
        }

    }
}