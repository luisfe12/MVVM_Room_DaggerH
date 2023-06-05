package com.example.mvvmexampleroom.domain

import com.example.mvvmexampleroom.data.model.QuoteModel
import com.example.mvvmexampleroom.data.model.database.entities.toDataBase
import com.example.mvvmexampleroom.data.model.network.QuoteRepository
import com.example.mvvmexampleroom.domain.model.Quote
import javax.inject.Inject

class GetQuoteUseCases @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke():List<Quote>{
        val quotes = repository.getAllQuotes();

        return  if (!quotes.isNullOrEmpty()) {
            repository.clearQuotes();
            repository.insertQuotes(quotes.map { it.toDataBase(); });
            quotes;
        }

        else{
            return repository.getAllQuotesFromDataBase();
        }
    }
}