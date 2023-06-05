package com.example.mvvmexampleroom.data.model.network

import com.example.mvvmexampleroom.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET("/.json")
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}