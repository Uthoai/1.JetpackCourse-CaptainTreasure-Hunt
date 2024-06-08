package com.example.a1jetpackcoursecaptaintreasurehunt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a1jetpackcoursecaptaintreasurehunt.ui.theme._1JetpackCourseCaptainTreasureHuntTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _1JetpackCourseCaptainTreasureHuntTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainTreasureHunt()
                }
            }
        }
    }
}

@Composable
fun CaptainTreasureHunt() {

    val treasureFound = remember {
        mutableStateOf(0)
    }
    val direction = remember {
        mutableStateOf("Sail North")
    }
    val hp = remember {
        mutableStateOf(3)
    }
    val bestScore = remember {
        mutableStateOf(0)
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if (hp.value == 0){
            hp.value = 3
            if (treasureFound.value > bestScore.value){
                bestScore.value = treasureFound.value
            }
            treasureFound.value = 0
        }
        Text(
            text = "Captain Treasure Hunt",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Treasure: ${treasureFound.value}",
            fontSize = 18.sp
        )
        Text(
            text = "Current Direction: ${direction.value}",
            fontSize = 18.sp
        )
        Text(
            text = "Life : ${hp.value}",
            fontSize = 18.sp
        )
        Text(
            text = "Best Score: ${bestScore.value}",
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Button(onClick = {
                direction.value = "Sail North"
                if (Random.nextBoolean()){
                    treasureFound.value++
                }else{
                    hp.value--
                }
            }) {
                Text(text = "Sail North")
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Button(onClick = {
                direction.value = "Sail West"
                if (Random.nextBoolean()){
                    treasureFound.value++
                }else{
                    hp.value--
                }
            }) {
                Text(text = "Sail West")
            }
            Spacer(modifier = Modifier.width(32.dp))
            Button(onClick = {
                direction.value = "Sail East"
                if (Random.nextBoolean()){
                    treasureFound.value++
                }else{
                    hp.value--
                }
            }) {
                Text(text = "Sail East")
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Button(onClick = {
                direction.value = "Sail South"
                if (Random.nextBoolean()){
                    treasureFound.value++
                }else{
                    hp.value--
                }
            }) {
                Text(text = "Sail South")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CaptainTreasureHuntPreview() {
    CaptainTreasureHunt()
}