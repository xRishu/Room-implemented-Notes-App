package com.example.motes

import androidx.lifecycle.LiveData

class MoteRepository(private val moteDao: MoteDao)
{
    val allMotes: LiveData<List<Mote>> =moteDao.getAllMotes()
    suspend fun insert(mote:Mote)
    {
        moteDao.insert(mote)
    }
    suspend fun delete(mote:Mote)
    {
        moteDao.delete(mote)
    }
}