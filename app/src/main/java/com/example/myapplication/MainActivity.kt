import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

//package com.example.myapplication
//
//import android.content.Intent
//import android.os.Bundle
//import android.os.PersistableBundle
//import android.util.Log
//import android.widget.Button
//import android.widget.EditText
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
////class MainActivity : AppCompatActivity() {
//
////    lateinit var button : Button
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////        enableEdgeToEdge()
////        setContentView(R.layout.activity_main)
////        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
////            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
////            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
////            insets
////        }
////        // it is object of the button
////        button = findViewById<Button>(R.id.mybutton) // each resource entry is in the R class
////        // val button = findViewById<Button>(R.id.mybutton)
////        // val button : Button findViewById (R.id.mybutton)
////        // for text -> val mytextview : Textview findViewById (R.id.mytextview)
////
////        button.setOnClickListener {
////            val myIntent = Intent(this@MainActivity, Screen2::class.java)
////            startActivity(myIntent)
////        }
////    }
////    // When we use log check in logcat
////    // control+o to directly search & use the life-cycle directly
////    override fun onStart() {
////        super.onStart()
////        Log.i("Main-Activity", "onStart") //Log.i = log information
////                                                      // Log.d = log debug - which donot have info
////                                                      // Log.e = log error - to show error
////    }
////
////    override fun onResume() {
////        super.onResume()
////    }
////    override fun onPause() {
////        super.onPause()
////    }
////    override fun onStop() {
////        super.onStop()
////    }
////}
//
//
//// Class-2 :- Screen 1
//class MainActivity : AppCompatActivity() {
//
//    lateinit var getUsername : EditText
//    lateinit var getPassword : EditText
//    lateinit var clickLogin : Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//
//        // Shared screen syntax
//
//        //  val myPreference = applicationContext.getSharedPreference("MainActivity",MODE_PRIVATE) // can be public
//        // val editor = myPreference.edit()
//
//        // continue below
//
//        getUsername = findViewById(R.id.logintext)
//        getPassword = findViewById(R.id.password)
//        clickLogin = findViewById(R.id.button_login_action)
//
//        val username = getUsername
//        val password = getPassword
//        clickLogin.setOnClickListener {
//            if(username.text.toString() == "sanjivani" && password.text.toString() == "admin"){
//                // Login
//                val myIntent = Intent(this@MainActivity, Home_Screen::class.java)
//                startActivity(myIntent)
//                finish()
//
//                // continue
//                //.equals(myPreference.getString("username","")
//            }
//            else{
//                //error
//            }
//        }
//    }
//}
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen1)
        val listmutable = mutableListOf<String>("abc","def")

    }
}

























