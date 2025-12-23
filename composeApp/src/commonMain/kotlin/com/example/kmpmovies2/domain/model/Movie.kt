package com.example.kmpmovies2.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
)

// fake objects

val movie1 = Movie(
    id = 1,
    title = "A minecraft movie",
    overview = "Overview 1",
    posterUrl = "https://image.tmdb.org/t/p/w500"
)
