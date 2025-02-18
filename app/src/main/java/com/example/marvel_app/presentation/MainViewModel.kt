package com.example.marvel_app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app.data.HeroesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val heroesRepository: HeroesRepository
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
