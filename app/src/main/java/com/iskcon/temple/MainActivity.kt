package com.iskcon.temple

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private var currentSelectedTab = R.id.nav_home_custom

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set default fragment (Home)
        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }

        // Setup custom bottom navigation
        setupCustomBottomNavigation()
    }

    private fun setupCustomBottomNavigation() {
        val navHome = findViewById<LinearLayout>(R.id.nav_home_custom)
        val navDarshan = findViewById<LinearLayout>(R.id.nav_darshan_custom)
        val navSchedule = findViewById<LinearLayout>(R.id.nav_schedule_custom)
        val navServices = findViewById<LinearLayout>(R.id.nav_services_custom)
        val navMore = findViewById<LinearLayout>(R.id.nav_more_custom)

        // Home
        navHome.setOnClickListener {
            selectTab(R.id.nav_home_custom)
            clearBackStack()
            loadFragment(HomeFragment())
        }

        // Darshan
        navDarshan.setOnClickListener {
            selectTab(R.id.nav_darshan_custom)
            clearBackStack()
            loadFragment(DarshanFragment())
        }

        // Schedule
        navSchedule.setOnClickListener {
            selectTab(R.id.nav_schedule_custom)
            clearBackStack()
            loadFragment(ScheduleFragment())
        }

        // Services
        navServices.setOnClickListener {
            selectTab(R.id.nav_services_custom)
            clearBackStack()
            loadFragment(ServicesFragment())
        }

        // More
        navMore.setOnClickListener {
            selectTab(R.id.nav_more_custom)
            clearBackStack()
            loadFragment(MoreFragment())
        }

        // Set initial selection
        selectTab(R.id.nav_home_custom)
    }

    private fun selectTab(tabId: Int) {
        // Reset all tabs to default color
        updateTabColor(R.id.nav_home_custom, false)
        updateTabColor(R.id.nav_darshan_custom, false)
        updateTabColor(R.id.nav_schedule_custom, false)
        updateTabColor(R.id.nav_services_custom, false)
        updateTabColor(R.id.nav_more_custom, false)

        // Highlight selected tab
        updateTabColor(tabId, true)
        currentSelectedTab = tabId
    }

    private fun updateTabColor(tabId: Int, isSelected: Boolean) {
        val tab = findViewById<LinearLayout>(tabId)
        val textView = when (tabId) {
            R.id.nav_home_custom -> findViewById<TextView>(R.id.text_home)
            R.id.nav_darshan_custom -> findViewById<TextView>(R.id.text_darshan)
            R.id.nav_schedule_custom -> findViewById<TextView>(R.id.text_schedule)
            R.id.nav_services_custom -> findViewById<TextView>(R.id.text_services)
            R.id.nav_more_custom -> findViewById<TextView>(R.id.text_more)
            else -> null
        }

        if (isSelected) {
            textView?.setTextColor(ContextCompat.getColor(this, R.color.bhagwa_saffron))
            textView?.typeface = android.graphics.Typeface.DEFAULT_BOLD
        } else {
            textView?.setTextColor(ContextCompat.getColor(this, R.color.gray_text))
            textView?.typeface = android.graphics.Typeface.DEFAULT
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun clearBackStack() {
        for (i in 0 until supportFragmentManager.backStackEntryCount) {
            supportFragmentManager.popBackStack()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}