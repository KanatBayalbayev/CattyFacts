package com.example.cattyfacts.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("data")
    @Expose
    val data: List<String>? = null

)