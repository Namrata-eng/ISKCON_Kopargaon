package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class ISKON_Sign_in : AppCompatActivity() {
    lateinit var getUsername : EditText
    lateinit var getPassword : EditText
    lateinit var clickLogin : Button
    lateinit var clickSign_up: Button

    lateinit var auth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_iskon_sign_in)

//        val myPreference = applicationContext.getSharedPreferences("myPref", MODE_PRIVATE)

        getUsername = findViewById(R.id.devotee_username)
        getPassword = findViewById(R.id.devotee_password)
        clickLogin = findViewById<Button>(R.id.devotee_login)
        clickSign_up = findViewById<Button>(R.id.devotee_signup_button)

        auth = FirebaseAuth.getInstance()

        clickLogin.setOnClickListener {
            val email = getUsername.text.toString().trim()
            val password = getPassword.text.toString().trim()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Enter credentials", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            loginUser(email, password)
        }

        clickSign_up.setOnClickListener {
            val gotosignup = Intent(this, ISKON_Sign_up::class.java)
            startActivity(gotosignup)
        }
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                    // go to main/home screen
                    startActivity(Intent(this, Home_Screen::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Login failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }

//        clickLogin.setOnClickListener {
//            if (getUsername.text.toString()
//                .equals(myPreference.getString("username", "")) && getPassword.text.toString() .equals(myPreference.getString("password", "")) ) {
//                val intent = Intent(this, Home_Screen   ::class.java)
//                startActivity(intent)
//                finish()
//            } else {
//                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show() }
//        }

    }
}