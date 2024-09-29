package com.example.bnbproject.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.bnbproject.common.MarketItem
import com.example.bnbproject.viewmodel.MarketSpaceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketSpace(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    marketSpaceViewModel: MarketSpaceViewModel= viewModel()
) {
    var search by remember { mutableStateOf("") }
    val itemsList by marketSpaceViewModel.itemsList.collectAsState()
    val options = remember {
        mutableStateListOf("Name", "Type", "Price")
    }

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ), title = {
                Text("Wardrobe Design")
            })
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            OutlinedTextField(value = search,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                onValueChange = { search = it },
                label = { Text("Search item") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") }
            )
            Box(modifier = modifier.fillMaxWidth()) {
                SingleChoiceSegmentedButtonRow(modifier = modifier.fillMaxWidth(), space = 5.dp) {
                    options.forEachIndexed { index, option ->
                        SegmentedButton(
                            selected = selectedIndex == index,
                            onClick = { selectedIndex = index },
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Text(text = option)
                        }
                    }
                }
            }
            LazyColumn {
                val filterItems =
                    when (selectedIndex) {
                        0 -> itemsList.filter { it.name.contains(search, ignoreCase = false) }
                        1 -> itemsList.filter { it.type.contains(search, ignoreCase = false) }
                        2 -> itemsList.filter {
                            it.sellingPrice.contains(
                                search,
                                ignoreCase = false
                            )
                        }

                        else -> {
                            itemsList.filter { it.name.contains(search, ignoreCase = false) }
                        }
                    }
                items(filterItems) {
                    Spacer(modifier = Modifier.height(10.dp))
                    MarketItem(it,navController)
                }
            }

        }
    }
}