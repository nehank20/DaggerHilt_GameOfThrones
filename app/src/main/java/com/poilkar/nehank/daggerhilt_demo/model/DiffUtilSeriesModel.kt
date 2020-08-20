package com.poilkar.nehank.daggerhilt_demo.model

import androidx.recyclerview.widget.DiffUtil

class DiffUtilSeriesModel : DiffUtil.ItemCallback<SeriesModel.Embedded.Episode>() {
    override fun areItemsTheSame(
        oldItem: SeriesModel.Embedded.Episode,
        newItem: SeriesModel.Embedded.Episode
    ): Boolean {
        return newItem.id == oldItem.id
    }

    override fun areContentsTheSame(
        oldItem: SeriesModel.Embedded.Episode,
        newItem: SeriesModel.Embedded.Episode
    ): Boolean {
        return newItem == oldItem
    }
}