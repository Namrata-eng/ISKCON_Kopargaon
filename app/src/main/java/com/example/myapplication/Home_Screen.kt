package com.example.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

//class Screen2 : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_screen2)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}

// Class-2 :- Screen 2
class Home_Screen : AppCompatActivity() {
    lateinit var listview: ListView
    lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen2)
        
        listview = findViewById<ListView>(R.id.list)
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        
        var templist = listOf<String>("Chanting", "Preching","Cooking")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, templist)
        listview.adapter = adapter

        // Optional: handle item clicks
        listview.setOnItemClickListener { _, _, i, _ -> //this take assigned number val by taking from the list
            val selectedItem = templist[i]
            Toast.makeText(this, "item", Toast.LENGTH_SHORT).show()
        }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean { //
//        when(item.itemId)
//        {
//            R.id.send ->{
//                Toast.makeText(this, "Call Button clicked", Toast.LENGTH_SHORT).show()
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean { //
//        when(item.itemId)
//        {
//            R.id.logout->{
//                val alertdialog = AlertDialog.Builder(this)
//                alertdialog.setTitle("Logout")
//                alertdialog.setMessage("Are you sure you want to logout ?")
//                alertdialog.setPositiveButton("Yes"){ dialog, which -> finish()
//                }
//                alertdialog.setNegativeButton("No"){
//                    dialog, which -> dialog.dismiss()
//                }
//                alertdialog.show()
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean { //
        when(item.itemId)
        {
            R.id.logout->{
                
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.servicesmenu,menu) // xml menu file name
        return super.onCreateOptionsMenu(menu)
    }
}