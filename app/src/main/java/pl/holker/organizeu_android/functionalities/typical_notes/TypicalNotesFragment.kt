package pl.holker.organizeu_android.functionalities.typical_notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_typical_notes.*
import pl.holker.organizeu_android.R
import pl.holker.organizeu_android.databinding.FragmentTypicalNotesBinding
import pl.holker.organizeu_android.di.Injectable
import pl.holker.organizeu_android.di.ViewModelInjectionFactory
import javax.inject.Inject

class TypicalNotesFragment @Inject constructor() : Fragment(), Injectable {

    private val TAG = TypicalNotesFragment::class.java.name

    private lateinit var viewModel: TypicalNotesVM
    private lateinit var binding: FragmentTypicalNotesBinding
    private val disposable = CompositeDisposable()

    @Inject
    lateinit var viewModelInjectionFactory: ViewModelInjectionFactory<TypicalNotesVM>

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_typical_notes, container, false)
        viewModel =
                ViewModelProviders.of(this, viewModelInjectionFactory).get(TypicalNotesVM::class.java)

        binding.viewModel = viewModel
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        floatingActionButton.setOnClickListener {
            disposable.add(viewModel.insert().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
                typical_notes_tv_test.text = "Done"
            })
        }

        disposable.add(viewModel.getAmount().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe {
            typical_notes_tv_test.text = it.toString()
        })
    }
}