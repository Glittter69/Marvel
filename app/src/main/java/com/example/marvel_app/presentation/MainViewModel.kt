package com.example.marvel_app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app.data.HeroesRepository
import com.example.marvel_app.data.HeroesRepositoryImplementation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val heroesRepository: HeroesRepository = HeroesRepositoryImplementation()
) : ViewModel() {

    private val mutableStateFlow: MutableStateFlow<MainState> = MutableStateFlow(MainState.Loading)
    val stateFlow: StateFlow<MainState> = mutableStateFlow

    init {
        viewModelScope.launch {
            try {
                val superheroes = heroesRepository.getAllHeroes()
                mutableStateFlow.value = MainState.Success(superheroes)
            } catch (ex: Exception) {
                mutableStateFlow.value = MainState.Error
            }
        }
    }
}
