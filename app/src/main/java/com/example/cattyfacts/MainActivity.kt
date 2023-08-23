package com.example.cattyfacts

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cattyfacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.getCatFact().observe(this, Observer {
            val textTemplate = applicationContext.resources.getString(R.string.text_template)
            binding.textViewFact.text = String.format(textTemplate, it)
            Log.d("MainActivity", it.toString())
        })
        binding.buttonToGenerateFact.setOnClickListener {
            viewModel.loadData()
        }


    }


}