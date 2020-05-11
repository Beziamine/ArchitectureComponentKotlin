package com.example.architecturecomponentkotlin.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.architecturecomponentkotlin.R
import com.example.architecturecomponentkotlin.model.App_images
import com.example.architecturecomponentkotlin.model.Model
import kotlinx.android.synthetic.main.model_app_images.view.*
import kotlinx.android.synthetic.main.model_item.view.*

class ListDetailAdapter(
    private val context: Context?,
    private val list: List<App_images>
): RecyclerView.Adapter<ListDetailAdapter.DetailViewHolder>() {


    class DetailViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: App_images) {

            Glide.with(itemView.context)
                .load(item.image_url)
                .placeholder(android.R.color.transparent)
                .centerCrop()
                .into(itemView.image_app)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val detail = list[position]
        holder.bindView(detail)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.model_app_images, parent, false)
        return DetailViewHolder(itemView)
    }

}