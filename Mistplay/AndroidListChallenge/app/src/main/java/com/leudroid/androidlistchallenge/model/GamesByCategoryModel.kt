package com.leudroid.androidlistchallenge.model

import java.util.*

data class GamesByCategoryModel(
    val list_title : String = "",
    val games : LinkedList<GameModel>
)