package com.example.chucknorristesttask.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorristesttask.R
import com.example.chucknorristesttask.ui.jokespage.JokesActivity

class CategoriesRVAdapter(
    private var context: Context,
    private var list: ArrayList<String>
    ): RecyclerView.Adapter<CategoriesRVAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.categoryTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context)
            .inflate(R.layout.category_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = list[position]

        holder.itemView.setOnClickListener {
            val intent = Intent(context, JokesActivity::class.java)
            intent.putExtra("category", list[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}