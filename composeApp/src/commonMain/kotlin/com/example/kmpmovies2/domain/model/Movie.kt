package com.example.kmpmovies2.domain.model

import com.example.kmpmovies2.data.network.IMAGE_SMALL_BASE_URL
import com.example.kmpmovies2.data.network.model.MovieResponse

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
)

fun MovieResponse.toModel() = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterUrl = "$IMAGE_SMALL_BASE_URL${this.posterPath}",
)

// fake objects

val movie1 = Movie(
    id = 1,
    title = "A minecraft movie",
    overview = "Overview 1",
    posterUrl = "https://image.tmdb.org/t/p/w500"
)
