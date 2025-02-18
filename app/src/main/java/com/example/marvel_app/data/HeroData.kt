package com.example.marvel_app.data

import com.example.marvel_app.R

data class Hero(
    val name: Int,
    val image: String,
    val description: Int
)

val heroes = listOf(
    Hero(
        name = R.string.deadpool,
        image = "https://iili.io/JMnAfIV.png",
        description = R.string.deadpool_desc
    ),
    Hero(
        name = R.string.iron_man,
        image = "https://iili.io/JMnuDI2.png",
        description = R.string.irom_man_desc
    ),
    Hero(
        name = R.string.spider_man,
        image = "https://iili.io/JMnuyB9.png",
        description = R.string.spider_man_desc
    )
)
