package com.example.motes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoteViewModel(application: Application): AndroidViewModel(application)
{
    private val repository: MoteRepository
    val allMotes: LiveData<List<Mote>>

    init
    {
        val dao= MoteDatabase.getDatabase(application).getMoteDao()
        repository=MoteRepository(dao)
        allMotes=repository.allMotes
    }

    fun deleteMote(mote:Mote)=viewModelScope.launch(Dispatchers.IO)
    {
        repository.delete(mote)
    }

    fun insertMote(mote: Mote)=viewModelScope.launch(Dispatchers.IO)
    {
        repository.insert(mote)
    }
}
