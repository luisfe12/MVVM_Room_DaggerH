package com.example.mvvmexampleroom.di

import android.content.Context
import androidx.room.Room
import com.example.mvvmexampleroom.data.model.database.entities.QuoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val QUOTE_DATABASE_NAME:String = "quote_database";

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, QuoteDataBase::class.java, QUOTE_DATABASE_NAME).build();

    @Provides
    @Singleton
    fun providesQuoteDao(db:QuoteDataBase) = db.getQuoteDao();
}