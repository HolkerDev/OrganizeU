package pl.holker.organizeu_android.data.persistance

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getNotes(): LiveData<List<Note>>

    @Insert
    fun addNote(note: Note)
}