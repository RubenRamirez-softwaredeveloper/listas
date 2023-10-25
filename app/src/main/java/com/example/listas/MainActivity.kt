package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listas.databinding.ActivityMainBinding
import com.example.listas.adapter.FilmAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //FilmProvider.filmList[2].title
        binding.Recycler.layoutManager = LinearLayoutManager(this)
        binding.Recycler.adapter = FilmAdapter(FilmProvider.filmList)
    }
}