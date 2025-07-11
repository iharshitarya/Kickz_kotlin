package com.example.kickz_kotlin.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kickz_kotlin.data.model.UserSignInRequest
import com.example.kickz_kotlin.data.model.UserSignInResponse
import com.example.kickz_kotlin.data.repository.UserRepository
import com.example.kickz_kotlin.utils.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.lang.Thread.State
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: UserRepository,
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val _signInResult = MutableStateFlow<Result<UserSignInResponse>?>(null)
    val signInResult: StateFlow<Result<UserSignInResponse>?> = _signInResult.asStateFlow()
    private val _error = MutableStateFlow<String?>(null)
    val signInError: StateFlow<String?> = _error.asStateFlow()


    fun signIn(request: UserSignInRequest) {
        viewModelScope.launch {
            try {
                val response = repository.signInUser(request)
                if (response.isSuccessful) {
                    response.body()?.let {
                        try {
                            userPreferences.saveToken(it.data)  // check this field is the token
                        } catch (e: Exception) {
                            Log.e("UserPrefs", "Failed to save token", e)
                        }
                        _signInResult.value = Result.success(it)
                    } ?: run {
                        _error.value = "Empty response body"
                    }
                } else {
                    _error.value = response.errorBody()?.string() ?: "Sign-In failed"
                }
            } catch (e: Exception) {
                Log.e("SignInViewModel", "Sign-in exception", e)
                _signInResult.value = Result.failure(e)
            }
        }

    }

    fun singInUser(
        email: String, password: String
    ) {
        val request = UserSignInRequest(
            email = email, password = password
        )
        signIn(request)
    }
}