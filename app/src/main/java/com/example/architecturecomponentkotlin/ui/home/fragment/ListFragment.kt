package com.example.architecturecomponentkotlin.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.architecturecomponentkotlin.R
import com.example.architecturecomponentkotlin.model.Model
import com.example.architecturecomponentkotlin.ui.home.adapter.ListAdapter
import com.example.architecturecomponentkotlin.ui.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

class ListFragment : Fragment(){

    private val homeViewModel : HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressBar = progressBar
        val recyclerView = recyclerView
        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        homeViewModel.getListModel().observe(viewLifecycleOwner, Observer {
            val models: List<Model> = it
            recyclerView.adapter = ListAdapter(view.context,models)
            if (models.isNotEmpty())
                progressBar.visibility = View.GONE
        })

    }
}