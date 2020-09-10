package com.leudroid.androidlistchallenge.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leudroid.androidlistchallenge.R
import com.leudroid.androidlistchallenge.model.GamesByCategoryModel
import kotlinx.android.synthetic.main.games_by_category.view.*
import java.util.*

class GamesByCategoryAdapter(private val categoryList: LinkedList<GamesByCategoryModel>) :
    RecyclerView.Adapter<GamesByCategoryAdapter.ViewHolder>(){
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewCategoryAdapter = LayoutInflater.from(parent.context)
            .inflate(R.layout.games_by_category,parent,false)
        return ViewHolder(viewCategoryAdapter)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryList[position]

        holder.textViewCategoryTitle.text = category.list_title

        val gamesLayoutManager = LinearLayoutManager(holder.recyclerViewGame.context,
            RecyclerView.HORIZONTAL,
            false)

        holder.recyclerViewGame.apply {
            layoutManager = gamesLayoutManager
            adapter = GamesAdapter(category.games)
            setRecycledViewPool(viewPool)
        }

    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        //Initializing the Recycler and text view
        val recyclerViewGame : RecyclerView = itemView.recyclerViewGameLayout
        val textViewCategoryTitle: TextView = itemView.textViewGameCategoryTitle
    }
}
