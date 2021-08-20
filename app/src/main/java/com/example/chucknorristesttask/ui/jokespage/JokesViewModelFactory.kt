package com.example.chucknorristesttask.ui.jokespage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorristesttask.repository.JokesRepository


class JokesViewModelFactory(private val jokesRepository: JokesRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JokesViewModel(jokesRepository) as T
    }

}