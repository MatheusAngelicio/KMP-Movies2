package com.example.kmpmovies2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform