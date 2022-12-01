package com.example.pokemon.core.data

import com.example.pokemon.core.data.domain.model.Pokemon
import com.example.pokemon.core.data.domain.repository.PokemonRepository
import com.example.pokemon.core.data.remote.PokemonApi
import com.example.pokemon.core.data.remote.extensions.resultOf
import com.example.pokemon.core.data.mapper.toDomain

class PokemonRepositoryImp(
    private val api: PokemonApi
): PokemonRepository {

    override suspend fun getListPokemonRemotely()= resultOf {
        val results = api.getListPokemon().results
        results.map { it.toDomain() }
    }

}