package com.example.motes

import android.content.Context
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MotesRVAdapter(val context: Context, private val listener: IMotesRVAdapter):RecyclerView.Adapter<MotesRVAdapter.MoteViewHolder>()
{
    val allMotes= ArrayList<Mote>()
    inner class MoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val textView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton = itemView.findViewById<ImageView>(R.id.deleteBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoteViewHolder
    {
       val viewHolder=MoteViewHolder( LayoutInflater.from(context).inflate(R.layout.item_mote,parent,false))
       viewHolder.deleteButton.setOnClickListener{
           listener.onItemClicked(allMotes[viewHolder.adapterPosition])
       }
        return viewHolder
    }

    override fun getItemCount(): Int
    {
        return allMotes.size
    }

    override fun onBindViewHolder(holder: MoteViewHolder, position: Int)
    {
        val currentMote= allMotes[position]
        holder.textView.text=currentMote.text
    }

    fun updateList(newList:List<Mote>)
    {
        allMotes.clear()
        allMotes.addAll(newList)
        notifyDataSetChanged()
    }
}
interface IMotesRVAdapter
{
    fun onItemClicked(mote: Mote)
}