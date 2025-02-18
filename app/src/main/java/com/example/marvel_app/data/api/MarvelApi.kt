package com.example.marvel_app.data.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters")
    suspend fun getSuperheroes(
        @Query("apikey") apiKey: String,
        @Query("ts") timeStamp: Long,
        @Query("hash") hash: String,
    ): CharactersResponse


    @GET("characters/{id}")
    suspend fun getSuperhero(
        @Path("id") heroId: String,
        @Query("apikey") apiKey: String,
        @Query("ts") timeStamp: Long,
        @Query("hash") hash: String,
    ): CharactersResponse
}

