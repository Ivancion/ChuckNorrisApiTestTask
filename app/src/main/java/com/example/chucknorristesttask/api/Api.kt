package com.example.chucknorristesttask.api

import com.example.chucknorristesttask.models.RandomJokeByCategory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {


    @GET("jokes/random")
    suspend fun getRandomJokeByCategory(
        @Query("category") category: String
    ) : RandomJokeByCategory
}