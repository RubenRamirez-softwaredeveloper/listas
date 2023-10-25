package com.example.listas.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listas.Film
import com.example.listas.databinding.ItemFilmBinding

class FilmViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val binding = ItemFilmBinding.bind(view)
    fun render(filmModel: Film){
        binding.FilmName.text = filmModel.title
        binding.FilmDirector.text = filmModel.director
        binding.FilmYear.text = filmModel.year.toString()
        // Falta acceder a la imagen de la pelicula
        Glide.with(binding.FilmPhoto.context).load(filmModel.photo).into(binding.FilmPhoto)
    }
}