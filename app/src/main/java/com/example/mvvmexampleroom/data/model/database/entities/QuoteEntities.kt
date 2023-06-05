package com.example.mvvmexampleroom.data.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mvvmexampleroom.domain.model.Quote


@Entity(tableName = "table_quotes")
data class QuoteEntities(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") val id:Int = 0,
    @ColumnInfo("quotes") val quote:String,
    @ColumnInfo("author") val author:String,
)


fun Quote.toDataBase() = QuoteEntities(quote = quote, author = author);