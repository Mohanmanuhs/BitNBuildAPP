package com.example.bnbproject.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bnbproject.common.MarketItem
import com.example.bnbproject.data.Item
import com.example.bnbproject.data.sampleItems




@Composable
fun MarketList(
    items:List<Item>
    ) {
    var search by remember { mutableStateOf("") }


    Column (
        modifier = Modifier.padding(top = 20.dp)
    ){
        OutlinedTextField(value = search,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            onValueChange = { search = it },
            label = { Text("Search item") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") }
        )

        Column (
            modifier = Modifier.verticalScroll(ScrollState(1))
        ){
            items.forEach { it ->
                MarketItem(it)

            }
        }
    }
}

@Preview
@Composable
private fun pp() {
    MarketList(sampleItems)
}

