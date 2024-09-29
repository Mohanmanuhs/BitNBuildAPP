package com.example.bnbproject.ui.components

import androidx.compose.ui.graphics.Color

fun getColorBasedOnPercentage(percentageFilled: Float): Color {
    return if(percentageFilled<=0.7) Color.Green.copy(alpha = .7f) else Color.Red.copy(alpha = .6f)
}
