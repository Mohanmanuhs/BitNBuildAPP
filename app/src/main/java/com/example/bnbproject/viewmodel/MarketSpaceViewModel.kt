package com.example.bnbproject.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bnbproject.model.SellItemModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MarketSpaceViewModel:ViewModel() {

    private val db = FirebaseDatabase.getInstance()
    private val userRef = db.getReference("SoldItems_Db")
    private val _itemsList = MutableStateFlow<List<SellItemModel>>(emptyList())
    val itemsList:StateFlow<List<SellItemModel>> = _itemsList


    init {
        fetchUsers {
            _itemsList.value = it
        }
    }

    private fun fetchUsers(onResult:(List<SellItemModel>)->Unit) {
        userRef.addValueEventListener(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val result = mutableListOf<SellItemModel>()
                for(userSnapshot in snapshot.children) {
                    val user = userSnapshot.getValue(SellItemModel::class.java)

                    user?.let{
                        result.add(0,it)
                    }

                }
                onResult(result)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}