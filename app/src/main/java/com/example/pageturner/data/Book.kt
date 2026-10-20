package com.example.pageturner.data


data class Book(
    val id: String,
    val title: String,
    val subtitle: String,
    val author: String,
    val shortDescription: String,
    val longDescription: String,
    val genreId: String,
    val category: String,
    val thumbnailUrl: String,
    val coverImageUrl: String
)