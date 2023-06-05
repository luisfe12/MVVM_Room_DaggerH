package com.example.mvvmexampleroom.data.model

import javax.inject.Inject

class QuoteProvider @Inject constructor() {


    var quotes: List<QuoteModel> = emptyList();

}