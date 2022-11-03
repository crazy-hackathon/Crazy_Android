package com.example.crazyhackathon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.crazyhackathon.databinding.ActivityMainBinding
import com.example.crazyhackathon.fragment.HomeFragment
import com.example.crazyhackathon.fragment.PostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        supportFragmentManager.beginTransaction().replace(binding.bodyLayout.id, HomeFragment()).commit()
        binding.bottomNavigation.selectedItemId = R.id.page_home
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.page_search -> {
                supportFragmentManager.beginTransaction().replace(binding.bodyLayout.id, PostFragment()).commit()
            }
            R.id.page_home -> {
                supportFragmentManager.beginTransaction().replace(binding.bodyLayout.id, HomeFragment()).commit()
            }
            R.id.page_my -> {

            }
        }
        return true
    }
}