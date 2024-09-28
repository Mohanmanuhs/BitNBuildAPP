package com.example.bnbproject.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.bnbproject.model.Compartment
import com.example.bnbproject.viewmodel.WardrobeViewModel

@Composable
fun CompartmentInputDialog(
    showDialog:Boolean, onClick:(Boolean)->Unit,
    wardrobeViewModel: WardrobeViewModel, onAddCompartment: (Compartment) -> Unit) {

    val compartment by wardrobeViewModel.compartment.collectAsState()
    var width by remember { mutableStateOf(compartment.width.toString()) }
    var height by remember { mutableStateOf(compartment.height.toString()) }
    var type by remember { mutableStateOf(compartment.type) }
    var percentageFiled by remember { mutableStateOf(compartment.percentageFiled.toString()) }

    LaunchedEffect(compartment) {
        width=compartment.width.toString()
        height=compartment.height.toString()
        type=compartment.type
        percentageFiled=compartment.percentageFiled.toString()
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onClick(false) },
            title = { Text(text = "edit Compartment") },
            text = {
                Column {
                    // Width Input
                    OutlinedTextField(
                        value = width,
                        onValueChange = { width = it },
                        label = { Text(text = "Width") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )

                    // Height Input
                    OutlinedTextField(
                        value = height,
                        onValueChange = { height = it },
                        label = { Text(text = "Height") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )

                    // Type Input
                    OutlinedTextField(
                        value = type,
                        onValueChange = { type = it },
                        label = { Text(text = "Type") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )

                    // Percentage Filled Input
                    OutlinedTextField(
                        value = percentageFiled,
                        onValueChange = { percentageFiled = it },
                        label = { Text(text = "Percentage Filled") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Create a Compartment object and send it back to the caller
                        val newCompartment =
                            Compartment(
                            id = compartment.id,
                            width = width.toFloatOrNull() ?: 0f,
                            height = height.toFloatOrNull() ?: 0f,
                            type = type,
                            percentageFiled = percentageFiled.toFloatOrNull() ?: 0f
                        )

                        // Call the provided function to handle adding the new compartment
                        onAddCompartment(newCompartment)

                        // Close the dialog
                        onClick(false)
                    }
                ) {
                    Text(text = "Edit")
                }
            },
            dismissButton = {
                Button(onClick = { onClick(false) }) {
                    Text(text = "Cancel")
                }
            }
        )
    }
}
