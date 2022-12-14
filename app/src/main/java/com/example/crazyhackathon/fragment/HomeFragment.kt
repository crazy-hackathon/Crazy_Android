package com.example.crazyhackathon.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.crazyhackathon.R
import com.example.crazyhackathon.adapter.PlaceRecyclerAdapter
import com.example.crazyhackathon.adapter.ViewPagerAdapter
import com.example.crazyhackathon.data.PlaceData
import com.example.crazyhackathon.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var mDatas = mutableListOf<PlaceData>(
        PlaceData("두류공원", "83타워 및 스포츠 시설이 있는 공원", "fdfsdfsdfdsfds", "20"),
        PlaceData("김광석거리", "김광석거리", "노래도 나오고 옛날 분위기가 나서 추억을 되살리기 좋았습니다", "49"),
        PlaceData( "낙동강 수련원", "학생 수련원", "너무 재밌고 좋았습니다.", "50")
    )
    private val MIN_SCALE = 0.85f
    private val MIN_ALPHA = 0.5f

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPagerSetting()
        initDataRecyclerView()
        addDataRecyclerView()
    }

    private fun initDataRecyclerView() {
        val adapter = PlaceRecyclerAdapter(requireContext())
        adapter.dataList = mDatas
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun selectCategory() {
        binding.btnChild.setOnClickListener {

        }
    }

    private fun addDataRecyclerView() {
        //TODO 서버값
    }

    private fun viewPagerSetting() {
        binding.viewPager.adapter = ViewPagerAdapter(getIdolList(), requireContext()) // 어댑터 생성
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로
        binding.viewPager.setPageTransformer(ZoomOutPageTransformer())
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth)
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        binding.viewPager.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }

        binding.viewPager.offscreenPageLimit = 1 // 몇 개의 페이지를 미리 로드 할 것 인지
        binding.viewPager.adapter = ViewPagerAdapter(getIdolList(), requireContext())
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tap, position ->
            //Some implementation
        }.attach()
    }

    private fun getIdolList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.tree, R.drawable.close, R.drawable.people, R.drawable.open, R.drawable.home)
    }

    inner class ZoomOutPageTransformer : ViewPager2.PageTransformer {
        override fun transformPage(view: View, position: Float) {
            view.apply {
                val pageWidth = width
                val pageHeight = height
                when {
                    position < -1 -> { // [-Infinity,-1)
                        // This page is way off-screen to the left.
                        alpha = 0f
                    }
                    position <= 1 -> { // [-1,1]
                        // Modify the default slide transition to shrink the page as well
                        val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
                        val vertMargin = pageHeight * (1 - scaleFactor) / 2
                        val horzMargin = pageWidth * (1 - scaleFactor) / 2
                        translationX = if (position < 0) {
                            horzMargin - vertMargin / 2
                        } else {
                            horzMargin + vertMargin / 2
                        }

                        // Scale the page down (between MIN_SCALE and 1)
                        scaleX = scaleFactor
                        scaleY = scaleFactor

                        // Fade the page relative to its size.
                        alpha = (MIN_ALPHA +
                                (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
                    }
                    else -> { // (1,+Infinity]
                        // This page is way off-screen to the right.
                        alpha = 0f
                    }
                }
            }
        }
    }

}