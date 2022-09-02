package com.sgut.android.mypokedex

import com.google.gson.annotations.SerializedName


data class Generationiv (

  @SerializedName("diamond-pearl"        ) var diamondPearl        : DiamondPearl?        = DiamondPearl(),
  @SerializedName("heartgold-soulsilver" ) var heartGoldSoulSilver : HeartgoldSoulsilver? = HeartgoldSoulsilver(),
  @SerializedName("platinum"             ) var platinum             : Platinum?             = Platinum()

)