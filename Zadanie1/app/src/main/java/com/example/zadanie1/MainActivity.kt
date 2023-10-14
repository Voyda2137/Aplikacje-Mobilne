package com.example.zadanie1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zadanie1.ui.theme.Zadanie1Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Zadanie1Theme {
                MyApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column {
            TopAppBar(
                title = { Text(text = "To jest moja nazwa aplikacji") },
                modifier = Modifier.fillMaxWidth(),
            )
            Greeting()
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = getRandomLanguage().greeting,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            fontSize = 30.sp,
            textAlign  = TextAlign.Center
        )
    }
}
data class Language(val language: String, val greeting: String)

fun getRandomLanguage(): Language {
    val languages = listOf(
        Language("English", "Hello"),
        Language("French", "Bonjour"),
        Language("Spanish", "Hola"),
        Language("German", "Hallo"),
        Language("Italian", "Ciao"),
    )
    return languages[Random.nextInt(languages.size)]
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Zadanie1Theme {
        MyApp()
    }
}