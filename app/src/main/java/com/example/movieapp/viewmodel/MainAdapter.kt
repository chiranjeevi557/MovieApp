package com.example.movieapp.viewmodel

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.MainActivity
import com.example.movieapp.R
import com.example.movieapp.databinding.GridLayoutBinding
import com.example.movieapp.model.DataModel

class MainAdapter(private val mList: List<DataModel>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    lateinit var binding: GridLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GridLayoutBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList.get(position))
        holder.binding.root.setOnClickListener(){

        }
    }


    override fun getItemCount(): Int {
        return mList.size

    }

    class ViewHolder(val binding: GridLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: DataModel) {
            binding.recyclerViewModel = movie
            binding.executePendingBindings()
        }
    }


}

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, imageurl: String) {
    Glide.with(view.context)
        .load(imageurl)
        .circleCrop()

        .placeholder(R.drawable.ic_launcher_foreground)
        .error(R.drawable.ic_launcher_foreground)
        .fallback(R.drawable.ic_launcher_foreground)
        .into(view)
}
