package com.example.motes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IMotesRVAdapter {

    lateinit var viewModel: MoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager= LinearLayoutManager(this)
        val adapter= MotesRVAdapter(this,this)
        recyclerView.adapter=adapter
        viewModel= ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MoteViewModel::class.java)
        viewModel.allMotes.observe(this, Observer {list->list?.let {
            adapter.updateList(it)
        }
        })

    }

    override fun onItemClicked(mote: Mote)
    {
        viewModel.deleteMote(mote)
        Toast.makeText(this,"${mote.text} Deleted",Toast.LENGTH_SHORT).show()
    }

    fun sumbitData(view: View) {
        val moteText= input.text.toString()
        if(moteText.isNotEmpty())
        {
            viewModel.insertMote(Mote(moteText))
        }
    }

}