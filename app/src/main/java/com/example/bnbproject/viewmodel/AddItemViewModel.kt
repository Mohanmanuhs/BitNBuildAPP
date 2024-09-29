package com.example.bnbproject.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.bnbproject.model.UserItemModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

class AddItemViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance()
    private val userItemsRef = db.getReference("UserItems_db")
    private val storageRef = Firebase.storage.reference
    private val imageRef = storageRef.child("userItems/${UUID.randomUUID()}.jpg")
    private val _isPosted = MutableStateFlow(false)
    val isPosted: StateFlow<Boolean> = _isPosted


    fun saveImage(userItemModel: UserItemModel, imageUri: Uri) {
        val uploadTask = imageRef.putFile(imageUri)
        uploadTask.addOnSuccessListener {
            imageRef.downloadUrl.addOnSuccessListener {
                saveData(userItemModel, it.toString())
            }
        }
    }

    private fun saveData(
        userItemModel: UserItemModel, imageUrl: String
    ) {
        userItemsRef.child(auth.currentUser!!.uid).push().setValue(userItemModel.copy(id = UUID.randomUUID().toString(), img=imageUrl)).addOnSuccessListener {
                _isPosted.value = true
            }.addOnFailureListener {
                _isPosted.value = false
            }

    }

}