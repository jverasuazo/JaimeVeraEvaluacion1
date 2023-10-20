package com.example.jaimeveraevaluacion1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegularActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regular)

        val btnHome = findViewById<Button>(R.id.btnHome)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val ingresoEditText = findViewById<EditText>(R.id.ingreso)
        val sueldoLiquidoTextView = findViewById<TextView>(R.id.txt2)
        val resultadoTextView = findViewById<TextView>(R.id.txt3)

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnCalcular.setOnClickListener {
            val ingresoStr = ingresoEditText.text.toString()
            val ingresoDouble = ingresoStr.toDoubleOrNull()

            if (ingresoDouble != null) {
                val sueldoLiquido = calcularSueldoRegular(ingresoDouble)
                sueldoLiquidoTextView.text = "Sueldo Líquido: $sueldoLiquido"
                resultadoTextView.text = "Resultado: $sueldoLiquido"
            } else {
                sueldoLiquidoTextView.text = "Ingreso inválido"
                resultadoTextView.text = "Resultado: N/A"
            }
        }

    }

    //función para calcular sueldo regular
    fun calcularSueldoRegular(ingreso: Double): Double {
        return ingreso * 0.8 // 0.8 significa aplicar retención de 20%.
    }

}