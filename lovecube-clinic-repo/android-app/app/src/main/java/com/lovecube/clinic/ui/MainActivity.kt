package com.lovecube.clinic.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lovecube.clinic.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_trading -> { startActivity(Intent(this, TradingAIActivity::class.java)); true }
                R.id.nav_car_stats -> { startActivity(Intent(this, CarStatsActivity::class.java)); true }
                R.id.nav_social -> { startActivity(Intent(this, SocialMediaActivity::class.java)); true }
                R.id.nav_security -> { startActivity(Intent(this, HomeSecurityActivity::class.java)); true }
                R.id.nav_news -> { startActivity(Intent(this, NewsFeedActivity::class.java)); true }
                R.id.nav_genesis -> { startActivity(Intent(this, GenesisActivity::class.java)); true }
                else -> false
            }
        }
    }
}