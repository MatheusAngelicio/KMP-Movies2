package com.example.kmpmovies2

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kmpmovies2.di.dataModule
import com.example.kmpmovies2.di.networkModule
import com.example.kmpmovies2.di.viewModelModule
import com.example.kmpmovies2.navigation.AppRoutes
import com.example.kmpmovies2.ui.movies.MoviesListRoute
import com.example.kmpmovies2.ui.theme.MoviesAppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(
        application = {
            modules(networkModule, dataModule, viewModelModule)
        },
        content = {
            MoviesAppTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = AppRoutes.MoviesList) {
                    composable<AppRoutes.MoviesList> {
                        MoviesListRoute()
                    }

                    composable<AppRoutes.MovieDetails> {

                    }
                }
            }
        }
    )
}