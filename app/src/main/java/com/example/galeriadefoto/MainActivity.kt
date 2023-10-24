package com.example.galeriadefoto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.galeriadefoto.ui.theme.GaleriaDeFotoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GaleriaDeFotoTheme {
                }
            }
        }
    }
@Preview(showSystemUi = true)
@Composable
fun GaleriaDeFoto() {
    var mudar by remember { mutableStateOf(1) }
    var idImagem = when (mudar) {
        1 -> R.drawable.guedes
        2 -> R.drawable.gigantecassio
        3 -> R.drawable.guerrerotitulo
        else -> R.drawable.reiaugusto
    }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = idImagem),
            contentDescription = null,
            modifier = Modifier
                .size(600.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            botoesmudar(text = "anterior") {
                if (mudar > 1)
                    mudar--
                else
                    mudar = 4 }
            botoesmudar(text = "proximo") {
                if (mudar < 4)
                    mudar ++
                else
                    mudar = 1
            }
        }
    }
}
@Composable
fun botoesmudar(
    text:String,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors((Color(0,191,255,100))
            ),
                shape = RoundedCornerShape(20.dp),
        border = BorderStroke(2.dp, Color.Blue),
        elevation = ButtonDefaults.buttonElevation(4.dp)
    ) {
        Text(text =text)
    }
}