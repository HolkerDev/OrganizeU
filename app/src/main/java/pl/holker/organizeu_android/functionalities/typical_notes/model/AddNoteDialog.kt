package pl.holker.organizeu_android.functionalities.typical_notes.model

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import pl.holker.organizeu_android.R
import pl.holker.organizeu_android.functionalities.typical_notes.TypicalNotesVM

class AddNoteDialog(var viewModel: TypicalNotesVM) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let { fragmentActivity ->
            val builder = AlertDialog.Builder(fragmentActivity)
            val inflater = requireActivity().layoutInflater
            builder.setView(inflater.inflate(R.layout.dialog_add_note, null))
                .setPositiveButton("Save") { dialog, id ->
                    //TODO: Save a note
                }
                .setNegativeButton("Discard") { _, _ ->
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}