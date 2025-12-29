package com.example.kmpmovies2.domain.repository

import com.example.kmpmovies2.domain.model.MovieSection

interface MoviesRepository {
    suspend fun getMovieSections(): List<MovieSection>
}

