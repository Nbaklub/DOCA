package com.example.doca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = Firebase.auth
        val regsite = findViewById<TextView>(R.id.textView)
        val login = findViewById<Button>(R.id.register)
        login.setOnClickListener(){
            val emailnotext = findViewById<EditText>(R.id.editTextTextEmailAddress2)
            val email = emailnotext.text.toString()
            val passwordnotext = findViewById<EditText>(R.id.editTextTextPassword)
            val password = passwordnotext.text.toString()
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this@MainActivity, MainScreenActivity::class.java)
                        startActivity(intent)
                    }
                }
        }
        regsite.setOnClickListener(){
            val intent = Intent(this@MainActivity, Registration::class.java)
            startActivity(intent)
        }
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intent = Intent(this@MainActivity, MainScreenActivity::class.java)
            startActivity(intent)
        }
    }
}