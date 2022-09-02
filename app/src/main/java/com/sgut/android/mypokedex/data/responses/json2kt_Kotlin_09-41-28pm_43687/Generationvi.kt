package com.sgut.android.mypokedex

import com.google.gson.annotations.SerializedName


data class Generationvi (

  @SerializedName("omegaruby-alphasapphire" ) var omegarubyAlphasapphire : OmegarubyAlphasapphire? = OmegarubyAlphasapphire(),
  @SerializedName("x-y"                     ) var xy                     : Xy?                     = Xy()

)