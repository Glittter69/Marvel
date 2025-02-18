package com.example.marvel_app.presentation

import com.example.marvel_app.data.Superhero

sealed class HeroState {
    data object Loading : HeroState()
    data class Success(
        val superhero: Superhero,
    ) : HeroState()

    data object Error : HeroState()
}