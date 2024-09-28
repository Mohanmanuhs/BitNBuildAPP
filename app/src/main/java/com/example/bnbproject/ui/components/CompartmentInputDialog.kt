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
    showDialog:Boolean, onClick:(Boolean)->Unit,onDelete:(Int)->Unit,
    wardrobeViewModel: WardrobeViewModel, onAddCompartment: (Compartment) -> Unit) {

    val compartment by wardrobeViewModel.compartment.collectAsState()
    var capacity by remember { mutableStateOf(compartment.capacity.toString()) }
    var filled by remember { mutableStateOf(compartment.filled.toString()) }
    var type by remember { mutableStateOf(compartment.type) }

    LaunchedEffect(compartment) {
        capacity=compartment.capacity.toString()
        filled=compartment.filled.toString()
        type=compartment.type
    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { onClick(false) },
            title = { Text(text = "edit Compartment") },
            text = {
                Column {
                    // capacity Input
                    OutlinedTextField(
                        value = capacity,
                        onValueChange = { capacity = it },
                        label = { Text(text = "capacity") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )
                    // filled Input
                    OutlinedTextField(
                        value = filled,
                        onValueChange = { filled = it },
                        label = { Text(text = "filled") },
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
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        // Create a Compartment object and send it back to the caller
                        val newCompartment =
                            Compartment(
                            id = compartment.id,
                            capacity = capacity.toIntOrNull()?:0,
                            filled = filled.toIntOrNull() ?: 0,
                            type = type
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
                Button(onClick = {
                    onClick(false)
                    onDelete(compartment.id)
                }) {
                    Text(text = "Delete")
                }
            }
        )
    }
}
