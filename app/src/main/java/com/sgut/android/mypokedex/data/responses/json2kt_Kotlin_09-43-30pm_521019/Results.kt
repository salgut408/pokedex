package com.sgut.android.mypokedex

import com.google.gson.annotations.SerializedName


data class Results (

  @SerializedName("name" ) var name : String? = null,
  @SerializedName("url"  ) var url  : String? = null

)