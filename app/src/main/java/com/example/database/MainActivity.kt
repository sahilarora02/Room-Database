package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.room.Room
import com.example.roomdatabase.Contact
import com.example.roomdatabase.ContactDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = Room.databaseBuilder(applicationContext ,
            ContactDatabase::class.java ,"contactDB" ).build()

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0 , "Sahil" , "9989898"))
        }
    }

    fun getData(view: View) {
        database.contactDao().getContact().observe(this , {
            Log.i("Here =>>>>" , it.toString())
        })
    }
}