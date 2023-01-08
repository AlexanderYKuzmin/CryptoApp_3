package com.example.cryptoapp_3.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinNamesListDto(
    @SerializedName("Data")
    @Expose
    val names: List<CoinNameContainerDto>? = null
)
