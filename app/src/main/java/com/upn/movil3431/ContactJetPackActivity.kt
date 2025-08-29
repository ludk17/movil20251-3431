package com.upn.movil3431

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.upn.movil3431.entities.Contact
import com.upn.movil3431.ui.theme.Movil3431Theme

class ContactJetPackActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val concats = listOf(
            Contact("Juan Perez", "987654321"),
            Contact("Maria Gomez", "123456789"),
            Contact("Carlos Sanchez", "456789123"),
            Contact("Ana Torres", "789123456"),
            Contact("Luis Ramirez", "321654987"),
            Contact("Juan Perez", "987654321"),
            Contact("Maria Gomez", "123456789"),
            Contact("Carlos Sanchez", "456789123"),
            Contact("Ana Torres", "789123456"),
            Contact("Luis Ramirez", "321654987"),
            Contact("Juan Perez", "987654321"),
            Contact("Maria Gomez", "123456789"),
            Contact("Carlos Sanchez", "456789123"),
            Contact("Ana Torres", "789123456"),
            Contact("Luis Ramirez", "321654987"),
            Contact("Juan Perez", "987654321"),
            Contact("Maria Gomez", "123456789"),
            Contact("Carlos Sanchez", "456789123"),
            Contact("Ana Torres", "789123456"),
            Contact("Luis Ramirez", "321654987"),
            Contact("Juan Perez", "987654321"),
            Contact("Maria Gomez", "123456789"),
            Contact("Carlos Sanchez", "456789123"),
            Contact("Ana Torres", "789123456"),
            Contact("Luis Ramirez", "321654987"),
            Contact("Juan Perez", "987654321"),
            Contact("Maria Gomez", "123456789"),
            Contact("Carlos Sanchez", "456789123"),
            Contact("Ana Torres", "789123456"),
            Contact("Luis Ramirez", "321654987"),
        )

        setContent {
            Movil3431Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LazyColumn(modifier = Modifier.fillMaxWidth().padding(innerPadding))
                    {
                        items(concats.size) { index ->
                            val contact = concats[index]
                            Column {
                                Text(
                                    text = contact.name,
                                )
                                Text(
                                    text = contact.phone
                                )
                            }
                            HorizontalDivider(
                                Modifier,
                                DividerDefaults.Thickness,
                                DividerDefaults.color
                            )
                        }
                    }
                }
            }
        }
    }
}
