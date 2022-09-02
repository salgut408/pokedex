package com.sgut.android.mypokedex

import com.google.gson.annotations.SerializedName


data class Generationvii (

  @SerializedName("icons"                ) var icons                : Icons?                = Icons(),
  @SerializedName("ultra-sun-ultra-moon" ) var ultraSunUltraMoon : UltraSunUltraMoon? = UltraSunUltraMoon()

)