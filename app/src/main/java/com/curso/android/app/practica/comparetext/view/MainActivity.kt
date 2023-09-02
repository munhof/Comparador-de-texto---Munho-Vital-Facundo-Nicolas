package com.curso.android.app.practica.comparetext.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.curso.android.app.practica.comparetext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TextCompareViewModel
    private lateinit var binding: ActivityMainBinding // View Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TextCompareViewModel::class.java)

        binding.buttonCompare.setOnClickListener {
            val text1 = binding.editText1.text.toString()
            val text2 = binding.editText2.text.toString()

            val result = viewModel.compareText(text1, text2)
            binding.textViewResult.text = "$result"
        }
    }
}