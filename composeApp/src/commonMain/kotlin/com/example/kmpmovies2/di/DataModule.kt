package com.example.kmpmovies2.di

import com.example.kmpmovies2.data.repository.MoviesRepositoryImpl
import com.example.kmpmovies2.domain.repository.MoviesRepository
import org.koin.dsl.module

val dataModule = module {
    single<MoviesRepository> {
        MoviesRepositoryImpl(
            ktorClient = get()
        )
    }
}
