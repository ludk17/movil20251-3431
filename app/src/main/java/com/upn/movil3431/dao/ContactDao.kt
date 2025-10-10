package com.upn.movil3431.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.upn.movil3431.entities.sql.Contact

@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts")
    suspend fun getAllContacts() : List<Contact>

    @Query("SELECT * FROM contacts WHERE id = :id")
    suspend fun findContactById(id: Int): Contact?

    @Insert
    suspend fun createContact(contact: Contact): Long


}