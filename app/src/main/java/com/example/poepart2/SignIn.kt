package com.example.poepart2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.poepart2.Data.AppDatabase
import com.example.poepart2.Data.User
import com.example.poepart2.Data.UserDao
import kotlinx.coroutines.launch

class SignIn : AppCompatActivity() {

    private lateinit var db: AppDatabase
    private lateinit var userDao: UserDao

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        db = AppDatabase.getDatabase(this)
        userDao = db.UserDao()

        val txtName = findViewById<EditText>(R.id.edtName)
        val txtEmail = findViewById<EditText>(R.id.edtEmail)
        val txtNumber = findViewById<EditText>(R.id.edtPhoneNumber)
        val txtUsername = findViewById<EditText>(R.id.edtUsername)
        val txtPassword = findViewById<EditText>(R.id.edtPassword)
        val txtConfirmPassword = findViewById<EditText>(R.id.edtConfirmPassword)

        // extracting from the edit text
        val NameandSurname = txtName.text.toString();
        val email = txtEmail.text.toString();
        val phoneNumber = txtNumber.text.toString();
        val username = txtUsername.text.toString();
        val password = txtPassword.text.toString();
        val confirmPassword = txtConfirmPassword.text.toString();

        val goToSignUp = findViewById<Button>(R.id.btnsignup)
        goToSignUp.setOnClickListener {
            if (NameandSurname.isEmpty()) {
                txtName.error = "Enter Name and Surname"
            }

            if (email.isEmpty()) {
                txtEmail.error = "Enter Email"
            }

            if (phoneNumber.isEmpty()) {
                txtNumber.error = "Enter Phone Number"
            }

            if (username.isEmpty()) {
                txtUsername.error = "Enter Username"
            }


            if (password.isEmpty()) {
                txtPassword.error = "Enter password"
            }

            if (confirmPassword != password) {
                txtConfirmPassword.error = "Enter correct password"

            }

        if (username.isNotBlank() && confirmPassword.isNotBlank()){
            lifecycleScope.launch {
                userDao.insert(User(username = username, confirmedpassword = confirmPassword  ))
            }
        }
            val intent = Intent( this,SignUp::class.java)
            startActivity(intent)

    }
        val goToMainPage = findViewById<Button>(R.id.btnBack)
        goToMainPage?.setOnClickListener{
            val intent = Intent( this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}