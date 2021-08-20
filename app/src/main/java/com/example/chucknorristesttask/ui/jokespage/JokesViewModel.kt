package com.example.chucknorristesttask.ui.jokespage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chucknorristesttask.models.RandomJokeByCategory
import com.example.chucknorristesttask.repository.JokesRepository
import kotlinx.coroutines.launch

class JokesViewModel(private val jokesRepository: JokesRepository): ViewModel() {

    val joke: MutableLiveData<ArrayList<RandomJokeByCategory>> = MutableLiveData()


    fun getRandomJoke(category: String) {
        viewModelScope.launch {
            val list: ArrayList<RandomJokeByCategory> = ArrayList()
            for(i in 0 until 15) {
                list.add(jokesRepository.getRandomJokeByCategory(category))
            }
            joke.value = list
        }
    }

}