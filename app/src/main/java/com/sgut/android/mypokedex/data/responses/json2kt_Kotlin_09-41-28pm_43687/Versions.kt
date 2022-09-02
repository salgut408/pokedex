package com.sgut.android.mypokedex

import com.google.gson.annotations.SerializedName


data class Versions (

  @SerializedName("generation-i"    ) var generationi    : Generationi?    = Generationi(),
  @SerializedName("generation-ii"   ) var generationii   : Generationii?   = Generationii(),
  @SerializedName("generation-iii"  ) var generationiii  : Generationiii?  = Generationiii(),
  @SerializedName("generation-iv"   ) var generationiv   : Generationiv?   = Generationiv(),
  @SerializedName("generation-v"    ) var generationv    : Generationv?    = Generationv(),
  @SerializedName("generation-vi"   ) var generationvi   : Generationvi?   = Generationvi(),
  @SerializedName("generation-vii"  ) var generationvii  : Generationvii?  = Generationvii(),
  @SerializedName("generation-viii" ) var generationviii : Generationviii? = Generationviii()

)