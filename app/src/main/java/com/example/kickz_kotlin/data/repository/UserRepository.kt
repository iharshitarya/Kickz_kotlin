package com.example.kickz_kotlin.data.repository

import com.example.kickz_kotlin.data.api.ApiService
import com.example.kickz_kotlin.data.model.SignUpModel
import com.example.kickz_kotlin.data.model.UserSignInRequest
import com.example.kickz_kotlin.data.model.UserSignInResponse
import com.example.kickz_kotlin.data.model.UserSignUpRequest
import com.example.kickz_kotlin.data.model.categoryModel.CategoryListingModel
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun signUpUser(request: UserSignUpRequest): Response<SignUpModel> {
        return apiService.signUp(request)
    }

    suspend fun signInUser(request: UserSignInRequest): Response<UserSignInResponse> {
        return apiService.signIn(request)
    }

    suspend fun getCategories(): List<CategoryListingModel> {
        val response = apiService.categoryListing()
        if (response.isSuccessful) {
            return response.body()?.data ?: emptyList()
        } else {
            throw Exception("Failed to load categories: ${response.code()}")
        }
    }
}