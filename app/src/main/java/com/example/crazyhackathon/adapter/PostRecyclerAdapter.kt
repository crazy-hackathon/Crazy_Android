package com.example.crazyhackathon.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crazyhackathon.DetailActivity
import com.example.crazyhackathon.R
import com.example.crazyhackathon.data.PostData
import com.example.crazyhackathon.databinding.PostListBinding

class PostRecyclerAdapter (val context: Context):
    RecyclerView.Adapter<PostRecyclerAdapter.MyViewHolder>() {
    var dataList = mutableListOf<PostData>()

    inner class MyViewHolder(private val binding: PostListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PostData) {
            binding.imgMain.setImageResource(R.drawable.tree)
            binding.tvName.text = data.name
            binding.tvTitle.text = data.title
            binding.tvLocation.text = data.location
            binding.tvHeart.text = data.heart.toString() + "명이 좋아합니다"
            binding.tvClock.text = data.time.toString()
            binding.postLayout.setOnClickListener {
                Intent(context, DetailActivity::class.java).apply {
                    putExtra("title", data.title)
                    putExtra("head", data.time)
                    putExtra("body", data.location)
                    putExtra("heart", data.heart)
                }.run { context.startActivity(this) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            PostListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

}