package pl.holker.organizeu_android.data.persistance

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flowable<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNote(note: Note): Completable

    @Query("DELETE FROM notes")
    fun deleteAllNotes()
}