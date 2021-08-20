package com.example.chucknorristesttask.ui.categorypage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorristesttask.R
import com.example.chucknorristesttask.adapters.CategoriesRVAdapter
import com.example.chucknorristesttask.utils.Constants.Companion.categories


class CategoriesActivity : AppCompatActivity() {

    private lateinit var viewModel: CategoriesViewModel
    private lateinit var rvAdapter: CategoriesRVAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        recyclerView = findViewById(R.id.categoriesRecyclerView)
        val list: ArrayList<String> = ArrayList(categories)

        viewModel = ViewModelProvider(this).get(CategoriesViewModel::class.java)
        viewModel.getListOfCategories(list)
        rvAdapter = CategoriesRVAdapter(this, viewModel.categories.value!!)
        recyclerView.adapter = rvAdapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)
    }
}