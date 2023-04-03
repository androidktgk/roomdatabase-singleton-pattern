package com.example.archcompapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private val notesList: MutableList<Note>, private val nListener: INoteAdapter): RecyclerView.Adapter<NoteAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvNotes: TextView =itemView.findViewById(R.id.tvNotes)
        val btnDelete: Button =itemView.findViewById(R.id.btnDelete)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.MyViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.note_list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.MyViewHolder, position: Int) {
        val currentItem= notesList[position]
        holder.tvNotes.text = currentItem.text
        holder.btnDelete.setOnClickListener{
            nListener.onItemClicked(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    interface INoteAdapter{
        fun onItemClicked(note: Note)
    }

}