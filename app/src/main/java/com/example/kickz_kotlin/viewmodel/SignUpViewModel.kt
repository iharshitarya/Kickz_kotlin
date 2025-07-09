package com.example.kickz_kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kickz_kotlin.data.api.ApiService
import com.example.kickz_kotlin.data.model.UserSignUpRequest
import com.example.kickz_kotlin.data.model.UserSignUpResponse
import com.example.kickz_kotlin.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _signUpResult = MutableStateFlow<Result<UserSignUpResponse>?>(null)
    val signUpResult: StateFlow<Result<UserSignUpResponse>?> = _signUpResult.asStateFlow()

    fun signUp(request: UserSignUpRequest) {
        viewModelScope.launch {
            try {
                val response = repository.signUpUser(request)
                _signUpResult.value = Result.success(response)
            } catch (e: Exception) {
                _signUpResult.value = Result.failure(e)
            }
        }
    }
    fun signUpUser(
        name: String,
        phoneNumber: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        val request = UserSignUpRequest(
            fullName = name,
            email = email,
            password = password,
            confirmPassword = confirmPassword,
            mobileNumber = phoneNumber
        )
        signUp(request)
    }
}
