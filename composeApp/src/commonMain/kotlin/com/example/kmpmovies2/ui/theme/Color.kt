package com.example.kmpmovies2.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val Primary80 = Color(0xFFE50914)
val BackgroundDark = Color(0xFF121212)
val SurfaceDark = Color(0xFF1E1E1E)
val TextPrimaryDark = Color(0xFFFFFFFF)
val ColorError = Color(0xFFF24E1E)
val Neutral60 = Color(0xFF8A91A8)
val Primary40 = Color(0xFFE50914)
val BackgroundLight = Color(0xFFFFFFFF)
val SurfaceLight = Color(0xFFF5F5F5)
val TextPrimaryLight = Color(0xFF121212)
val TextSecondaryLight = Color(0xFF4F4F4F)
val Neutral40 = Color(0xFF6B7280)
val ColorErrorLight = Color(0xFFD32F2F)

internal val darkColorScheme = darkColorScheme(
    primary = Primary80,
    onPrimary = Color.White,
    background = BackgroundDark,
    onBackground = TextPrimaryDark,
    surface = SurfaceDark,
    onSurface = TextPrimaryDark,
    secondary = Neutral60,
    onSecondary = TextPrimaryDark,
    error = ColorError,
    onError = Color.White
)

internal val lightColorScheme = lightColorScheme(
    primary = Primary40,
    onPrimary = Color.White,
    background = BackgroundLight,
    onBackground = TextPrimaryLight,
    surface = SurfaceLight,
    onSurface = TextPrimaryLight,
    secondary = Neutral40,
    onSecondary = Color.White,
    error = ColorErrorLight,
    onError = Color.White
)