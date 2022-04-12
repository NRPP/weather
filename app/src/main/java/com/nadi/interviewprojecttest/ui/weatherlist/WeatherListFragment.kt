package com.nadi.interviewprojecttest.ui.weatherlist

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nadi.interviewprojecttest.R
import com.nadi.interviewprojecttest.databinding.FragmentWeatherListBinding
import com.nadi.interviewprojecttest.ui.adapter.WeatherAdapter
import com.nadi.interviewprojecttest.ui.weatherdetails.WeatherDetailViewModel


class WeatherListFragment : Fragment() {

    private val viewmodel: WeatherListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         val binding= FragmentWeatherListBinding.inflate(inflater, container, false)

        val weatherAdapter = WeatherAdapter()
        binding.apply {
            recycle.apply {
                adapter = weatherAdapter
            }
        }

        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this


        return binding.root
    }

}

