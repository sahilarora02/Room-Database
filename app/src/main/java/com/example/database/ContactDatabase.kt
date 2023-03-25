package com.example.roomdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.ContactDao


@Database(entities = [Contact::class] , version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao() : ContactDao
}