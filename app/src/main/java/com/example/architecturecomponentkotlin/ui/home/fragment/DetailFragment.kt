package com.example.architecturecomponentkotlin.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.architecturecomponentkotlin.R
import com.example.architecturecomponentkotlin.model.Model
import com.example.architecturecomponentkotlin.model.ModelDetail
import com.example.architecturecomponentkotlin.ui.home.adapter.ListDetailAdapter
import com.example.architecturecomponentkotlin.ui.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.detail_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment(){

    private val homeViewModel : HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = checkNotNull(arguments?.getString("id"))

        val progressBar = progressBarDetail
        val recyclerView = app_images_recycler
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL ,false)
        recyclerView.layoutManager = layoutManager

        homeViewModel.getDetailById(id)

        homeViewModel.getModelDetailLiveData.observe(viewLifecycleOwner, Observer {
            val detail: ModelDetail = it

            detail_app_name.setText(detail.name)
            detail_app_ranking.setText(detail.average_ratings.toString())
            detail_app_long_description.setText(detail.long_desc)

            recyclerView.adapter = ListDetailAdapter(view.context,detail.app_images)

            progressBar.visibility = View.GONE
        })

    }
}