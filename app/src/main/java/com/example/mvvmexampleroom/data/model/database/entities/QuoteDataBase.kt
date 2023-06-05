package com.example.mvvmexampleroom.data.model.database.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmexampleroom.data.model.database.entities.dao.QuoteDao

@Database(entities = [QuoteEntities::class], version = 1)
abstract class QuoteDataBase: RoomDatabase() {

    abstract fun getQuoteDao():QuoteDao
}