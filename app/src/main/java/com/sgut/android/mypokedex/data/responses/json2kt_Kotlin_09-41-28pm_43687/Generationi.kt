package com.sgut.android.mypokedex

import com.google.gson.annotations.SerializedName


data class Generationi (

  @SerializedName("red-blue" ) var redBlue : RedBlue? = RedBlue(),
  @SerializedName("yellow"   ) var yellow   : Yellow?   = Yellow()

)