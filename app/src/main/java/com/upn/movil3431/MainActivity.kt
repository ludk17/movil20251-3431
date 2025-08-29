package com.upn.movil3431

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.upn.movil3431.adapters.ContactAdapter
import com.upn.movil3431.entities.Contact

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

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

        val rvContact = findViewById<RecyclerView>(R.id.rvContacts)
        rvContact.adapter = ContactAdapter(concats)

        rvContact.setHasFixedSize(true)
        rvContact.layoutManager = LinearLayoutManager(this)

    }
}