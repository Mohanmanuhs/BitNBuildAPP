package com.example.bnbproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bnbproject.model.Compartment
import com.example.bnbproject.ui.components.CompartmentInputDialog
import com.example.bnbproject.ui.components.getColorBasedOnPercentage
import com.example.bnbproject.viewmodel.WardrobeViewModel


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier,wardrobeViewModel: WardrobeViewModel= viewModel()) {
    var showDialog by remember { mutableStateOf(false) }

    val compartmentList by wardrobeViewModel.compartments.collectAsState()
    var id by remember { mutableStateOf("") }
    var width by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var percentageFiled by remember { mutableStateOf("") }

    CompartmentInputDialog(showDialog,{showDialog=it},wardrobeViewModel,{wardrobeViewModel.editCompartment(it)})

    Column(modifier = Modifier.fillMaxSize()){
        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text(text = "ID") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = width,
            onValueChange = { width = it },
            label = { Text(text = "Width") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = height,
            onValueChange = { height = it },
            label = { Text(text = "Height") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = type,
            onValueChange = { type = it },
            label = { Text(text = "Type") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = percentageFiled,
            onValueChange = { percentageFiled = it },
            label = { Text(text = "Percentage Filled") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )
        Button(onClick = {
            wardrobeViewModel.addNewCompartment(
            Compartment(
                id = id.toIntOrNull()?:0,
                width = width.toFloatOrNull() ?: 0f,
                height = height.toFloatOrNull() ?: 0f,
                type = type,
                percentageFiled = percentageFiled.toFloatOrNull() ?: 0f
            )
            )
        }) {
            Text(text = "Add")
        }

        FlowRow(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(400.dp)
                .background(Color.Gray)
        ) {

            compartmentList.forEach { cmp ->
                Box(
                    modifier = Modifier
                        .clickable {
                            wardrobeViewModel.changeCmp(cmp)
                            showDialog = true
                        }
                        .size(cmp.width.dp, cmp.height.dp)
                        .padding(5.dp)
                        .background(getColorBasedOnPercentage(cmp.percentageFiled)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "${cmp.id}")
                }
            }
        }
    }
}

