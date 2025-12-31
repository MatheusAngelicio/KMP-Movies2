package com.example.kmpmovies2.ui.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kmpmovies2.data.repository.MoviesRepositoryImpl
import com.example.kmpmovies2.domain.model.MovieSection
import com.example.kmpmovies2.domain.model.movie1
import com.example.kmpmovies2.ui.compoents.MovieSection
import com.example.kmpmovies2.ui.theme.MoviesAppTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MoviesListRoute(
    viewModel: MoviesListViewModel = koinViewModel()
) {
    val moviesListState by viewModel.moviesListState.collectAsStateWithLifecycle()

    MoviesListScreen(
        moviesListState = moviesListState,
    )
}

@Composable
fun MoviesListScreen(
    moviesListState: MoviesListViewModel.MoviesListState
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {

            when (moviesListState) {
                MoviesListViewModel.MoviesListState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(alignment = Alignment.Center)
                    )
                }

                is MoviesListViewModel.MoviesListState.Success -> {
                    LazyColumn(
                        modifier = Modifier.padding(paddingValues),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(32.dp)
                    ) {
                        items(moviesListState.movieSections) { movieSection ->
                            MovieSection(
                                title = stringResource(movieSection.section.titleRes),
                                movies = movieSection.movies,
                            )
                        }
                    }
                }

                is MoviesListViewModel.MoviesListState.Error -> {
                    Text(
                        moviesListState.message,
                        modifier = Modifier
                            .padding(16.dp)
                            .align(alignment = Alignment.Center),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MoviePosterSuccessPreview() {
    MoviesAppTheme {
        MoviesListScreen(
            moviesListState = MoviesListViewModel.MoviesListState.Success(
                movieSections = listOf(
                    MovieSection(
                        section = MovieSection.SectionType.POPULAR,
                        movies = listOf(movie1, movie1, movie1)
                    ),
                    MovieSection(
                        section = MovieSection.SectionType.TOP_RATED,
                        movies = listOf(movie1, movie1, movie1)
                    ),
                    MovieSection(
                        section = MovieSection.SectionType.UPCOMING,
                        movies = listOf(movie1, movie1, movie1)
                    )
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MoviePosterErrorPreview() {
    MoviesAppTheme {
        MoviesListScreen(
            moviesListState = MoviesListViewModel.MoviesListState.Error(message = "Error")
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MoviePosterLoadingPreview() {
    MoviesAppTheme {
        MoviesListScreen(
            moviesListState = MoviesListViewModel.MoviesListState.Loading
        )
    }
}