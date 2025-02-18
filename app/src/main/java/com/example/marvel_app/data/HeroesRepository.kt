package com.example.marvel_app.data

interface HeroesRepository {
    suspend fun getAllHeroes(): List<Superhero>

    suspend fun getHeroById(id: String): Superhero
}