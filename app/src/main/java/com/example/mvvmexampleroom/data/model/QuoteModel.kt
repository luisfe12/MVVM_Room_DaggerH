package com.example.mvvmexampleroom.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel(
    @SerializedName("quote") var quote:String,
    @SerializedName("author") var author:String,
)
