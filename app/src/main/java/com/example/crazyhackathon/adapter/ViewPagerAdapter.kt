package com.example.crazyhackathon.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.crazyhackathon.R

class ViewPagerAdapter(placeList: ArrayList<Int>) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    var item = placeList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder((parent))

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.place.setImageResource(item[position])
    }

    inner class PagerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder
        (LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)){

        val place = itemView.findViewById<ImageView>(R.id.imgList)
    }
}