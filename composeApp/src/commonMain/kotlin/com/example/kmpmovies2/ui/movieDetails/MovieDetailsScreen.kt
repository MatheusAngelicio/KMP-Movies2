package com.example.kmpmovies2.ui.movieDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kmpmovies2.domain.model.Movie
import com.example.kmpmovies2.domain.model.movie1
import com.example.kmpmovies2.ui.compoents.CastMemberItem
import com.example.kmpmovies2.ui.compoents.MovieGenreChip
import com.example.kmpmovies2.ui.compoents.MovieInfoItem
import com.example.kmpmovies2.ui.theme.MoviesAppTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowLeft
import compose.icons.fontawesomeicons.solid.Calendar
import compose.icons.fontawesomeicons.solid.Clock
import compose.icons.fontawesomeicons.solid.Play
import compose.icons.fontawesomeicons.solid.Star
import kmpmovies2.composeapp.generated.resources.Res
import kmpmovies2.composeapp.generated.resources.minecraft_movie
import kmpmovies2.composeapp.generated.resources.movies_detail_text
import kmpmovies2.composeapp.generated.resources.movies_detail_watch_trailer
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MovieDetailsRoute() {
    MovieDetailsScreen(movie = movie1)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(movie: Movie) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(Res.string.movies_detail_text))
                },
                navigationIcon = {
                    Surface(
                        modifier = Modifier
                            .padding(start = 12.dp),
                        shape = MaterialTheme.shapes.small,
                    ) {
                        IconButton(
                            onClick = {

                            },
                            modifier = Modifier
                                .size(32.dp)
                        ) {
                            Icon(
                                imageVector = FontAwesomeIcons.Solid.ArrowLeft,
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(8.dp)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Surface(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                shape = MaterialTheme.shapes.large,
            ) {
                Image(
                    painter = painterResource(Res.drawable.minecraft_movie),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.medium),
                    contentScale = ContentScale.Crop,
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = movie.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    MovieInfoItem(
                        icon = FontAwesomeIcons.Solid.Star,
                        text = "7.5"
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    MovieInfoItem(
                        icon = FontAwesomeIcons.Solid.Clock,
                        text = "2h 36 min"
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    MovieInfoItem(
                        icon = FontAwesomeIcons.Solid.Calendar,
                        text = "2022"
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    MovieGenreChip(
                        genre = "Action"
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                ElevatedButton(
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    Icon(
                        imageVector = FontAwesomeIcons.Solid.Play,
                        contentDescription = null,
                        modifier = Modifier
                            .size(12.dp)
                    )

                    Text(
                        text = stringResource(Res.string.movies_detail_watch_trailer),
                        modifier = Modifier
                            .padding(start = 16.dp),
                        fontWeight = FontWeight.Medium,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                BoxWithConstraints {
                    val itemWidth = maxWidth * 0.55f

                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        items(10) {
                            CastMemberItem(
                                profilePictureUrl = "",
                                name = "Will Smith",
                                character = "Christopher Gardner",
                                modifier = Modifier
                                    .width(itemWidth)
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Trying to leave their troubled lives behind, twin brothers return to their hometown to start again, only to discover that an even greater evil is waiting to welcome them back.",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieDetailsPreview() {
    MoviesAppTheme {
        MovieDetailsScreen(movie = movie1)
    }
}