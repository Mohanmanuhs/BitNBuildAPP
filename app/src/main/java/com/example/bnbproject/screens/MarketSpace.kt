package com.example.bnbproject.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bnbproject.data.sampleItems
import com.example.bnbproject.navigation.NavRoutes

@Composable
fun MarketSpace(
    modifier: Modifier = Modifier,

) {
    MarketList(sampleItems)
}