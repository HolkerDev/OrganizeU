package pl.holker.organizeu_android.functionalities.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_start.*
import pl.holker.organizeu_android.R
import pl.holker.organizeu_android.databinding.ActivityStartBinding
import pl.holker.organizeu_android.di.Injectable
import pl.holker.organizeu_android.di.ViewModelInjectionFactory
import pl.holker.organizeu_android.functionalities.location_notes.LocationNotesFragment
import pl.holker.organizeu_android.functionalities.typical_notes.TypicalNotesFragment
import javax.inject.Inject

class StartActivity : AppCompatActivity(), Injectable {

    private val TAG = StartActivity::class.java.name

    private lateinit var binding: ActivityStartBinding
    private lateinit var viewModel: StartActivityVM
    @Inject
    lateinit var viewModelInjectionFactory: ViewModelInjectionFactory<StartActivityVM>

    private lateinit var mSelectionsPagerAdapter: SelectionsFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        initFragments()
    }

    private fun initFragments() {
        mSelectionsPagerAdapter = SelectionsFragmentAdapter(supportFragmentManager)
        setupViewPager()
        start_tl_tabs.setupWithViewPager(start_vp_container)
        start_vp_container.currentItem = 0
    }


    private fun setupViewPager() {
        val fragmentAdapter = mSelectionsPagerAdapter
        fragmentAdapter.addFragment("Notes", TypicalNotesFragment())
        fragmentAdapter.addFragment("Locations", LocationNotesFragment())
        start_vp_container.adapter = mSelectionsPagerAdapter
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start)
        viewModel =
            ViewModelProviders.of(this, viewModelInjectionFactory).get(StartActivityVM::class.java)
        binding.viewModel = viewModel
    }
}
