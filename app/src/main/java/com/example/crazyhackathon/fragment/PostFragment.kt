package com.example.crazyhackathon.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crazyhackathon.R
import com.example.crazyhackathon.adapter.PlaceRecyclerAdapter
import com.example.crazyhackathon.adapter.PostRecyclerAdapter
import com.example.crazyhackathon.data.PostData
import com.example.crazyhackathon.databinding.FragmentPostBinding

class PostFragment : Fragment() {

    private lateinit var binding: FragmentPostBinding
    private var mDatas = mutableListOf<PostData>(
        PostData("두류공원 썰 푼다", "고용빈", "대구 두류공원", 20, 20221012)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDataRecyclerView()
        addDataRecyclerView()
    }

    private fun initDataRecyclerView() {
        val adapter = PostRecyclerAdapter(requireContext())
        adapter.dataList = mDatas
        binding.recyclerPost.adapter = adapter
        binding.recyclerPost.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun addDataRecyclerView() {
        //TODO 서버값
    }

}