package com.example.mvvmexampleroom.domain.model

import com.example.mvvmexampleroom.data.model.QuoteModel
import com.example.mvvmexampleroom.data.model.database.entities.QuoteEntities

data class Quote(
    val quote:String,
    val author:String,
)


//funcion de extension
//Quote Model devuelve un Quote
fun QuoteModel.toDomain() = Quote(quote, author);

//Funcion de extension apra el quote entities
fun QuoteEntities.toDomain() = Quote(quote, author);