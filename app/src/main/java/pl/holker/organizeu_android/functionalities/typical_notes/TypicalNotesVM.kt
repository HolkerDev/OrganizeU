package pl.holker.organizeu_android.functionalities.typical_notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.Completable
import io.reactivex.Flowable
import pl.holker.organizeu_android.data.persistance.Note
import pl.holker.organizeu_android.data.persistance.NotesDatabase
import pl.holker.organizeu_android.functionalities.typical_notes.model.TypicalNoteEvent
import javax.inject.Inject

class TypicalNotesVM @Inject constructor(application: Application) : AndroidViewModel(application) {
    private var _dataSource = NotesDatabase.getInstance(application.applicationContext).noteDao()
    var event = MutableLiveData<TypicalNoteEvent>()

    fun insertNote(title: String, content: String): Completable {
        val note = Note(0, title, content)
        return _dataSource.addNote(note)
    }

    fun getAmount(): Flowable<List<Note>> {
        val list = _dataSource.getAllNotes()
        return list.map { listNote: List<Note> ->
            listNote
        }
    }

}