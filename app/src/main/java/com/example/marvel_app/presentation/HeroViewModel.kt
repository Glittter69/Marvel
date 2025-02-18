package com.example.marvel_app.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel_app.data.HeroesRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = HeroViewModel.Factory::class)
class HeroViewModel @AssistedInject constructor(
    @Assisted heroId: String,
    private val heroesRepository: HeroesRepository,
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(heroId: String):HeroViewModel
    }

    private val mutableStateFlow: MutableStateFlow<HeroState> = MutableStateFlow(HeroState.Loading)
    val stateFlow: StateFlow<HeroState> = mutableStateFlow

    init {
        viewModelScope.launch {
            try {
                val hero = heroesRepository.getHeroById(heroId)
                mutableStateFlow.value = HeroState.Success(hero)
            } catch (ex: Exception) {
                mutableStateFlow.value = HeroState.Error
            }
        }
    }
}