package com.example.motes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MoteDatabase:RoomDatabase()
{
    abstract fun getMoteDao(): MoteDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MoteDatabase? = null

        fun getDatabase(context: Context): MoteDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {//synchronized so that no other thread can access this block till this block is running
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MoteDatabase::class.java,
                    "mote_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
