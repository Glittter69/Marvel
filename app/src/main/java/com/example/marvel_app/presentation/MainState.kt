package com.example.marvel_app.presentation

import com.example.marvel_app.data.Superhero

sealed class MainState {

    data object Loading : MainState()

    data class Success(
        val superheroes: List<Superhero>,
    ) : MainState()

    data object Error : MainState()
}