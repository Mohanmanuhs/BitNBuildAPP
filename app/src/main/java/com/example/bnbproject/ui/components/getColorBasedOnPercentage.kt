package com.example.bnbproject.ui.components

import androidx.compose.ui.graphics.Color

fun getColorBasedOnPercentage(percentageFilled: Float): Color {
    val clampedPercentage = percentageFilled.coerceIn(0f, 1f)
    val red = (1 - clampedPercentage) * 255
    val green = clampedPercentage * 255     
    return Color(red.toInt(), green.toInt(), 0)
}
