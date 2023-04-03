package com.example.archcompapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),NoteAdapter.INoteAdapter {

    private lateinit var rvNotesRecycler: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
    private val noteViewModel: NoteViewModel by viewModels {
        NoteViewModel.NoteViewModelFactory((application as MyApplication).repository)
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvNotesRecycler=findViewById(R.id.rvNotesRecycler)
        noteViewModel.allNotes.observe(this) { list ->
            list?.let {
                noteAdapter = NoteAdapter(it, this)
                rvNotesRecycler.adapter = noteAdapter
                noteAdapter.notifyDataSetChanged()
            }
        }
        val editText=findViewById<EditText>(R.id.etNoteText)

        findViewById<Button>(R.id.btnInsert).setOnClickListener{
            val text=editText.text.toString()
            noteViewModel.insertNote(Note(text))
        }


    }

    override fun onItemClicked(note: Note) {
        noteViewModel.deleteNote(note)
    }
}