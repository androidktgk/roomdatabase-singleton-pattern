package com.example.archcompapp

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) {

    val allNotes: Flow<MutableList<Note>> = noteDao.getAllNotes()

    @WorkerThread
    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    @WorkerThread
    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}