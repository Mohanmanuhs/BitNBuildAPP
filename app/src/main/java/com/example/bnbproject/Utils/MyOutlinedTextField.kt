package com.example.bnbproject.Utils

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun MyOutlinedTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    shape: Shape,
    innerTextColor: Color,
    keyboardType: KeyboardType,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        modifier = modifier,
        shape = shape,
        onValueChange = onValueChange,
        label = { Text(label, color = Color.Black) },
        colors = OutlinedTextFieldDefaults.colors(focusedTextColor = innerTextColor),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}