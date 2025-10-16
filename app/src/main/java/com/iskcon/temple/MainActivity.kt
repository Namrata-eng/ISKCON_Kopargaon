package com.iskcon.temple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Set default fragment (Home)
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        // Handle bottom navigation clicks
        bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_home -> {
                    // Clear back stack when going to home
                    clearBackStack()
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_darshan -> {
                    clearBackStack()
                    loadFragment(DarshanFragment())
                    true
                }
                R.id.nav_schedule -> {
                    clearBackStack()
                    loadFragment(ScheduleFragment())
                    true
                }
                R.id.nav_services -> {
                    clearBackStack()
                    loadFragment(ServicesFragment())
                    true
                }
                R.id.nav_more -> {
                    clearBackStack()
                    loadFragment(MoreFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun clearBackStack() {
        // Clear all fragments from back stack
        for (i in 0 until supportFragmentManager.backStackEntryCount) {
            supportFragmentManager.popBackStack()
        }
    }

    // Handle back button press
    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            // If there are fragments in back stack, pop them
            supportFragmentManager.popBackStack()
        } else {
            // Otherwise, exit the app
            super.onBackPressed()
        }
    }
}