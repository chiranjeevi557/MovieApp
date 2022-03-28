package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.model.DataModel
import com.example.movieapp.viewmodel.MainAdapter
import com.example.movieapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.movieDetails()
        mainViewModel.movieInfo.observe(this, Observer { movies ->
            activityMainBinding.Recyclerview.also {
                it.adapter = MainAdapter(movies as List<DataModel>)
                it.layoutManager =LinearLayoutManager(this)
            }
        })

    }
}