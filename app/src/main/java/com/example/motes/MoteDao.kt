package com.example.motes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MoteDao
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(mote: Mote)

    @Delete
    suspend fun delete(mote: Mote)

    @Query("Select * from motes_table order by id ASC")
    fun getAllMotes(): LiveData<List<Mote>>
}