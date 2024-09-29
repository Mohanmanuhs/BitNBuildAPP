package com.example.bnbproject.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.bnbproject.model.UserItemModel
import com.example.bnbproject.model.UserModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel : ViewModel() {

    private val db = FirebaseDatabase.getInstance()
    private val userItemsRef = db.getReference("UserItems_db")
    private val usersRef = db.getReference("BitNBuild_Users")

    private val _user = MutableStateFlow(UserModel())
    val users: StateFlow<UserModel> = _user

    private val _itemsList = MutableStateFlow<List<UserItemModel>>(emptyList())
    val itemsList: StateFlow<List<UserItemModel>> = _itemsList

    private val _item = MutableStateFlow(UserItemModel())
    val item:StateFlow<UserItemModel> = _item

    fun fetchItem(id:String) {
        Log.d("MyNoneTAG", id)
        _item.value = _itemsList.value.find { it.id == id }?:UserItemModel()
    }

    fun fetchUser(uid: String) {
        usersRef.child(uid).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val user = snapshot.getValue(UserModel::class.java)
                if (user != null) {
                    _user.value = user
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    fun fetchUserItems(uid: String) {
        userItemsRef.child(uid)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val itemsList = snapshot.children.mapNotNull {
                        it.getValue(UserItemModel::class.java)
                    }
                    _itemsList.value = itemsList
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

    }

}