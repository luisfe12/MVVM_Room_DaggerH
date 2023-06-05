package com.example.mvvmexampleroom.domain

import com.example.mvvmexampleroom.data.model.QuoteModel
import com.example.mvvmexampleroom.data.model.network.QuoteRepository
import com.example.mvvmexampleroom.domain.model.Quote
import com.example.mvvmexampleroom.domain.model.toDomain
import javax.inject.Inject

class RandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository){

    suspend operator fun invoke():Quote? {
        val quotes:List<Quote> = repository.getAllQuotesFromDataBase();
        if (!quotes.isNullOrEmpty()){
            val randomPosition:Int = (quotes.indices).random();
            return quotes[randomPosition];
        }

        return null;
    }
}