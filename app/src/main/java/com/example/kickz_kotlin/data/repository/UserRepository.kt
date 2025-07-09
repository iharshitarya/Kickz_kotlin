package com.example.kickz_kotlin.data.repository

import com.example.kickz_kotlin.data.api.ApiService
import com.example.kickz_kotlin.data.model.UserSignUpRequest
import com.example.kickz_kotlin.data.model.UserSignUpResponse

class UserRepository(private val apiService: ApiService) {
    suspend fun signUpUser(request: UserSignUpRequest): UserSignUpResponse {
        return apiService.signUpUser(request)
    }
}