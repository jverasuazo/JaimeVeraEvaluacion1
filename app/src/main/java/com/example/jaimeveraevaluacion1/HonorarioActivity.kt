package com.example.jaimeveraevaluacion1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jaimeveraevaluacion1.ui.theme.JaimeVeraEvaluacion1Theme

class HonorarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Honorario()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Honorario() {
    val contexto = LocalContext.current
    var sueldoBruto by remember { mutableStateOf( "" ) }
    val retencion = 0.87 //corresponde a un 13% de retencion
    var total by remember { mutableStateOf( "" ) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text("Cálculo Sueldo a honorario")
        Spacer(modifier = Modifier.height(15.dp))
        TextField(
            value = sueldoBruto,
            onValueChange = { sueldoBruto = it },
            label = { Text("Ingrese el sueldo bruto") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val sueldoBrutoDouble = sueldoBruto.toDoubleOrNull()
            if (sueldoBrutoDouble != null) {
                val resultado = calcularSueldoHonorario(sueldoBrutoDouble, retencion)
                total = "El sueldo líquido es: $resultado"
            } else {
                // No mostrar nada.
            }
        }) {
            Text("Calcular")
        }

        Spacer(modifier = Modifier.height(20.dp))
        Text("SUELDO LIQUIDO")
        Text(total)

        Spacer(modifier = Modifier.height(200.dp))

        Button(onClick = {
            val intent = Intent(contexto, MainActivity::class.java)
            contexto.startActivity(intent)
        }){
        Text(text = "Home")
        }


    }
}


//funcion para calcular sueldo
fun calcularSueldoHonorario(sueldoBruto:Double, retencion:Double): Double {
    return sueldoBruto * retencion
}