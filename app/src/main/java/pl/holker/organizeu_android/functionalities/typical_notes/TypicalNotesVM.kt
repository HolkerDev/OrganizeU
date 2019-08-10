package pl.holker.organizeu_android.functionalities.typical_notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import pl.holker.organizeu_android.data.persistance.Note
import pl.holker.organizeu_android.data.persistance.NotesDatabase
import javax.inject.Inject

class TypicalNotesVM @Inject constructor(application: Application) : AndroidViewModel(application) {
    var datasource = NotesDatabase.getInstance(application.applicationContext).noteDao()

    private val disposable = CompositeDisposable()

    fun insert(): Completable {
        val note = Note(0, "Test","Some content just for test")
        return datasource.addNote(note)
    }

    fun getAmount(): Flowable<List<Note>> {
        var list = datasource.getAllNotes()
        return list.map { listNote: List<Note> ->
            listNote
        }
    }

}