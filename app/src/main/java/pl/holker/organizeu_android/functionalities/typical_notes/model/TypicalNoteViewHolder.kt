package pl.holker.organizeu_android.functionalities.typical_notes.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_note.view.*
import pl.holker.organizeu_android.R
import pl.holker.organizeu_android.data.persistance.Note

class TypicalNoteViewHolder(val inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.card_note, parent, false)) {
    fun bind(note: Note) {
        itemView.card_note_tv_test.text = note.content
    }
}