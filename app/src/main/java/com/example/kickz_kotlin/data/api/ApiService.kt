package com.example.kickz_kotlin.data.api

import com.example.kickz_kotlin.data.model.SignUpModel
import com.example.kickz_kotlin.data.model.UserSignInRequest
import com.example.kickz_kotlin.data.model.UserSignInResponse
import com.example.kickz_kotlin.data.model.UserSignUpRequest
import com.example.kickz_kotlin.data.model.categoryModel.CategoryListingModel
import com.example.kickz_kotlin.data.model.categoryModel.CategoryResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("v1/api/user/sign-up")
    suspend fun signUp(
        @Body signUpRequest: UserSignUpRequest
    ): retrofit2.Response<SignUpModel>

    @POST("/v1/api/user/sign-in")
    suspend fun signIn(
        @Body signInRequest: UserSignInRequest
    ): retrofit2.Response<UserSignInResponse>

    @GET("/v1/api/category")
    suspend fun categoryListing(): Response<CategoryResponse>
}