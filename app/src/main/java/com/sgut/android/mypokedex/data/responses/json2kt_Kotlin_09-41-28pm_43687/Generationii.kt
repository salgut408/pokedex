package com.sgut.android.mypokedex

import com.google.gson.annotations.SerializedName


data class Generationii (

  @SerializedName("crystal" ) var crystal : Crystal? = Crystal(),
  @SerializedName("gold"    ) var gold    : Gold?    = Gold(),
  @SerializedName("silver"  ) var silver  : Silver?  = Silver()

)