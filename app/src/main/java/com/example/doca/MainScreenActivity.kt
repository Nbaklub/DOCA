package com.example.doca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
        val menu = findViewById<ImageView>(R.id.Menu)
        menu.setOnClickListener(){
            val intent = Intent(this@MainScreenActivity, MenuActivity::class.java)
            startActivity(intent)
            val database = FirebaseDatabase.getInstance()
            val userRef = database.reference.child("users").child(FirebaseAuth.getInstance().currentUser!!.uid)
            userRef.child("firstName").setValue("John")
            userRef.child("lastName").setValue("Doe")
            userRef.child("location").setValue("Los Angeles, CA")
        }
    }
    public override fun onStart() {
        super.onStart()
        val database = FirebaseDatabase.getInstance()
        val userRef = database.reference.child("users").child(FirebaseAuth.getInstance().currentUser!!.uid)
        userRef.child("firstName").setValue("John")
        userRef.child("lastName").setValue("Doe")
        userRef.child("location").setValue("Los Angeles, CA")

    }

}