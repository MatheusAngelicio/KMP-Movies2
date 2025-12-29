package com.example.kmpmovies2.di

import com.example.kmpmovies2.data.network.KtorClient
import org.koin.dsl.module

val networkModule = module {
    single {
        KtorClient()
    }
}