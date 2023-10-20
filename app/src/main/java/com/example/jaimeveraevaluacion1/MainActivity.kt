package com.example.jaimeveraevaluacion1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jaimeveraevaluacion1.ui.theme.JaimeVeraEvaluacion1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicio()
            }
        }
    }

@Preview
@Composable
fun PantallaInicio(){
    val contexto = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =Alignment.CenterHorizontally

    ) {

        Button(onClick = {
            val intent = Intent(contexto, HonorarioActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text("Calculo Sueldo Honorarios")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            val intent = Intent(contexto, RegularActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text("Calculo Sueldo Regular")
        }

    }
}

