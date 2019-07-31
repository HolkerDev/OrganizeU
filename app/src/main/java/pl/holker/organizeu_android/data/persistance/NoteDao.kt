package pl.holker.organizeu_android.data.persistance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Flowable

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getNotes(): Flowable<ArrayList<Note>>

    @Insert
    fun addNote(note: Note)
}