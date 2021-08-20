package com.example.chucknorristesttask.ui.categorypage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoriesViewModel: ViewModel() {

    val categories: MutableLiveData<ArrayList<String>> = MutableLiveData()

    fun getListOfCategories(list: ArrayList<String>) {
        categories.value = list
    }

}