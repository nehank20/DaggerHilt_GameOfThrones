package com.poilkar.nehank.daggerhilt_demo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.poilkar.nehank.daggerhilt_demo.R
import com.poilkar.nehank.daggerhilt_demo.model.DiffUtilSeriesModel
import com.poilkar.nehank.daggerhilt_demo.model.SeriesModel
import com.poilkar.nehank.daggerhilt_demo.util.loadImageFromUrl
import kotlinx.android.synthetic.main.row_item_list.view.*

class SeriesAdapter : RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>() {

    lateinit var listener: ItemClickListener


    inner class SeriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(currentEpisode: SeriesModel.Embedded.Episode?) {

            itemView.apply {
                tvEpisodeName.text = currentEpisode?.name
                tvEpisodeMins.text = currentEpisode?.runtime.toString()
                tvEpisodeSeason.text = currentEpisode?.season.toString()
                tvEpisodeNumber.text = currentEpisode?.number.toString()
                tvEpisodeImage?.loadImageFromUrl(currentEpisode?.image?.original)
            }

            itemView.setOnClickListener {
                listener.onItemClickListener(currentEpisode!!, itemView.tvEpisodeImage)
            }
        }
    }



    private val differCallback = object : DiffUtil.ItemCallback<SeriesModel.Embedded.Episode>(){
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
    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item_list,parent,false)
        return SeriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        val currentEpisode = differ.currentList[position]
        holder.bind(currentEpisode)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    interface ItemClickListener {
        fun onItemClickListener(item: SeriesModel.Embedded.Episode, imageView: ImageView)
    }
}