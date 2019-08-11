package pl.holker.organizeu_android.functionalities.typical_notes.model

import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_note.view.*
import pl.holker.organizeu_android.R
import pl.holker.organizeu_android.data.persistance.Note

class TypicalNoteViewHolder(val inflater: LayoutInflater, val parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.card_note, parent, false)) {

    private val TAG = TypicalNoteViewHolder::class.java.name

    fun bind(note: Note) {
        itemView.card_note_tv_title.text = note.title
        itemView.card_note_tv_content.text = note.content
        itemView.card_note_ll_main.setOnLongClickListener {
            val builder = AlertDialog.Builder(itemView.context)
            builder.setItems(
                R.array.note_options
            ) { _, which ->
                when (which) {
                    0 -> {
                        Log.i(TAG, "Edit was pressed")
                        TODO("Open edit dialog")
                    }
                    1 -> {
                        Log.i(TAG, "Delete one was pressed")
                        TODO("Delete current note from database")
                    }
                    else -> Log.e(TAG, "Empty was picked")
                }
            }
            builder.show()
            return@setOnLongClickListener true
        }
    }
}