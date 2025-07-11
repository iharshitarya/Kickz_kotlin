package com.example.kickz_kotlin.navigation

sealed class Screen(val route: String) {
    object SplashScreen: Screen("SplashScreen")
    object SignUp: Screen("SignUp")
    object SignIn: Screen("SignIn")
    object HomeScreen: Screen("HomeScreen")
}