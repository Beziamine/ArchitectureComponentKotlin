package com.example.architecturecomponentkotlin.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.architecturecomponentkotlin.R
import com.example.architecturecomponentkotlin.model.Model
import kotlinx.android.synthetic.main.model_item.view.*

class ListAdapter(
    private val context: Context?,
    private val list: List<Model>
): RecyclerView.Adapter<ListAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Model) {


            itemView.app_name.text = item.name
            itemView.app_description.text = item.short_desc


            Glide.with(itemView.context)
                .load(item.app_icon_url)
                .placeholder(android.R.color.transparent)
                .centerCrop()
                .into(itemView.app_icon)


            itemView.setOnClickListener {
                var bundle = bundleOf("id" to item.app_id)
                it.findNavController()
                    .navigate(R.id.action_navigation_home_to_navigation_detail, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bindView(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.model_item, parent, false)
        return ViewHolder(itemView)
    }

}