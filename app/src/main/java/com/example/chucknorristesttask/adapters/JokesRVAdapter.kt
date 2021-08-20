package com.example.chucknorristesttask.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorristesttask.R
import com.example.chucknorristesttask.models.RandomJokeByCategory

class JokesRVAdapter(
    private var context: Context,
    private var list: ArrayList<RandomJokeByCategory>
): RecyclerView.Adapter<JokesRVAdapter.JokesViewHolder>() {


    class JokesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.jokeTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val view: View = LayoutInflater.from(context)
            .inflate(R.layout.joke_item, parent, false)
        return JokesViewHolder(view)
    }


    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        holder.textView.text = list[position].value
    }

    override fun getItemCount(): Int {
        return list.size
    }
}