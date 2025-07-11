package com.example.kickz_kotlin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kickz_kotlin.data.model.categoryModel.CategoryListingModel
import com.example.kickz_kotlin.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val _categories = MutableStateFlow<List<CategoryListingModel>>(emptyList())
    val categories: StateFlow<List<CategoryListingModel>> = _categories

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = repository.getCategories() // suspend function
                _categories.value = response
            } catch (e: Exception) {
                _error.value = e.message ?: "Something went wrong"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
