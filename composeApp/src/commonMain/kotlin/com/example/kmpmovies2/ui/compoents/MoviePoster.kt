package com.example.kmpmovies2.ui.compoents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.kmpmovies2.domain.model.Movie
import com.example.kmpmovies2.domain.model.movie1
import kmpmovies2.composeapp.generated.resources.Res
import kmpmovies2.composeapp.generated.resources.minecraft_movie
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MoviePoster(
    movie: Movie,
    onMoviePosterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(140.dp)
            .clickable { onMoviePosterClick() })
    {
        Card(
            modifier = Modifier.width(140.dp).height(210.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = movie.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MaterialTheme {
        MoviePoster(
            movie = movie1,
            onMoviePosterClick = {}
        )
    }
}