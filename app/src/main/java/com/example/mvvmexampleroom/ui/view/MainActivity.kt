package com.example.mvvmexampleroom.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.mvvmexampleroom.R
import com.example.mvvmexampleroom.ui.view.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var clContainer:ConstraintLayout;
    private lateinit var tvQuote:TextView;
    private lateinit var tvAuthor:TextView;
    private lateinit var pbLoading:ProgressBar;
    val quoteViewModel:QuoteViewModel by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clContainer = findViewById(R.id.clContainer);
        tvQuote = findViewById(R.id.tvQuote);
        tvAuthor = findViewById(R.id.tvAuthor);
        pbLoading = findViewById(R.id.pbLoading);


        quoteViewModel.onCreate();

        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            tvQuote.text = currentQuote.quote;
            tvAuthor.text = currentQuote.author;
        });

        quoteViewModel.isLoading.observe(this, Observer { currentState ->
            pbLoading.isVisible = currentState;
        });

        clContainer.setOnClickListener { quoteViewModel.randomQuotes(); }
    }
}