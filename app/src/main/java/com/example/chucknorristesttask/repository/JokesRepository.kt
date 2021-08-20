package com.example.chucknorristesttask.repository

import com.example.chucknorristesttask.api.RetrofitInstance
import com.example.chucknorristesttask.models.RandomJokeByCategory
import retrofit2.Response

class JokesRepository {

    suspend fun getRandomJokeByCategory(category: String): RandomJokeByCategory{
        return RetrofitInstance.api.getRandomJokeByCategory(category)
    }
}