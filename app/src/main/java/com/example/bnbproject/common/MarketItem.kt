package com.example.bnbproject.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bnbproject.R
import com.example.bnbproject.data.Item
import com.example.bnbproject.data.sampleItems

@Composable
fun MarketItem(
    item:Item
) {
    Surface(
        modifier= Modifier
            .padding(6.dp)
            .fillMaxWidth()
            .height(100.dp)
            .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(1))
    ) {
        Row (
            modifier=Modifier.fillMaxSize()
        ){
            Box(modifier = Modifier
                .size(120.dp),

            ){
                Image(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.Center),
                    painter = painterResource(R.drawable.ic_launcher_background),
                    contentDescription = ""
                )
            }
            Column (
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    item.name,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    item.type,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    item.owner,
                    fontWeight = FontWeight.Normal
                )

                Text(
                    item.price,
                    fontWeight = FontWeight.Normal
                )
            }
        }









        

    }
}

@Preview
@Composable
private fun pv() {
    MarketItem(sampleItems[0])
}