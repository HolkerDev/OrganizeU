package pl.holker.organizeu_android.functionalities.typical_notes

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_typical_notes.*
import pl.holker.organizeu_android.R
import pl.holker.organizeu_android.databinding.FragmentTypicalNotesBinding
import pl.holker.organizeu_android.di.Injectable
import pl.holker.organizeu_android.di.ViewModelInjectionFactory
import pl.holker.organizeu_android.functionalities.typical_notes.model.GridSpacingItemDecoration
import pl.holker.organizeu_android.functionalities.typical_notes.model.TypicalNoteAdapter
import javax.inject.Inject
import kotlin.math.roundToInt

class TypicalNotesFragment @Inject constructor() : Fragment(), Injectable {

    private val TAG = TypicalNotesFragment::class.java.name

    private lateinit var _viewModel: TypicalNotesVM
    private lateinit var _binding: FragmentTypicalNotesBinding
    private val _disposable = CompositeDisposable()
    private lateinit var _adapter: TypicalNoteAdapter


    @Inject
    lateinit var viewModelInjectionFactory: ViewModelInjectionFactory<TypicalNotesVM>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_typical_notes, container, false)
        _viewModel =
            ViewModelProviders.of(this, viewModelInjectionFactory)
                .get(TypicalNotesVM::class.java)

        _binding.viewModel = _viewModel
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _adapter = TypicalNoteAdapter(listOf())
        card_note_recycler_view.layoutManager = GridLayoutManager(context, 2)
        card_note_recycler_view.addItemDecoration(GridSpacingItemDecoration(2, dpToPx(10), true))
        card_note_recycler_view.adapter = _adapter
    }

    override fun onStart() {
        super.onStart()


        floatingActionButton.setOnClickListener {
            //TODO: Bind to create new dialog
        }

        //Pull note list
        _disposable.add(
            _viewModel.getAmount().subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()
            ).subscribe({ noteList ->
                Log.i(TAG, "Start pulling note list")
                _adapter.items = noteList
                _adapter.notifyDataSetChanged()
                Log.i(TAG, "Pulling was finished")
            }, { error ->
                Log.e(TAG, "Error while pulling notes : ${error.message}")
            })
        )

    }

    private fun dpToPx(dp: Int): Int {
        val resource = resources
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            resource.displayMetrics
        ).roundToInt()
    }
}