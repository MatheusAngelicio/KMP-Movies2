package com.example.kmpmovies2.data.mapper

import com.example.kmpmovies2.data.network.IMAGE_BASE_URL
import com.example.kmpmovies2.data.network.model.CastMemberResponse
import com.example.kmpmovies2.domain.model.CastMember
import com.example.kmpmovies2.domain.model.ImageSize

fun CastMemberResponse.toModel() = CastMember(
    id = this.id,
    mainRole = this.department,
    name = this.name,
    character = this.character,
    profileUrl = "$IMAGE_BASE_URL/${ImageSize.X_SMALL.size}/${this.profilePath}",
)