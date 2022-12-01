package com.example.pokemon.core.data.remote

import com.example.pokemon.core.data.remote.dto.PokemonDtoResponse
import retrofit2.http.GET

interface PokemonApi {
    companion object{
        const val BASE_IMAGE = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/"
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }

    @GET("pokemon")
    suspend fun getListPokemon(): PokemonDtoResponse
}