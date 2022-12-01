package com.example.pokemon.core.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class PokemonResult(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "url")
    val url: String
)