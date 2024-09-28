package com.example.bnbproject.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bnbproject.Utils.MyOutlinedTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPage(

) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Add Item")
                },
                navigationIcon = {
                    Surface(
                        onClick = {},
                        color = Color.Transparent,
                    ) {
                        Row(modifier = Modifier.padding(vertical = 10.dp)) {
                            Icon(
                                Icons.Rounded.KeyboardArrowLeft, contentDescription = "Settings"
                            )

                        }
                    }
                }
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp)
        ) {

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "Add to Rent or Sell",
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(20.dp))

            MyOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                label = "Name",
                onValueChange = {
                    it
                },
                shape = RectangleShape,
                innerTextColor = Color.DarkGray,
                keyboardType = KeyboardType.Text
            )

            Spacer(modifier = Modifier.height(10.dp))


            MyOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                label = "Type",
                onValueChange = {

                },
                shape = RectangleShape,
                innerTextColor = Color.DarkGray,
                keyboardType = KeyboardType.Text
            )




            Spacer(modifier = Modifier.height(10.dp))

            MyOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                label = "Place",
                onValueChange = {

                },
                shape = RectangleShape,
                innerTextColor = Color.DarkGray,
                keyboardType = KeyboardType.Text
            )

            Spacer(modifier = Modifier.height(20.dp))

            MyOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                label = "Rent",
                onValueChange = {

                },
                shape = RectangleShape,
                innerTextColor = Color.DarkGray,
                keyboardType = KeyboardType.Text
            )


            Spacer(modifier = Modifier.height(20.dp))



            MyOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                label = "Price",
                onValueChange = {

                },
                shape = RectangleShape,
                innerTextColor = Color.DarkGray,
                keyboardType = KeyboardType.Text
            )

            Spacer(modifier = Modifier.height(20.dp))

            MyOutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                label = "Details",
                onValueChange = {

                },
                shape = RectangleShape,
                innerTextColor = Color.DarkGray,
                keyboardType = KeyboardType.Text
            )

            Spacer(modifier = Modifier.height(20.dp))


            Button(
                onClick = {
                }


            ) {
                Text(text = "Report")
            }
        }
    }
}


@Preview
@Composable
private fun ppp() {
    AddPage()
}