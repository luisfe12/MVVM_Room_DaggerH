package com.example.mvvmexampleroom.data.model.network

import com.example.mvvmexampleroom.core.RetrofitHelper
import com.example.mvvmexampleroom.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val quoteApiClient: QuoteApiClient,
) {

    //private val retrofit:Retrofit = RetrofitHelper.getRetrofit();

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = quoteApiClient.getAllQuotes();
            response.body() ?: emptyList();
        }
    }
}