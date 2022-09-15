package com.sgut.android.mypokedex.pokemondetail

import androidx.lifecycle.ViewModel
import com.sgut.android.mypokedex.Pokemon
import com.sgut.android.mypokedex.repository.PokemonRepository
import com.sgut.android.mypokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
): ViewModel() {


   suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokemonInfo(pokemonName)
   }

}