package com.example.kickz_kotlin.data.model.categoryModel

data class Media(
    val id: String,
    val url: String,
    val tag: String?,
    val meta: String?
)

data class CategoryListingModel(
    val name: String,
    val media: List<Media>?
)

data class CategoryResponse(
    val status: String,
    val data: List<CategoryListingModel>
)