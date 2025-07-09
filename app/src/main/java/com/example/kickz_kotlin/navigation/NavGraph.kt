package com.example.kickz_kotlin.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kickz_kotlin.screens.SplashScreen
import com.example.kickz_kotlin.userauthentication.SignIn
import com.example.kickz_kotlin.userauthentication.SignUp

@Composable
fun NavigationGraph(
    navController: NavHostController, startDestination: String = Screen.SplashScreen.route
) {
    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.SignUp.route) {
            SignUp(navController = navController)
        }
        composable(Screen.SignIn.route) {
            SignIn(navController = navController)
        }

    }
}