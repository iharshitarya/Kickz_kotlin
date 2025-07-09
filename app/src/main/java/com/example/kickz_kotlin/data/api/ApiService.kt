package com.example.kickz_kotlin.data.api

import com.example.kickz_kotlin.data.model.UserSignUpRequest
import com.example.kickz_kotlin.data.model.UserSignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/v1/api/user/sign-up")
    suspend fun signUpUser(@Body request: UserSignUpRequest): UserSignUpResponse
}