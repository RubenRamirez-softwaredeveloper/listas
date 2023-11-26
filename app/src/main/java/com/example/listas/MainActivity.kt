package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listas.databinding.ActivityMainBinding
import com.example.listas.adapter.FilmAdapter

class MainActivity : ActivityWithMenus() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val decoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //FilmProvider.filmList[2].title
        binding.Recycler.layoutManager = LinearLayoutManager(this)
        //binding.Recycler.layoutManager = GridLayoutManager(this, 2) es para que se vea en 2 columnas
        var adapter = FilmAdapter(FilmProvider.filmList)
        binding.Recycler.adapter = FilmAdapter(FilmProvider.filmList)
        //binding.Recycler.addItemDecoration(decoration)

        val miDialogo = MiDialogFragment()

        binding.filtro.addTextChangedListener {filtro ->
            val filtroPelicula = FilmProvider.filmList.filter { film ->
                film.title.contains(filtro.toString())  }
        }

        binding.filtro.addTextChangedListener {filtro ->
            val filtroPelicula = FilmProvider.filmList.filter { film ->
                film.title.lowercase().contains(filtro.toString().lowercase())
            }
            adapter.actualizarPeliculas(filtroPelicula)
        }
    }
}