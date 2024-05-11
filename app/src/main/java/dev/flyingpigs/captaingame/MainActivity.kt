package dev.flyingpigs.captaingame

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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.flyingpigs.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {

                val treasuresFound = remember { mutableStateOf(0) }
                val movement = remember { mutableStateOf(0) }
                val direction = remember { mutableStateOf("North") }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame(treasuresFound, movement, direction)
                }
            }
        }
    }

    @Composable
    fun CaptainGame(
        treasuresFound: MutableState<Int>,
        movement: MutableState<Int>,
        direction: MutableState<String>
    ) {
        var weatherForecast by remember { mutableStateOf("") }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = "Weather Today!!! \n$weatherForecast")
            Spacer(modifier = Modifier.height(24.dp))
            Text(text = "Treasure Found: ${treasuresFound.value}")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Current Direction: ${direction.value}")
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Movement we've done: ${movement.value}")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                direction.value = "East"
                movement.value += 1
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                }
                weatherForecast = if (Random.nextBoolean()) {
                    "There is Storm"
                }else{
                    "Such a nice weather"
                }
            }) {
                Text("Go to East")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                direction.value = "West"
                movement.value += 1
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                }

                weatherForecast = if (Random.nextBoolean()) {
                    "There is Storm"
                }else{
                    "Such a nice weather"
                }
            }) {
                Text("Go to West")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                direction.value = "North"
                movement.value += 1
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                }

                weatherForecast = if (Random.nextBoolean()) {
                    "There is Storm"
                }else{
                    "Such a nice weather"
                }
            }) {
                Text("Go to North")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                direction.value = "South"
                movement.value += 1
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                }

                weatherForecast = if (Random.nextBoolean()) {
                    "There is Storm"
                }else{
                    "Such a nice weather"
                }
            }) {
                Text("Go to South")
            }
        }
    }


}



