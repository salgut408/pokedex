package com.sgut.android.mypokedex.data.remote

import com.sgut.android.mypokedex.Pokemon
import com.sgut.android.mypokedex.PokemopnListApiResponses
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemonList (
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): PokemopnListApiResponses

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo (
        @Path("name") name: String,
    ): Pokemon

}