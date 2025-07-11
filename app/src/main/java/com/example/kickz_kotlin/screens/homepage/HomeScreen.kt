package com.example.kickz_kotlin.screens.homepage

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.kickz_kotlin.utils.CommonHeader
import com.example.kickz_kotlin.utils.UserPreferences
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    val context = LocalContext.current
    val userPreferences = remember { UserPreferences(context) }

    var token by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            token = userPreferences.getToken()
        }
    }

    Column {
        CommonHeader()
//        HomepageBanner()
        HomepageCategory()
        Text("Hello")
    }
}