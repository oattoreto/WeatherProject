package com.example.weathermvvm.page.forecast

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weathermvvm.databinding.ActivityForecastHolderItemBinding
import com.example.weathermvvm.model.Hourly

class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding: ActivityForecastHolderItemBinding? by lazy { DataBindingUtil.bind<ActivityForecastHolderItemBinding>(itemView) }

    fun onBind(item: Hourly, position: Int) {
        binding?.apply {
            this.item = item
        }
    }
}