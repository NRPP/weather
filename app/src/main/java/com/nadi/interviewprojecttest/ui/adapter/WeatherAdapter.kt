package com.nadi.interviewprojecttest.ui.adapter

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nadi.interviewprojecttest.data.WeatherEntity
import com.nadi.interviewprojecttest.databinding.ItemWeatherBinding
import com.nadi.interviewprojecttest.service.apiresponce.ResponseWeather

class WeatherAdapter() : ListAdapter<ResponseWeather, WeatherAdapter.MyViewHolder>(MyDiff()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val binding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return  MyViewHolder(binding)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = getItem(position)
        currentItem?.let {
            holder.bind(it)
        }

    }


    class MyViewHolder(private var binding: ItemWeatherBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(it: ResponseWeather) {
            binding.response = it
            binding.executePendingBindings()
        }

    }

    class MyDiff : DiffUtil.ItemCallback<ResponseWeather>() {
        override fun areItemsTheSame(oldItem: ResponseWeather, newItem: ResponseWeather): Boolean {
            return oldItem.current.condition.text == newItem.current.condition.text
        }

        override fun areContentsTheSame(oldItem: ResponseWeather, newItem: ResponseWeather): Boolean {

            return oldItem == newItem

        }

    }

}