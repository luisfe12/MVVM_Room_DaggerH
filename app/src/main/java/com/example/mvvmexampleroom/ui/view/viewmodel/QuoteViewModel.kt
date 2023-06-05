package com.example.mvvmexampleroom.ui.view.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmexampleroom.data.model.QuoteModel
import com.example.mvvmexampleroom.domain.GetQuoteUseCases
import com.example.mvvmexampleroom.domain.RandomQuoteUseCase
import com.example.mvvmexampleroom.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuoteUseUseCase: GetQuoteUseCases,
    private val randomQuoteUseCase: RandomQuoteUseCase,
) : ViewModel() {

    var quoteModel:MutableLiveData<Quote> = MutableLiveData<Quote>();
    var isLoading: MutableLiveData<Boolean> = MutableLiveData<Boolean>();


    fun onCreate(){
        viewModelScope.launch {
            val quotes = getQuoteUseUseCase();
            isLoading.postValue(true);

            if (quotes != null){
                quoteModel.postValue(quotes[0]);
                isLoading.postValue(false);
            }
        }
    }

    fun randomQuotes(){
        viewModelScope.launch {
            val quote = randomQuoteUseCase();
            isLoading.postValue(true)
            if (quote != null){
                quoteModel.postValue(quote!!)
            }

            isLoading.postValue(false);
        }
    }

}