package com.sgut.android.mypokedex

import com.google.gson.annotations.SerializedName


data class DreamWorld (

  @SerializedName("front_default" ) var frontDefault : String? = null,
  @SerializedName("front_female"  ) var frontFemale  : String? = null

)