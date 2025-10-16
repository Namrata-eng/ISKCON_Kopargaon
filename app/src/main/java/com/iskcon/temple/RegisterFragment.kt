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

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        setupRegister(view)

        return view
    }

    private fun setupRegister(view: View) {
        val etName = view.findViewById<EditText>(R.id.et_name)
        val etEmail = view.findViewById<EditText>(R.id.et_email)
        val etPhone = view.findViewById<EditText>(R.id.et_phone)
        val etPassword = view.findViewById<EditText>(R.id.et_password)
        val etConfirmPassword = view.findViewById<EditText>(R.id.et_confirm_password)
        val btnRegister = view.findViewById<Button>(R.id.btn_register)
        val tvSignIn = view.findViewById<TextView>(R.id.tv_sign_in)

        // Register Button
        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            if (validateInput(name, email, phone, password, confirmPassword)) {
                // TODO: Implement actual registration
                Toast.makeText(
                    context,
                    "Registration feature coming soon!\n\nName: $name\nEmail: $email",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        // Sign In Link
        tvSignIn.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    private fun validateInput(
        name: String,
        email: String,
        phone: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        if (name.isEmpty()) {
            Toast.makeText(context, "Please enter your name", Toast.LENGTH_SHORT).show()
            return false
        }

        if (email.isEmpty()) {
            Toast.makeText(context, "Please enter email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(context, "Please enter valid email", Toast.LENGTH_SHORT).show()
            return false
        }

        if (phone.isEmpty()) {
            Toast.makeText(context, "Please enter phone number", Toast.LENGTH_SHORT).show()
            return false
        }

        if (phone.length != 10) {
            Toast.makeText(context, "Please enter valid 10-digit phone number", Toast.LENGTH_SHORT).show()
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

        if (password != confirmPassword) {
            Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}