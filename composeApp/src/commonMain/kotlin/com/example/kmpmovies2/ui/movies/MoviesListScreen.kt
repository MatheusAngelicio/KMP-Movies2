package com.example.kmpmovies2.ui.movies

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kmpmovies2.domain.model.movie1
import com.example.kmpmovies2.ui.compoents.MovieSection
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MoviesListRoute() {
    MoviesListScreen()
}

@Composable
fun MoviesListScreen() {
    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
        ) {
            item {
                MovieSection(
                    title = "Popular Movies",
                    listOf(movie1, movie1, movie1),
                )
                MovieSection(
                    title = "Top Rated Movies",
                    listOf(movie1, movie1, movie1),
                    modifier = Modifier.padding(top = 16.dp)
                )
                MovieSection(
                    title = "Upcoming Movies",
                    listOf(movie1, movie1, movie1),
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MaterialTheme {
        MoviesListScreen()
    }
}