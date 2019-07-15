package pl.holker.organizeu_android.functionalities.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import pl.holker.organizeu_android.R
import pl.holker.organizeu_android.databinding.ActivityStartBinding
import pl.holker.organizeu_android.di.Injectable
import pl.holker.organizeu_android.di.ViewModelInjectionFactory
import javax.inject.Inject

class StartActivity : AppCompatActivity(), Injectable {

    private val TAG = StartActivity::class.java.name

    private lateinit var binding: ActivityStartBinding
    private lateinit var viewModel: StartActivityVM
    @Inject
    lateinit var viewModelInjectionFactory: ViewModelInjectionFactory<StartActivityVM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start)
        viewModel = ViewModelProviders.of(this, viewModelInjectionFactory).get(StartActivityVM::class.java)
        binding.viewModel = viewModel
    }
}
