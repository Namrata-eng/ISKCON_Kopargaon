package com.iskcon.temple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = TextView(context)
        view.text = "Daily Schedule\n\n⏰ Temple Timings:\n\nMangala Aarti: 6:45 AM\nTulasi Puja: 5:00 AM\nSrimad Bhagavatam: 8:00 AM\nRaj Bhog: 12:00 PM\nSandhya Aarti: 7:00 PM\nRest: 8:30 PM\n\n🕉️ Hare Krishna!"
        view.textSize = 16f
        view.setPadding(50, 100, 50, 50)
        return view
    }
}