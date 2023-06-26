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

class Registration : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val login = findViewById<TextView>(R.id.textView)
        login.setOnClickListener(){
            val intent = Intent(this@Registration, MainActivity::class.java)
            startActivity(intent)
        }
        val registrationbutton = findViewById<Button>(R.id.register)
        registrationbutton.setOnClickListener(){
            val emailnotext = findViewById<EditText>(R.id.editTextTextEmailAddress2)
            val email = emailnotext.text.toString()
            val passwordnotext = findViewById<EditText>(R.id.editTextTextPassword)
            val password = passwordnotext.text.toString()
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this@Registration, MainScreenActivity::class.java)
                        startActivity(intent)
                    }
                }
        }
    }
}