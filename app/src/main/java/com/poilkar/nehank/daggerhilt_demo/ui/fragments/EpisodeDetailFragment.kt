package com.poilkar.nehank.daggerhilt_demo.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.poilkar.nehank.daggerhilt_demo.R
import com.poilkar.nehank.daggerhilt_demo.model.SeriesModel
import com.poilkar.nehank.daggerhilt_demo.util.loadImageFromUrl
import kotlinx.android.synthetic.main.fragment_episode_detail.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class EpisodeDetailFragment : Fragment(R.layout.fragment_episode_detail) {

    private val args: EpisodeDetailFragmentArgs by navArgs()

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val transition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
//        sharedElementEnterTransition = transition
//        sharedElementReturnTransition = transition
//    }
//


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData(args.episodeOnj)
    }

    private fun setData(episodeObj: SeriesModel.Embedded.Episode) {
        tvEpisodeImage.loadImageFromUrl(args.episodeOnj.image.original)
        tvEpisodeName.text = episodeObj.name
        tvEpisodeSeason.text = episodeObj.season.toString()
        tvEpisodeNumber.text = episodeObj.number.toString()
        tvEpisodeMins.text = episodeObj.runtime.toString()
        tvReleasedOn.text = getDate(episodeObj.airdate)
        tvEpisodeSummary.text = episodeObj.summary.replace("<p>","").replace("</p>","")

    }

    private fun getDate(date : String) : String{
        val parser =  SimpleDateFormat("yyyy-MM-dd")
        val formatter = SimpleDateFormat("dd.MMMM.yyyy")
        val formattedDate = formatter.format(parser.parse(date))
        return formattedDate.replace("."," ")
    }

}