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
fun SignUp(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(modifier = Modifier.padding(top = 5.dp),text = "Sign Up", fontWeight = FontWeight.SemiBold, fontSize = 28.sp,color= Color.Black)

            MyOutlinedTextField(
                value = "",
                onValueChange = {  },
                label = "Name",
                modifier = modifier.fillMaxWidth(),
                innerTextColor = Color.Black,
                shape = RoundedCornerShape(14.dp),
                keyboardType = KeyboardType.Text,
            )

            MyOutlinedTextField(
                value = "",
                onValueChange = {  },
                label = "Email",
                modifier = modifier.fillMaxWidth(),
                innerTextColor = Color.Black,
                shape = RoundedCornerShape(14.dp),
                keyboardType = KeyboardType.Email,
            )
            MyOutlinedTextField(
                value = "",
                onValueChange = {  },
                label = "Password",
                modifier = modifier.fillMaxWidth(),
                innerTextColor = Color.Black,
                shape = RoundedCornerShape(14.dp),
                keyboardType = KeyboardType.Password
            )
//            MyOutlinedTextField(
//                value = "",
//                onValueChange = { },
//                label = "Place",
//                modifier = modifier.fillMaxWidth(),
//                innerTextColor = Color.Black,
//                shape = RoundedCornerShape(14.dp),
//                keyboardType = KeyboardType.Text
//            )
            Spacer(modifier = Modifier.height(5.dp))
            ElevatedButton(
                onClick = {

//                    if (name.isEmpty() || password.isEmpty() || email.isEmpty()|| place.isEmpty()) {
//                        Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
//                    } else {
//                        Firebase.messaging.subscribeToTopic(place)
//                        authViewModel.register(
//                            email, password, name, context
//                        )
//                    }
                },
                colors = ButtonDefaults.buttonColors()
                    .copy(containerColor = Color(0xFFDA5D5D), contentColor = Color(0xFFFFFFFF))
            ) {
                Text(
                    text = "Sign Up",
                    modifier = Modifier.padding(5.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp, color =Color(0xFFFCF2F2)
                )
            }
            TextButton(onClick = {
//                navController.navigate(NavRoutes.Login.route) {
//                    popUpTo(navController.graph.startDestinationId)
//                    launchSingleTop = true
//                }
            }) {
                Text(text = "Already have an Account? Login Here",color = Color(0xFF0D83FF))
            }
        }
    }
}


@Preview
@Composable
private fun p() {
    SignUp()
}