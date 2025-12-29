package com.example.kmpmovies2.di

import com.example.kmpmovies2.ui.movies.MoviesListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MoviesListViewModel(moviesRepository = get()) }
}