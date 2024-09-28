package com.example.bnbproject.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bnbproject.Utils.MyOutlinedTextField

@Composable
fun LoginPage(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Login",
                fontWeight = FontWeight.SemiBold,
                fontSize = 28.sp,
                color = Color.Black
            )
            MyOutlinedTextField(
                value = "email",
                onValueChange = {  },
                label = "Enter your email",
                modifier = modifier.fillMaxWidth(),
                innerTextColor = Color.Red,
                shape = RoundedCornerShape(14.dp),
                keyboardType = KeyboardType.Email,
            )
            MyOutlinedTextField(
                value = "password",
                onValueChange = {  },
                label = "Enter your password",
                modifier = modifier.fillMaxWidth(),
                innerTextColor = Color.Black,
                shape = RoundedCornerShape(14.dp),
                keyboardType = KeyboardType.Password,
            )
            Spacer(modifier = Modifier.height(5.dp))

            ElevatedButton(
                onClick = {
//                    if (email.isNotEmpty() && password.isNotEmpty())
//                        authViewModel.login(email, password, context)
//                    else
//                        Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                },
                colors = ButtonDefaults.buttonColors()
                    .copy(containerColor = Color(0xFFDA5D5D), contentColor = Color(0xFFFFFFFF))
            ) {
                Text(
                    modifier = Modifier.padding(5.dp),
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            TextButton(onClick = {

//                navController.navigate(NavRoutes.Register.route) {
//                    popUpTo(navController.graph.startDestinationId)
//                    launchSingleTop = true
//                }
            }) {
                Text(
                    text = "New user? Create account", color = Color(0xFF0D83FF)
                )
            }
        }

    }
}

@Preview
@Composable
private fun previ() {
    LoginPage()
}