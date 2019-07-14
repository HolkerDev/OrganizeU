package pl.holker.oraganizeu_android.functionalities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import pl.holker.oraganizeu_android.R
import pl.holker.oraganizeu_android.databinding.ActivityMainBinding
import pl.holker.oraganizeu_android.di.Injectable
import pl.holker.oraganizeu_android.di.ViewModelInjectionFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Injectable {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityVM

    @Inject
    lateinit var viewModelInjectionFactory: ViewModelInjectionFactory<MainActivityVM>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBinding()
    }

    private fun initBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, viewModelInjectionFactory).get(MainActivityVM::class.java)
        binding.viewModel = viewModel
    }
}
