package com.sgut.android.mypokedex

import com.google.gson.annotations.SerializedName


data class Generationiii (

  @SerializedName("emerald"           ) var emerald           : Emerald?           = Emerald(),
  @SerializedName("firered-leafgreen" ) var fireredLeafgreen : FireredLeafgreen? = FireredLeafgreen(),
  @SerializedName("ruby-sapphire"     ) var rubySapphire     : RubySapphire?     = RubySapphire()

)