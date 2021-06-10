package com.example.livedatademo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.livedatademo.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        viewModel.count.observe(this, Observer {
            binding.tvCount.text = it.toString()
        })
        binding.btnClick.setOnClickListener {
            viewModel.updateCount()
        }
    }
}