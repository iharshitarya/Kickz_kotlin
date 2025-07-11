package com.example.kickz_kotlin.data.model.categoryModel

data class CategoryListingModel (
    val name: String,
)
data class CategoryResponse(
    val status: String,
    val data: List<CategoryListingModel>
)