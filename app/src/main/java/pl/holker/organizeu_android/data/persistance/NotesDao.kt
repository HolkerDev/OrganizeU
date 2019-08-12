package pl.holker.organizeu_android.data.persistance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface NotesDao {
    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flowable<List<Note>>

    @Query("SELECT * FROM location_notes")
    fun getLocationNotes(): Flowable<List<NoteLocation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: Note): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addLocationNote(noteLocation: NoteLocation): Completable

    @Query("DELETE FROM notes")
    fun deleteAllNotes()

    @Query("DELETE FROM location_notes")
    fun deleteAllLocationNotes()
}