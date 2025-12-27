package com.example.kmpmovies2.domain.model

data class MovieSection(
    val section: SectionType,
    val movies: List<Movie>,
) {
    enum class SectionType {
        POPULAR,
        TOP_RATED,
        UPCOMING
    }
}