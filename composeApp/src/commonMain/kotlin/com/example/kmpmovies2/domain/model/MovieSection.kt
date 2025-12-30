package com.example.kmpmovies2.domain.model

import kmpmovies2.composeapp.generated.resources.Res
import kmpmovies2.composeapp.generated.resources.movies_list_popular_movies
import kmpmovies2.composeapp.generated.resources.movies_list_top_rated_movies
import kmpmovies2.composeapp.generated.resources.movies_list_upcoming_movies
import org.jetbrains.compose.resources.StringResource

data class MovieSection(
    val section: SectionType,
    val movies: List<Movie>,
) {
    enum class SectionType(val titleRes: StringResource) {
        POPULAR(Res.string.movies_list_popular_movies),
        TOP_RATED(Res.string.movies_list_top_rated_movies),
        UPCOMING(Res.string.movies_list_upcoming_movies)
    }
}
