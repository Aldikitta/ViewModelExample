package com.aldikitta.viewmodelexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aldikitta.viewmodelexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)



        binding.countText.text = viewModel.getCurrentCount().toString()

        binding.button.setOnClickListener {
            binding.countText.text = viewModel.getUpdatedCount().toString()
        }

        viewModel.total.observe(this, Observer {
            binding.resultTextview.text = it.toString()
        })


        binding.inserButton.setOnClickListener {
            viewModel.setTotal(binding.editText.text.toString().toInt())
        }
    }
}