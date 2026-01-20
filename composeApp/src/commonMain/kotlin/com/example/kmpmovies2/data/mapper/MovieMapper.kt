package com.example.kmpmovies2.data.mapper

import com.example.kmpmovies2.data.network.IMAGE_BASE_URL
import com.example.kmpmovies2.data.network.model.CastMemberResponse
import com.example.kmpmovies2.data.network.model.MovieResponse
import com.example.kmpmovies2.domain.model.ImageSize
import com.example.kmpmovies2.domain.model.Movie
import kotlin.math.roundToInt

fun MovieResponse.toModel(
    castMembersResponse: List<CastMemberResponse>? = null,
    imageSize: ImageSize = ImageSize.SMALL
) = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterUrl = "$IMAGE_BASE_URL/${imageSize.size}/${this.posterPath}",
    genres = this.genres?.map { it.toModel() },
    year = this.getYearFromReleaseDate(),
    duration = this.getDurationInHoursAndMinutes(),
    rating = "${this.voteAverage.roundToInt()}",
    castMembers = castMembersResponse
        ?.filter { it.department == "Acting" }
        ?.take(20)
        ?.map { it.toModel() }
)

private fun MovieResponse.getYearFromReleaseDate(): Int {
    return this.releaseDate.year
}

private fun MovieResponse.getDurationInHoursAndMinutes(): String? {
    return this.runtime?.let { runtimeMinutes ->
        val hours = runtimeMinutes / 60
        val minutes = runtimeMinutes % 60

        buildString {
            if (hours > 0) {
                append("${hours}h ")
            }

            append("${minutes}min")
        }
    }
}