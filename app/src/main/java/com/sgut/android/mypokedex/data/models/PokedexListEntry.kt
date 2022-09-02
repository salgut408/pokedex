package com.sgut.android.mypokedex.data.models

data class PokedexListEntry(
    val pokemonName: String,
    val imgUrl: String? = null,
    val number: Int? = null
) {
}