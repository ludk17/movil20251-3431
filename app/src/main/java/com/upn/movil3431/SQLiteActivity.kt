package com.upn.movil3431

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.upn.movil3431.database.AppDatabase
import com.upn.movil3431.entities.sql.Contact
import com.upn.movil3431.ui.theme.Movil3431Theme

class SQLiteActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val db = AppDatabase.getAppDatabaseInstance(applicationContext)
        val contactDao = db.contactDao()


        enableEdgeToEdge()
        setContent {
            Movil3431Theme {

                var contacts by remember { mutableStateOf(listOf<Contact>()) }

                LaunchedEffect(Unit) {
//                    contacts = listOf(
//                        Contact(0, "Juan", "Perez", "123456789", "juan.perez@email.com"),
//                        Contact(0, "Maria", "Gomez", "987654321", "juan.perez@email.com"),
//                        Contact(0, "Carlos", "Sanchez", "456123789", "juan.perez@email.com"),
//                        Contact(0, "Ana", "Torres", "789456123", "juan.perez@email.com"),
//                    )
//                    contacts.forEach {
//                        val id = contactDao.createContact(it)
//                        Log.d("MAIN_APP", "Inserted contact with id: $id")
//                    }
                    contacts = contactDao.getAllContacts();
                    Log.d("MAIN_APP", "Contacts size: ${contacts.size}")
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        LazyColumn {
                            items(contacts) {
                                Text(text = "${it.id}: ${it.name} ${it.lastName}" )
                            }
                        }
                    }
                }
            }
        }
    }
}

