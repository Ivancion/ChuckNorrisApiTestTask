package com.example.chucknorristesttask.ui.jokespage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorristesttask.R
import com.example.chucknorristesttask.adapters.JokesRVAdapter
import com.example.chucknorristesttask.models.RandomJokeByCategory
import com.example.chucknorristesttask.repository.JokesRepository

class JokesActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var jokesList: ArrayList<RandomJokeByCategory>
    private lateinit var viewModel: JokesViewModel
    private lateinit var jokesRepository: JokesRepository
    private lateinit var jokesViewModelFactory: JokesViewModelFactory
    private lateinit var jokesRVAdapter: JokesRVAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jokes)

        val arguments: Bundle = intent.extras!!
        val category:String = arguments.get("category").toString()

        progressBar = findViewById(R.id.jokesPB)
        if(progressBar.visibility == ProgressBar.VISIBLE) { } else progressBar.visibility = ProgressBar.VISIBLE
        jokesList = ArrayList()
        recyclerView = findViewById(R.id.jokesRecyclerView)
        jokesRVAdapter = JokesRVAdapter(this, jokesList)
        recyclerView.adapter = jokesRVAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        jokesRepository = JokesRepository()
        jokesViewModelFactory = JokesViewModelFactory(jokesRepository)
        viewModel = ViewModelProvider(this, jokesViewModelFactory).get(JokesViewModel::class.java)
        viewModel.getRandomJoke(category)


        viewModel.joke.observe(this, { response ->
            if (response != null && response.isNotEmpty()) {
                response.forEach {
                    jokesList.add(it)
                    jokesRVAdapter.notifyDataSetChanged()
                }
                progressBar.visibility = ProgressBar.GONE
            }
        })
    }
}