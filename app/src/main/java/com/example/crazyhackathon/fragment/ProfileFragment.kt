package com.example.crazyhackathon.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crazyhackathon.R
import com.example.crazyhackathon.adapter.PostRecyclerAdapter
import com.example.crazyhackathon.data.PostData
import com.example.crazyhackathon.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private var mDatas = mutableListOf<PostData>(
        PostData("두류공원 썰 풀어요", "이름", "대구 두류공원", 20, 20221012),
        PostData("그 두류공원 갔다 왔습니다", "이름", "대구 두류공원", 100, 20221024)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
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
        binding.myPostRecycler.adapter = adapter
        binding.myPostRecycler.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun addDataRecyclerView() {

    }


}