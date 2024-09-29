package com.example.bnbproject.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.example.bnbproject.model.SellItemModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

class SellItemViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance()
    private val sellItemRef = db.getReference("SoldItems_Db")
    private val storageRef = Firebase.storage.reference
    private val imageRef = storageRef.child("SoldItems/${UUID.randomUUID()}.jpg")
    private val _isPosted = MutableStateFlow(false)
    val isPosted: StateFlow<Boolean> = _isPosted


    fun saveImage(sellItemModel: SellItemModel, imageUri: Uri) {
        val uploadTask = imageRef.putFile(imageUri)
        uploadTask.addOnSuccessListener {
            imageRef.downloadUrl.addOnSuccessListener {
                saveData(sellItemModel, it.toString())
            }
        }
    }




    private fun saveData(
        sellItemModel: SellItemModel, imageUrl: String
    ) {
        val ref = sellItemRef.push()
        ref.setValue(sellItemModel.copy(
            img=imageUrl, id = UUID.randomUUID().toString())).addOnSuccessListener {
                _isPosted.value = true
            }.addOnFailureListener {
                _isPosted.value = false
            }
    }

}