package pl.holker.organizeu_android.functionalities.typical_notes.model

sealed class TypicalNoteEvent {
    data class InsertNote(val title: String, val content: String) : TypicalNoteEvent()
}