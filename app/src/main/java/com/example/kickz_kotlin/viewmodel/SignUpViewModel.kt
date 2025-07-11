package com.example.kickz_kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kickz_kotlin.data.model.SignUpModel
import com.example.kickz_kotlin.data.model.UserSignUpRequest
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

    private val _signUpResult = MutableStateFlow<Result<SignUpModel>?>(null)
    val signUpResult: StateFlow<Result<SignUpModel>?> = _signUpResult.asStateFlow()
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error.asStateFlow()

    fun signUp(request: UserSignUpRequest) {
        viewModelScope.launch {
            try {
                val response = repository.signUpUser(request)
                if (response.isSuccessful) {
                    response.body()?.let {
                        _signUpResult.value = Result.success(it)
                    } ?: run {
                        _error.value = "Empty response body"
                    }
                } else {
                    _error.value = response.errorBody()?.string() ?: "Sign-up failed"
                }
            } catch (e: Exception) {
                _signUpResult.value = Result.failure(e)
            }
        }
    }

    fun signUpUser(
        name: String, phoneNumber: String, email: String, password: String, confirmPassword: String
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

    fun resetSignUpResult() {
        _signUpResult.value = null
    }

    fun resetError() {
        _error.value = null
    }
}
