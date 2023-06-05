package com.example.mvvmexampleroom.data.model.database.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmexampleroom.data.model.database.entities.QuoteEntities

@Dao
interface QuoteDao {

    @Query("SELECT * FROM table_quotes ORDER BY author DESC")
    suspend fun getAllQuoteEntities(): List<QuoteEntities>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuotes(quote: List<QuoteEntities>)

    @Query("DELETE FROM table_quotes")
    suspend fun deleteAllQuotes()
}