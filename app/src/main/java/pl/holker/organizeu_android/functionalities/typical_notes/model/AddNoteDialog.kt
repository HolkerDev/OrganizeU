package pl.holker.organizeu_android.functionalities.typical_notes.model

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_add_note.*
import pl.holker.organizeu_android.R
import pl.holker.organizeu_android.functionalities.typical_notes.TypicalNotesVM

class AddNoteDialog(var viewModel: TypicalNotesVM) : DialogFragment() {

    private val TAG = AddNoteDialog::class.java.name

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.dialog_add_note, null))
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onStart() {
        super.onStart()
        dialog.dialog_add_note_btn_discard.setOnClickListener {
            dialog.cancel()
        }
        dialog.dialog_add_note_btn_save.setOnClickListener {
            viewModel.event.value = TypicalNoteEvent.InsertNote(
                dialog.dialog_add_note_et_title.text.toString(),
                dialog.dialog_add_note_et_content.text.toString()
            )
            dialog.cancel()
        }
    }
}