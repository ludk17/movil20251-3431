package com.upn.movil3431.entities.sql

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contacts")
class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var lastName: String,
    var phone: String,
    var email: String
)