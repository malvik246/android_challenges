package com.leudroid.androidlistchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.leudroid.androidlistchallenge.adapters.GamesByCategoryAdapter
import com.leudroid.androidlistchallenge.model.GamesByCategoryModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initializing the data and recycler View
        initRecyclerView()
    }

    private fun initRecyclerView() {

        //initializing the recycler view
        val recyclerView: RecyclerView = recyclerViewGameCategory

        // using GSON for parsing json string to category object
        val categoryList = Gson().fromJson<LinkedList<GamesByCategoryModel>>(GetData.getJson(),
            object : TypeToken<LinkedList<GamesByCategoryModel>>() { }.type)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = GamesByCategoryAdapter(categoryList)
        }
    }
}