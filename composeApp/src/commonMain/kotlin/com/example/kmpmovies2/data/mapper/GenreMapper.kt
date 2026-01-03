package com.example.kmpmovies2.data.mapper

import com.example.kmpmovies2.data.network.model.GenreResponse
import com.example.kmpmovies2.domain.model.Genre

fun GenreResponse.toModel() = Genre(
    id = this.id,
    name = this.name,
)