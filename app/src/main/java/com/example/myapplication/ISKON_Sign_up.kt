package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class ISKON_Sign_up : AppCompatActivity() {

//    lateinit var signup_getUsername : EditText
    lateinit var signup_getemail : EditText
    lateinit var signup_getPassword : EditText
//    lateinit var signup_getconfirmPassword : EditText
    lateinit var signup_clickSignup : Button
    lateinit var signup_clickSign_in: Button
    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_iskon_sign_up)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
              val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
              v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
              insets
        }
//    signup_getUsername = findViewById(R.id.devotee_signup_username)
    signup_getemail = findViewById(R.id.devotee_signup_email)
    signup_getPassword = findViewById(R.id.devotee_signup_password)
//    signup_getconfirmPassword = findViewById(R.id.devotee_signup_confirm_password)
    signup_clickSignup = findViewById<Button>(R.id.devotee_signup)
    signup_clickSign_in = findViewById<Button>(R.id.devotee_Signin_button)

        auth = FirebaseAuth.getInstance()

        signup_clickSignup.setOnClickListener {
            val email = signup_getemail.text.toString().trim()
            val password = signup_getPassword.text.toString().trim()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Enter email & password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            registerUser(email, password)
        }

        signup_clickSign_in.setOnClickListener {
            // Show Snackbar when the button is clicked
            Snackbar.make(it, "Sign In button clicked!", Snackbar.LENGTH_SHORT).show()

            // Navigate to the Sign In screen
            val gotosignin = Intent(this, ISKON_Sign_in::class.java)
            startActivity(gotosignin)
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // registration succeeded
                    Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show()
                    // navigate to login or main screen
                    startActivity(Intent(this, ISKON_Sign_in::class.java))
                    finish()
                } else {
                    // failed
                    Toast.makeText(this, "Sign up failed: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }

//            val myPreference = applicationContext.getSharedPreferences("myPref", MODE_PRIVATE)
//            val editor = myPreference.edit()
//
//            // Store the data in Preference
//            signup_clickSignup.setOnClickListener {
//                editor.putString("username",signup_getUsername.text.toString())
//                editor.putString("email",signup_getemail.text.toString())
//                editor.putString("password",signup_getPassword.text.toString())
//                editor.putString("confirm_password",signup_getconfirmPassword.text.toString())
//                editor.apply()
//
//                // Context + Message + Duration + show()
//                Toast.makeText(this,"Data Saved", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, ISKON_Sign_in::class.java)
//                startActivity(intent)
//            }



    }
}