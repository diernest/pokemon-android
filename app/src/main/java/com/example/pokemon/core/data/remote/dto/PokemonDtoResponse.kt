package com.example.pokemon.core.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDtoResponse(
    @field:Json(name = "count")
    val count: Int,
    @field:Json(name = "next")
    val next: String,
    @field:Json(name = "previous")
    val previous: Any,
    @field:Json(name = "results")
    val results: List<PokemonResult>
)