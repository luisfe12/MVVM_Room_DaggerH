package com.example.mvvmexampleroom.data.model.network

import com.example.mvvmexampleroom.data.model.QuoteModel
import com.example.mvvmexampleroom.data.model.QuoteProvider
import com.example.mvvmexampleroom.data.model.database.entities.QuoteEntities
import com.example.mvvmexampleroom.data.model.database.entities.dao.QuoteDao
import com.example.mvvmexampleroom.domain.model.Quote
import com.example.mvvmexampleroom.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    //private val quoteProvider: QuoteProvider,
    private val quoteDao:QuoteDao,
) {


    suspend fun getAllQuotes(): List<Quote> {
        val response:List<QuoteModel> = api.getQuotes();
        //quoteProvider.quotes = response;
        //debemos mapear cada quotemodel to quote class
        return response.map { it.toDomain(); }
    }

    suspend fun getAllQuotesFromDataBase(): List<Quote> {
        return quoteDao.getAllQuoteEntities().map { it.toDomain(); };
    }

    suspend fun insertQuotes(quotes: List<QuoteEntities>){
        quoteDao.insertQuotes(quotes)
    }

    suspend fun clearQuotes() = quoteDao.deleteAllQuotes();

}