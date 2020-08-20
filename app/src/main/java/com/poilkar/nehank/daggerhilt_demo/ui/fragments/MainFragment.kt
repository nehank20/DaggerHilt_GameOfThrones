package com.poilkar.nehank.daggerhilt_demo.ui.fragments

import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.poilkar.nehank.daggerhilt_demo.R
import com.poilkar.nehank.daggerhilt_demo.adapter.SeriesAdapter
import com.poilkar.nehank.daggerhilt_demo.model.ResultData
import com.poilkar.nehank.daggerhilt_demo.model.SeriesModel
import com.poilkar.nehank.daggerhilt_demo.ui.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val mainActivityViewModel by viewModels<MainActivityViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var adapter = SeriesAdapter()
        recyclerView.adapter = adapter

        recyclerView.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        mainActivityViewModel.getRepositoryList().observe(viewLifecycleOwner, Observer {
            when (it) {
                is ResultData.Loading -> {

                }
                is ResultData.Success -> {

                    val seriesData = it.data
                    adapter.differ.submitList(seriesData?.embedded?.episodes?.toList())
                    adapter.listener = object : SeriesAdapter.ItemClickListener {
                        override fun onItemClickListener(
                            item: SeriesModel.Embedded.Episode,
                            imageView: ImageView
                        ) {
                            val action = MainFragmentDirections.actionMainFragmentToEpisodeDetailFragment(item)
                            findNavController().navigate(action)
                        }

                    }
                }
                is ResultData.Failure -> {

                }
                is ResultData.Exception -> {

                }
            }
        })

    }
}