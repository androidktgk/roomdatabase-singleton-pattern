package com.example.archcompapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)
    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): Flow<MutableList<Note>>
}