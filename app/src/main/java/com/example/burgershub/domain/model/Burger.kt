package com.example.burgershub.domain.model

data class Burger(
    val desc: String?,
    val id: Int?,
    val imageResponses: List<Image?>?,
    val ingredientResponses: List<Ingredient?>?,
    val name: String?,
    val price: Double?,
    val veg: Boolean?
)