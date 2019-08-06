package pl.holker.organizeu_android.functionalities.typical_notes.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.holker.organizeu_android.data.persistance.Note

class TypicalNoteAdapter(var items: List<Note>) : RecyclerView.Adapter<TypicalNoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypicalNoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TypicalNoteViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TypicalNoteViewHolder, position: Int) {
        val note = items[position]
        holder.bind(note)
    }

}