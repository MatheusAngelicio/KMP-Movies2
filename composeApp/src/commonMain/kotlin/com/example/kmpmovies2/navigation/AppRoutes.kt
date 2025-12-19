package com.example.kmpmovies2.navigation

sealed interface AppRoutes {
    data object MoviesList : AppRoutes
    data class MovieDetails(val id: Int) : AppRoutes
}


