package com.sgut.android.mypokedex

import com.google.gson.annotations.SerializedName


data class VersionDetails (

  @SerializedName("rarity"  ) var rarity  : Int?     = null,
  @SerializedName("version" ) var version : Version? = Version()

)