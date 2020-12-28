package com.example.projet4a.Domain.Entity


import com.google.gson.annotations.SerializedName

data class Sys(
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int
)