package com.upn.movil3431

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.upn.movil3431.entities.Contact
import com.upn.movil3431.ui.theme.Movil3431Theme
import com.upn.movil3431.viewmodels.ContactListViewModel
import kotlin.math.log

class RealtimeDatabaseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        val contactsToFillDatabase = listOf(
//            Contact("","Juan Perez", "987654321"),
//            Contact("", "Maria Gomez", "123456789"),
//            Contact("", "Carlos Sanchez", "456789123"),
//            Contact("", "Ana Torres", "789123456"),
//            Contact("", "Luis Ramirez", "321654987"),
//            Contact("", "Juan Perez", "987654321"),
//            Contact("", "Maria Gomez", "123456789"),
//            Contact("", "Carlos Sanchez", "456789123"),
//            Contact("", "Ana Torres", "789123456"),
//            Contact("", "Luis Ramirez", "321654987"),
//            Contact("", "Juan Perez", "987654321"),
//            Contact("", "Maria Gomez", "123456789"),
//            Contact("", "Carlos Sanchez", "456789123"),
//        )
//
//        // Write a message to the database
//        val database = Firebase.database
//        val ref = database.reference
//        for (item in contactsToFillDatabase) {
//            val newChild1 = ref.child("contacts").push()
//            item.id = newChild1.key.toString()
//            newChild1.setValue(item)
//        }

        setContent {
            Movil3431Theme {

                val viewmodel: ContactListViewModel by viewModels()

                LaunchedEffect(Unit) {
                    viewmodel.loadContacts()
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center

                    ) {
                        if (viewmodel.isLoading) {
                            CircularProgressIndicator()
                        } else {
                            LazyColumn {
                                items(viewmodel.contacts) { contact ->
                                    Text(text = contact.name)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}