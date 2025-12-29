package com.example.kmpmovies2.domain.model

data class MovieSection(
    val section: SectionType,
    val movies: List<Movie>,
) {
    enum class SectionType(val title: String) {
        POPULAR("Popular Movies"),
        TOP_RATED("Top Rated Movies"),
        UPCOMING("Upcoming Movies")
    }
}