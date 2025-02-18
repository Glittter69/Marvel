package com.example.marvel_app.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HeroDao {
    @Query("SELECT * FROM HeroEntity")
    suspend fun getAll(): List<HeroEntity>

    @Query("SELECT * FROM HeroEntity WHERE id = :id")
    suspend fun getById(id: String): HeroEntity?

    @Insert
    suspend fun insert(heroes: List<HeroEntity>)

    @Insert
    suspend fun insert(hero: HeroEntity)
}
