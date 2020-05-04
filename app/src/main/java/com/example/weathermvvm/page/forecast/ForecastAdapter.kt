package com.example.weathermvvm.page.forecast

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weathermvvm.R
import com.example.weathermvvm.model.Hourly

class ForecastAdapter : ListAdapter<Hourly, ForecastViewHolder>(UserItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        return ForecastViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_forecast_holder_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.onBind(getItem(position), position)
    }
}

class UserItemDiffCallback : DiffUtil.ItemCallback<Hourly>() {
    override fun areItemsTheSame(oldItem: Hourly, newItem: Hourly): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Hourly, newItem: Hourly): Boolean = oldItem == newItem
}