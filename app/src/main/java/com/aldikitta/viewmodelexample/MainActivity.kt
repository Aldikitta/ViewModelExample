package com.aldikitta.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.aldikitta.viewmodelexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(0, 0)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]
        binding.myViewModel = viewModel
        binding.lifecycleOwner = this
//        viewModel.countData.observe(this) {
//            binding.countText.text = it.toString()
//        }

//        binding.button.setOnClickListener {
//            viewModel.getUpdatedCount().toString()
//        }

        viewModel.totalData.observe(this) {
            binding.resultTextview.text = it.toString()
        }

        binding.inserButton.setOnClickListener {
            viewModel.setTotal(binding.editText.text.toString().toInt())
        }
    }
}