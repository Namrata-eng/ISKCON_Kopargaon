package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class YouthForum : AppCompatActivity() {

    // These are not needed as they are non-interactive
    // lateinit var imageButton: ImageButton
    // lateinit var imageButton2: ImageButton
    // lateinit var imageButton3: ImageButton
    // lateinit var imageButton4: ImageButton

    // These are the buttons for the Quick Navigation
    lateinit var lecturesButton: ImageButton
    lateinit var imagesButton: ImageButton
    lateinit var campsButton: ImageButton
    lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_youthforum)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        lecturesButton = findViewById(R.id.lecturesButton)
        imagesButton = findViewById(R.id.imagesButton)
        campsButton = findViewById(R.id.campsButton)
        registerButton = findViewById(R.id.registerButton)


        lecturesButton.setOnClickListener {
            val intent = Intent(this, Screen5::class.java)
            startActivity(intent)
        }

        imagesButton.setOnClickListener {

            val intent = Intent(this, Screen6::class.java)
            startActivity(intent)
        }

        campsButton.setOnClickListener {
            val intent = Intent(this, Screen3::class.java)
            startActivity(intent)
        }

        registerButton.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }
    }
}
