package com.example.bnbproject.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.bnbproject.R
import com.example.bnbproject.model.SellItemModel
import com.example.bnbproject.navigation.NavRoutes

@Composable
fun MarketItem(
    item: SellItemModel, navController: NavHostController,
) {
    Row(
        modifier = Modifier.fillMaxWidth().clickable {
            val routes = NavRoutes.MarketDetails.route.replace("{data}", item.id)
            navController.navigate(routes)
        }
    ) {
        Box(
            modifier = Modifier.size(120.dp),

            ) {
            Image(
                modifier = Modifier
                    .padding(4.dp)
                    .align(Alignment.Center),
                painter = if(item.img=="") painterResource(id = R.drawable.placeholder) else rememberAsyncImagePainter(model = item.img),
                contentDescription = ""
            )
        }
        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                item.name, fontWeight = FontWeight.Bold
            )
            Text(
                item.type, fontWeight = FontWeight.SemiBold
            )
            Text(
                item.owner, fontWeight = FontWeight.Normal
            )
            Text(
                item.sellingPrice, fontWeight = FontWeight.Normal
            )
        }
    }
}
