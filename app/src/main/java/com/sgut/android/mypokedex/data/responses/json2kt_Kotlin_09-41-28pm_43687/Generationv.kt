package com.sgut.android.mypokedex

import com.google.gson.annotations.SerializedName


data class Generationv (

  @SerializedName("black-white" ) var blackWhite : BlackWhite? = BlackWhite()

)