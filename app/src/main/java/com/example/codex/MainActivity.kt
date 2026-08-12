package com.example.unscramblegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unscramblegame.ui.theme.UnscrambleGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnscrambleGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameScreen()
                }
            }
        }
    }
}

@Composable
fun GameScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "UNSCRAMBLE",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "TAC",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "Unscramble the word!",
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp)
        )

        OutlinedTextField(
            value = "",
            onValueChange = { /* not functional yet */ },
            label = { Text("Enter your answer") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { /* not functional yet */ },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            Text("SUBMIT")
        }

        Text(
            text = "Score: 0",
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}