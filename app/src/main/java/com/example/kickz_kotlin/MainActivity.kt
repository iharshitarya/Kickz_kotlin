package com.example.kickz_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kickz_kotlin.screens.SplashScreen
import com.example.kickz_kotlin.ui.theme.Kickz_kotlinTheme
import com.example.kickz_kotlin.userauthentication.SignInWithEmail

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kickz_kotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    SplashScreen()
                    SignInWithEmail()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kickz_kotlinTheme {
        Greeting("Android")
    }
}