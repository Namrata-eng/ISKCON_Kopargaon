package com.iskcon.temple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        setupQuickNavigation(view)

        return view
    }

    private fun setupQuickNavigation(view: View) {
        // Daily Schedule
        view.findViewById<CardView>(R.id.card_schedule)?.setOnClickListener {
            requireActivity().findViewById<CardView>(R.id.nav_schedule_custom)?.performClick()
        }

        // Services
        view.findViewById<CardView>(R.id.card_services)?.setOnClickListener {
            requireActivity().findViewById<CardView>(R.id.nav_services_custom)?.performClick()
        }

        // Gallery
        view.findViewById<CardView>(R.id.card_gallery)?.setOnClickListener {
            val galleryFragment = GalleryFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, galleryFragment)
                .addToBackStack("home")
                .commit()
        }

        // More
        view.findViewById<CardView>(R.id.card_more)?.setOnClickListener {
            requireActivity().findViewById<CardView>(R.id.nav_more_custom)?.performClick()
        }
    }
}
