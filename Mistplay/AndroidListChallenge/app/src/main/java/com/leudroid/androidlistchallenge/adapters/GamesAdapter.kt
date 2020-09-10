package com.leudroid.androidlistchallenge.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.leudroid.androidlistchallenge.R
import com.leudroid.androidlistchallenge.model.GameModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.single_game_layout.view.*
import java.util.*

class GamesAdapter(private var gamesList: LinkedList<GameModel>) :
    RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewGamesAdapter =  LayoutInflater.from(parent.context)
            .inflate(R.layout.single_game_layout, parent, false)
        return ViewHolder(viewGamesAdapter)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder,position: Int) {

        val game = gamesList[position]
        //getting and viewing image from Url using Picasso
        Picasso.get().load(game.img).into(holder.imageViewGameImg)

        //getting and setting title of game
        holder.textViewGameTitle.text = game.title

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        // Initializing the text and Image view
        val textViewGameTitle : TextView = itemView.textViewGameTitle
        val imageViewGameImg : ImageView = itemView.imageViewGameImage

    }
}