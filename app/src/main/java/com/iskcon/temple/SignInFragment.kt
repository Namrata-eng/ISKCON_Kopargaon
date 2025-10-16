package com.iskcon.temple
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        setupSignIn(view)

        return view
    }

    private fun setupSignIn(view: View) {
        val etEmail = view.findViewById<EditText>(R.id.et_email)
        val etPassword = view.findViewById<EditText>(R.id.et_password)
        val btnSignIn = view.findViewById<Button>(R.id.btn_sign_in)
        val tvRegister = view.findViewById<TextView>(R.id.tv_register)
        val tvForgotPassword = view.findViewById<TextView>(R.id.tv_forgot_password)

        // Sign In Button
        btnSignIn.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (validateInput(email, password)) {
                // TODO: Implement actual authentication
                Toast.makeText(
                    context,
                    "Sign In feature coming soon!\n\nEmail: $email",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        // Register Link
        tvRegister.setOnClickListener {
            navigateToRegister()
        }

        // Forgot Password Link
        tvForgotPassword.setOnClickListener {
            Toast.makeText(
                context,
                "Password recovery will be sent to your email",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        if (email.isEmpty()) {
            Toast.makeText(context, "Please enter email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(context, "Please enter valid email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.isEmpty()) {
            Toast.makeText(context, "Please enter password", Toast.LENGTH_SHORT).show()
            return false
        }

        if (password.length < 6) {
            Toast.makeText(context, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun navigateToRegister() {
        val registerFragment = RegisterFragment()
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, registerFragment)
            .addToBackStack("signin")
            .commit()
    }
}