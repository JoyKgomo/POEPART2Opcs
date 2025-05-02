package com.example.poepart2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.poepart2.Data.AppDatabase
import com.example.poepart2.Data.UserDao
import kotlinx.coroutines.launch

//private lateinit var db: AppDatabase
//private lateinit var userDao: UserDao

class SignUp : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

       // db = AppDatabase.getDatabase(this)
        //userDao = db.UserDao()



        val txtUsername = findViewById<EditText>(R.id.edtUsernameSignUp)
        val txtConfirmPassword = findViewById<EditText>(R.id.edtPasswordSignUp)

        // extracting from the edit text

        val username = txtUsername.text.toString();
        val confirmPassword = txtConfirmPassword.text.toString();


        if (username.isEmpty()){
            txtUsername.error ="Enter Username"
            return
        }

        if (confirmPassword.isEmpty()) {
            txtConfirmPassword.error = "Enter correct password"
            return
        }

        // In an Activity (ideally use ViewModel + coroutine)
        lifecycleScope.launch {
            val db = AppDatabase.getDatabase(applicationContext)
            val user = db.UserDao().getUserByUsername(username)

            if (user != null && user.confirmedpassword == confirmPassword) {
             //   Toast.makeText(this@YourActivity, "Login successful!", Toast.LENGTH_SHORT).show()
                // Navigate to the next screen
            } else {
               // Toast.makeText(this@YourActivity, "Invalid email or password.", Toast.LENGTH_SHORT).show()
            }
        }




    }

}