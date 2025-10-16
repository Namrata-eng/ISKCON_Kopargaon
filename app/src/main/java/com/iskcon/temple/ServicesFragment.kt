package com.iskcon.temple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ServicesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = TextView(context)
        view.text = "Temple Services\n\n💰 Donations\n🎂 Youth Foreum\n📿 Puja Services\n🍽️ Prasadam Orders\n📚 Book Store\n\nMore services coming soon...\n\nHare Krishna! 🙏"
        view.textSize = 16f
        view.setPadding(50, 100, 50, 50)
        return view
    }
}