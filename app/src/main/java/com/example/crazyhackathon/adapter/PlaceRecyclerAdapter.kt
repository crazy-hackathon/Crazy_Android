package com.example.crazyhackathon.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.crazyhackathon.DetailActivity
import com.example.crazyhackathon.data.PlaceData
import com.example.crazyhackathon.databinding.OfferListBinding

class PlaceRecyclerAdapter(val context: Context):
    RecyclerView.Adapter<PlaceRecyclerAdapter.MyViewHolder>() {
    var dataList = mutableListOf<PlaceData>()

    inner class MyViewHolder(private val binding: OfferListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PlaceData) {
            binding.title.text = data.title
            binding.imgList.setOnClickListener {
                Intent(context, DetailActivity::class.java).apply {
                    putExtra("title", data.title)
                    putExtra("head", data.head)
                    putExtra("body", data.body)
                    putExtra("heart", data.heart)
                }.run { context.startActivity(this) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            OfferListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

}