package com.example.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdatabase.Contact


@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend  fun deleteContact(contact: Contact)

    @Query(value = "SELECT * FROM contact")
    fun getContact(): LiveData<List<Contact>>
}