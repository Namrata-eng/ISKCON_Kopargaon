package com.iskcon.temple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        setupQuickAccessCards(view)

        return view
    }

    private fun setupQuickAccessCards(view: View) {
        // Schedule Card
        view.findViewById<CardView>(R.id.card_schedule).setOnClickListener {
            navigateToSchedule()
        }

        // Services Card
        view.findViewById<CardView>(R.id.card_services).setOnClickListener {
            navigateToServices()
        }

        // Gallery Card
        view.findViewById<CardView>(R.id.card_gallery).setOnClickListener {
            navigateToGallery()
        }

        // More Card
        view.findViewById<CardView>(R.id.card_more).setOnClickListener {
            navigateToMore()
        }
    }

    private fun navigateToSchedule() {
        // Navigate to Schedule tab using bottom navigation
        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_schedule
    }

    private fun navigateToServices() {
        // Navigate to Services tab using bottom navigation
        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_services
    }

    private fun navigateToGallery() {
        // Navigate to Gallery fragment
        val galleryFragment = GalleryFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, galleryFragment)
            .addToBackStack("home")
            .commit()
    }

    private fun navigateToMore() {
        // Navigate to More tab using bottom navigation
        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.selectedItemId = R.id.nav_more
    }
}
