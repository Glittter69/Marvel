package com.example.marvel_app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HeroEntity::class], version = 1)
abstract class ApplicationDb : RoomDatabase() {
    abstract fun getHeroesDao(): HeroDao
}