package com.example.kmpmovies2.data.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.HttpHeaders
import kotlinx.serialization.json.Json

object KtorClient {

    private val client = HttpClient {
        install(ContentNegotiation) {
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            }
        }
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(
                        accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI1M2YxMWU2ZjY0M2Y1MzY4NDc0MTVhOTUzMzQ3ZjY4YyIsIm5iZiI6MTcxMDA3Njk3Mi41NzQwMDAxLCJzdWIiOiI2NWVkYjQyYzkxZjBlYTAxODY4YzBkMWUiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.m7wS3MOb1KmJqYKO4TRSBNi8Q0Pc2bxjnG-dFH31_CE",
                        refreshToken = "",
                    )
                }
            }
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }
    }


}