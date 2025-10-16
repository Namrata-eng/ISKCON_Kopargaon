package com.iskcon.temple

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class MoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_more, container, false)

        // Setup click listeners for all options
        setupClickListeners(view)

        return view
    }

    private fun setupClickListeners(view: View) {
        // About Us
        view.findViewById<CardView>(R.id.card_about_us).setOnClickListener {
            navigateToAboutUs()
        }

        // Contact Us
        view.findViewById<CardView>(R.id.card_contact_us).setOnClickListener {
            navigateToContactUs()
        }

        // Sign In
        view.findViewById<CardView>(R.id.card_sign_in).setOnClickListener {
            navigateToSignIn()
        }

        // Scriptures
        view.findViewById<CardView>(R.id.card_scriptures).setOnClickListener {
            Toast.makeText(context, "Scriptures feature coming soon! 📖", Toast.LENGTH_SHORT).show()
        }

        // Share App
        view.findViewById<CardView>(R.id.card_share_app).setOnClickListener {
            shareApp()
        }

        // Rate App
        view.findViewById<CardView>(R.id.card_rate_app).setOnClickListener {
            Toast.makeText(context, "Thank you for your support! ⭐", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToAboutUs() {
        val aboutUsFragment = AboutUsFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, aboutUsFragment)
            .addToBackStack("more")
            .commit()
    }

    private fun navigateToContactUs() {
        val contactUsFragment = ContactUsFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, contactUsFragment)
            .addToBackStack("more")
            .commit()
    }

    private fun navigateToSignIn() {
        val signInFragment = SignInFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, signInFragment)
            .addToBackStack("more")
            .commit()
    }

    private fun shareApp() {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "ISKCON Kopergaon App")
            putExtra(
                Intent.EXTRA_TEXT,
                "Check out ISKCON Kopergaon app for divine darshan and temple updates!\n\nHare Krishna! 🙏"
            )
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}