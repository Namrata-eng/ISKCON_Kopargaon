package com.iskcon.temple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class DarshanFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_darshan, container, false)

        // Setup View Gallery button click listener
        setupGalleryButton(view)

        return view
    }

    private fun setupGalleryButton(view: View) {
        val btnViewGallery = view.findViewById<CardView>(R.id.btn_view_gallery)

        btnViewGallery.setOnClickListener {
            // Navigate to Gallery Fragment
            navigateToGallery()
        }
    }

    private fun navigateToGallery() {
        // Create Gallery Fragment instance
        val galleryFragment = GalleryFragment()

        // Navigate to Gallery
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, galleryFragment)
            .addToBackStack("darshan") // This allows back navigation
            .commit()

        // Show a toast for confirmation
        Toast.makeText(
            requireContext(),
            "Opening Gallery 📸",
            Toast.LENGTH_SHORT
        ).show()
    }
}