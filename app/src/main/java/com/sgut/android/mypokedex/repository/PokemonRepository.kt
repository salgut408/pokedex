package com.sgut.android.mypokedex.repository

import com.sgut.android.mypokedex.Pokemon
import com.sgut.android.mypokedex.PokemopnListApiResponses
import com.sgut.android.mypokedex.data.remote.PokeApi
import com.sgut.android.mypokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemopnListApiResponses> {
        val response = try {
            api.getPokemonList(limit,offset)
        } catch (e: Exception) {
            return Resource.Error("Error occured")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("Error occured")
        }
        return Resource.Success(response)
    }
}