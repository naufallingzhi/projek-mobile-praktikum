package com.example.naufallingzhi_tia.Home.Pertemuan10

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.naufallingzhi_tia.R
import com.example.naufallingzhi_tia.databinding.ActivityTenthBinding
import com.google.android.material.tabs.TabLayoutMediator

class TenthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTenthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTenthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = "Halaman Pertemuan 9"
            subtitle = "Halaman P9"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }

            val tabsAdapter = TenthTabsAdapter(this)

            binding.viewPager.adapter = tabsAdapter

            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->

                when (position) {
                    0 -> {
                        tab.text = "Tab A"
// Tambah ikon
                        tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
// Badge tanpa angka (hanya titik)
                        val badge = tab.getOrCreateBadge()
                        badge.isVisible = true
                    }
                    1 -> {
                        tab.text = "Tab B"
// Tambah ikon
                        tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
// Badge dengan angka
                        val badge = tab.getOrCreateBadge()
                        badge.isVisible = true
                        badge.number = 5
                    }
                    2 -> {
                        tab.text = "Produk"
// Tambah ikon
                        tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_home)
// Badge dengan angka
                        val badge = tab.getOrCreateBadge()
                        badge.isVisible = true
                    }
                }
            }.attach()
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                android.R.id.home -> {
                    onBackPressedDispatcher.onBackPressed()
                    true
                }

                else -> super.onOptionsItemSelected(item)
            }

        }
    }