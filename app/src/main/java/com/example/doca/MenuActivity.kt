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
import com.google.firebase.ktx.Firebase

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val user = FirebaseAuth.getInstance().currentUser
        val email = user?.email
        val usertext = findViewById<TextView>(R.id.textView3)
        usertext.setText("$email")
        val logout = findViewById<ImageView>(R.id.logout)
        logout.setOnClickListener(){
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this@MenuActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }
}