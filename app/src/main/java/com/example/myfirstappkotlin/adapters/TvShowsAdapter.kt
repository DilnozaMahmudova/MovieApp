package com.example.myfirstappkotlin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myfirstappkotlin.databinding.TvShowLayoutBinding
import com.example.myfirstappkotlin.models.TvShowItem


/**
 * Created by Abdurashidov Shahzod on 15/08/21 23:02.
 * company QQBank
 * shahzod9933@gmail.com
 */
class TvShowsAdapter() : RecyclerView.Adapter<TvShowsAdapter.MyViewHolder>() {

    lateinit var binding: TvShowLayoutBinding

    inner class MyViewHolder() : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = TvShowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTvShow = tvShowList[position]
        binding.tvRecipe.text = currentTvShow.name
        binding.imageRecipe.load(currentTvShow.image.original) {
            crossfade(true)
            crossfade(1000)
        }
    }

    override fun getItemCount(): Int = tvShowList.size

    private val diffCallBack = object : DiffUtil.ItemCallback<TvShowItem>() {
        override fun areItemsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TvShowItem, newItem: TvShowItem): Boolean {
            return newItem == oldItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    var tvShowList: List<TvShowItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)

}