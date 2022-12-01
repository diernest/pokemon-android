package com.example.pokemon.core.data.mapper

import com.example.pokemon.core.data.domain.model.Pokemon
import com.example.pokemon.core.data.remote.PokemonApi
import com.example.pokemon.core.data.remote.dto.PokemonResult

fun PokemonResult.toDomain(): Pokemon {
    val idPokemon: Int = getId(this.url)
    return Pokemon(
        id= idPokemon,
        name= this.name,
        url = getUrlImage(idPokemon)
    )
}
fun getId(value: String?): Int{
    value?.let {
        var removeURL = value.replace(PokemonApi.BASE_URL,"")
        removeURL = removeURL.replace("pokemon/","")
        removeURL = removeURL.replace("/","")
        return Integer.parseInt(removeURL)
    }?: run {
        return 0
    }
}

fun getUrlImage(id: Int): String{
    return PokemonApi.BASE_IMAGE + id + ".png"
}