package com.ncodes.walmart.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncodes.walmart.databinding.ItemLayoutBinding
import com.ncodes.walmart.domain.models.Country

class RecyclerViewAdapter(private val countryList: List<Country?>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(country: Country?){
            binding.name.text = country?.name
            binding.region.text = country?.region
            binding.code.text = country?.code
            binding.capital.text = country?.capital
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = countryList[position]
        holder.bind(currentItem)
    }
}
