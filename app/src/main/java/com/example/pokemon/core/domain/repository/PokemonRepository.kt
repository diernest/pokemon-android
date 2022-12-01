package com.example.pokemon.core.data.domain.repository

import com.example.pokemon.core.data.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getListPokemonRemotely(): List<Pokemon>
}