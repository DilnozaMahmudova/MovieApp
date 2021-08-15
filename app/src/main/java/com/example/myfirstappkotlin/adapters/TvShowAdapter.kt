package com.example.myfirstappkotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myfirstappkotlin.databinding.TvShowLayoutBinding
import com.example.myfirstappkotlin.models.TvShowItem


class TvShowAdapter() : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    lateinit var binding: TvShowLayoutBinding

    inner class MyViewHolder(binding: TvShowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = TvShowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow = tvShowItem[position]
        binding.tvRecipe.text = currentTvShow.name
        binding.imageRecipe.load(currentTvShow.image.original) {
            crossfade(true)
            crossfade(1000)
        }
    }

    override fun getItemCount(): Int = tvShowItem.size


    private val diffCalBack = object : DiffUtil.ItemCallback<TvShowItem>() {

        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return newItem == oldItem
        }

    }
    val differ = AsyncListDiffer(this, diffCalBack)
    var tvShowItem: List<TvShowItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)


}