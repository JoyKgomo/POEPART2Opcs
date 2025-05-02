package com.example.poepart2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.poepart2.Data.AppDatabase
import com.example.poepart2.Data.UserDao
import kotlinx.coroutines.launch

private lateinit var db: AppDatabase
private lateinit var userDao: UserDao

class SignUp : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

         db = AppDatabase.getDatabase(this)
        userDao = db.UserDao()


        val txtUsername = findViewById<EditText>(R.id.edtUsernameSignUp)
        val txtConfirmPassword = findViewById<EditText>(R.id.edtPasswordSignUp)

        // extracting from the edit text
        val username = txtUsername.text.toString()
        val confirmPassword = txtConfirmPassword.text.toString()


        val verify = findViewById<Button>(R.id.btnSignInOfficial)
        verify.setOnClickListener {

            if (username.isEmpty()) {
                txtUsername.error = "Enter Username"
                return@setOnClickListener
            }

            if (confirmPassword.isEmpty()) {
                txtConfirmPassword.error = "Enter correct password"
                return@setOnClickListener
            }

            // In an Activity (ideally use ViewModel + coroutine)
            lifecycleScope.launch {
                val db = AppDatabase.getDatabase(applicationContext)
                val user = db.UserDao().getUserByUsername(username)

                if (user != null && user.confirmedpassword == confirmPassword) {
                    Toast.makeText(this@SignUp, "Login successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SignUp, "Invalid email or password.", Toast.LENGTH_SHORT)
                        .show()
                }

            }
            val intent = Intent(this, LandingPage::class.java)
            startActivity(intent)
        }
        val goToMainPage = findViewById<Button>(R.id.btnReturn)
        goToMainPage?.setOnClickListener{
            val intent = Intent( this,MainActivity::class.java)
            startActivity(intent)
        }
    }



    }

