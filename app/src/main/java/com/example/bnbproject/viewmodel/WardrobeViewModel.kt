package com.example.bnbproject.viewmodel

import androidx.lifecycle.ViewModel
import com.example.bnbproject.model.Compartment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WardrobeViewModel : ViewModel() {
    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance()
    private val compartmentRef = db.getReference("compartment_db")

    private val _compartments = MutableStateFlow<List<Compartment>>(emptyList())
    val compartments: StateFlow<List<Compartment>> = _compartments

    private val _compartment = MutableStateFlow(Compartment())
    val compartment: StateFlow<Compartment> = _compartment


    fun changeCmp(compartment: Compartment){
        _compartment.value=compartment
    }

    init {
        fetchCompartments {
            _compartments.value = it
        }
    }

    private fun fetchCompartments(onResult: (List<Compartment>) -> Unit) {
        compartmentRef.child(auth.currentUser!!.uid)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val result = mutableListOf<Compartment>()
                    for (compartmentSnapshot in snapshot.children) {
                        val compartment = compartmentSnapshot.getValue(Compartment::class.java)

                        compartment?.let {
                            result.add(0, compartment)
                            if (result.size == snapshot.childrenCount.toInt()) {
                                onResult(result)
                            }
                        }
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }


            })

    }

    fun addNewCompartment(compartment: Compartment) {
        val newCompartmentRef: DatabaseReference =
            compartmentRef.child(auth.currentUser!!.uid).child(compartment.id.toString())

        newCompartmentRef.setValue(compartment).addOnSuccessListener {
            fetchCompartments {
                _compartments.value = it
            }
        }.addOnFailureListener { }
    }

    fun editCompartment(compartment: Compartment) {

        val newCompartmentRef: DatabaseReference =
            compartmentRef.child(auth.currentUser!!.uid).child(compartment.id.toString())

        newCompartmentRef.updateChildren(
            mapOf(
                "id" to compartment.id,
                "width" to compartment.width,
                "height" to compartment.height,
                "type" to compartment.type,
                "percentageFiled" to compartment.percentageFiled
            )
        ).addOnSuccessListener {
            fetchCompartments {
                _compartments.value = it
            }
        }.addOnFailureListener{}
    }
}