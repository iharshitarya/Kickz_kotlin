package com.example.kickz_kotlin.data.model

data class UserSignUpRequest(
    val fullName: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
    val mobileNumber: String
)