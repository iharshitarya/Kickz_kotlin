package com.example.kickz_kotlin.data.model

data class SignUpModel (
    val status: Long,
    val message: String,
    val data: Data
)

data class Data (
    val userID: String,
    val name: String,
    val mobileNumber: String,
    val email: String,
    val accessToken: String
)
