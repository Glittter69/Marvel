package com.example.marvel_app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HeroViewModelFactory(
    private val heroId: String,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HeroViewModel(heroId) as T
    }
}