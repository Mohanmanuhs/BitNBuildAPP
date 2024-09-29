package com.example.bnbproject.screens

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.bnbproject.R
import com.example.bnbproject.Utils.MyOutlinedTextField
import com.example.bnbproject.Utils.SharedPref
import com.example.bnbproject.model.SellItemModel
import com.example.bnbproject.viewmodel.SellItemViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SellingScreen(
    modifier: Modifier = Modifier, sellItemViewModel: SellItemViewModel = viewModel()
) {
    var name by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var details by remember { mutableStateOf("") }
    var sellingPrice by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    val isPosted by sellItemViewModel.isPosted.collectAsState()
    val permissionToRequest = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        Manifest.permission.READ_MEDIA_IMAGES
    } else {
        Manifest.permission.READ_EXTERNAL_STORAGE
    }
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri = uri
        }
    val permissionLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission()) {

        }

    LaunchedEffect(key1 = isPosted) {
        if (isPosted) {
            imageUri = null
            Toast.makeText(context, "Thread posted", Toast.LENGTH_SHORT).show()
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ), title = {
                Text("Sell Item")
            })
        },
    ) { innerPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(10.dp)
        ) {

            item {
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier.fillParentMaxWidth(.8f).fillParentMaxHeight(.5f),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = if (imageUri == null) painterResource(id = R.drawable.placeholder) else rememberAsyncImagePainter(
                            model = imageUri
                        ),
                        contentDescription = "Clothing Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillParentMaxWidth(.8f).fillParentMaxHeight(.5f)
                            .clip(RectangleShape)
                            .border(2.dp, MaterialTheme.colorScheme.primary, RectangleShape)
                    )
                    IconButton(modifier = Modifier.align(Alignment.BottomEnd), onClick = {
                        val isGranted = ContextCompat.checkSelfPermission(
                            context, permissionToRequest
                        ) == PackageManager.PERMISSION_GRANTED

                        if (isGranted) {
                            launcher.launch("image/*")
                        } else {
                            permissionLauncher.launch(permissionToRequest)
                        }

                    }) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add Image",
                            modifier = Modifier
                                .size(32.dp)
                                .background(MaterialTheme.colorScheme.primary, CircleShape)
                                .padding(4.dp)
                                .clip(CircleShape)
                                .border(2.dp, MaterialTheme.colorScheme.onPrimary, CircleShape),
                            tint = MaterialTheme.colorScheme.onPrimary
                        )
                    }
                }
            }
            item {
                MyOutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    label = "Name",
                    onValueChange = {
                        name = it
                    },
                    shape = RectangleShape,
                    innerTextColor = Color.DarkGray,
                    keyboardType = KeyboardType.Text
                )
                MyOutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = type,
                    label = "Type",
                    onValueChange = {
                        type = it
                    },
                    shape = RectangleShape,
                    innerTextColor = Color.DarkGray,
                    keyboardType = KeyboardType.Text
                )
                MyOutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = price,
                    label = "Price",
                    onValueChange = {
                        price = it
                    },
                    shape = RectangleShape,
                    innerTextColor = Color.DarkGray,
                    keyboardType = KeyboardType.Text
                )
                MyOutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = details,
                    label = "Details",
                    onValueChange = {
                        details = it
                    },
                    shape = RectangleShape,
                    innerTextColor = Color.DarkGray,
                    keyboardType = KeyboardType.Text
                )
                MyOutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = sellingPrice,
                    label = "Selling Price",
                    onValueChange = {
                        sellingPrice = it
                    },
                    shape = RectangleShape,
                    innerTextColor = Color.DarkGray,
                    keyboardType = KeyboardType.Text
                )
                Button(onClick = {
                    sellItemViewModel.saveImage(
                        SellItemModel(
                            "",
                            name,
                            "",
                            type,
                            SharedPref.getName(context),
                            price,
                            details,
                            sellingPrice,
                            SharedPref.getEmail(context)
                        ), imageUri!!
                    )
                }) {
                    Text(text = "Report")
                }
            }
        }
    }
}