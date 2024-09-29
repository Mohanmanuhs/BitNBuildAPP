package com.example.bnbproject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.bnbproject.R
import com.example.bnbproject.viewmodel.ProfileViewModel
import kotlinx.coroutines.delay

@Composable
fun ItemDetailsScreen(
    userItemId: String,
    modifier: Modifier = Modifier,
    profileViewModel: ProfileViewModel= viewModel()
) {

    val userItem by profileViewModel.item.collectAsState()
    LaunchedEffect(true) {
        delay(100)
        profileViewModel.fetchItem(userItemId)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Item Image
        Image(
            painter = if (userItem.img == "") painterResource(id = R.drawable.placeholder) else rememberAsyncImagePainter(
                model = userItem.img
            ),
            contentDescription = "dp",
            modifier = Modifier
                .padding(5.dp)
                .size(100.dp)
                .clip(RectangleShape)
            ,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(20.dp))

        // Title
        Text(
            text = userItem.brand,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Type: ${userItem.type}", style = MaterialTheme.typography.bodySmall)

        Spacer(modifier = Modifier.height(16.dp))


        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.elevatedCardElevation(4.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Compartment Information
                Text(text = "Compartment: ${userItem.compartment}", style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.height(8.dp))

                // Shop Information
                Text(text = "Shop From: ${userItem.shopFrom}", style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.height(8.dp))

                // Price Information
                Text(
                    text = "Price: ${userItem.price}",
                    style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.secondary)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Additional Notes or Description (if needed)
        Text(
            text = "Additional Information",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "This is where you can add any additional details about the item, such as condition, features, or other relevant information.",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center
        )
    }
}