package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PotionApp(onExit = { finish() })
        }
    }
}

@Composable
fun PotionApp(onExit: () -> Unit) {
    var input by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var restartCount by remember { mutableStateOf(0) }
    var isButtonVisible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Mostrar solo si no hay mensaje
        if (message.isEmpty()) {
            Text(
                text = "Ingrese la cantidad en miligramos:",
                fontSize = 20.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            TextField(
                value = input,
                onValueChange = { input = it },
                label = { Text("Poción multijugos") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            )
        }

        if (isButtonVisible && message.isEmpty()) {
            Button(
                onClick = {
                    val mg = input.toIntOrNull()
                    if (mg != null) {
                        message = if (mg > 100) {
                            "Felicidades, es una buena poción multijugos!"
                        } else {
                            "La poción es mediocre, sangre sucia inmunda!"
                        }
                        isButtonVisible = false
                    } else {
                        message = "Ingrese un valor válido"
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                modifier = Modifier.align(Alignment.Start)
            ) {
                Text("Validar", style = TextStyle(color = Color.White))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

       
        if (message.isNotEmpty()) {
            Text(
                text = message,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold 
            )

            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    input = ""
                    message = ""
                    isButtonVisible = true
                    restartCount++
                    if (restartCount >= 3) {
                        onExit()
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
            ) {
                Text("Nuevo", style = TextStyle(color = Color.White))
            }
        }
    }
}








