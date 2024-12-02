package com.example.fsltalk

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

            val usernameInput = findViewById<EditText>(R.id.usernameInput)
            val passwordInput = findViewById<EditText>(R.id.passwordInput)
            val keepMeLoggedIn = findViewById<CheckBox>(R.id.keepMeLoggedIn)
            val loginButton = findViewById<Button>(R.id.loginButton)
            val facebookLogin = findViewById<ImageButton>(R.id.facebookLogin)
            val googleLogin = findViewById<ImageButton>(R.id.googleLogin)
            val twitterLogin = findViewById<ImageButton>(R.id.twitterLogin)
            val linkToSignUp = findViewById<TextView>(R.id.linkToSignUp)

            loginButton.setOnClickListener {
                val username = usernameInput.text.toString()
                val password = passwordInput.text.toString()

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
                } else {

                    Toast.makeText(this, "Logged in as $username", Toast.LENGTH_SHORT).show()
                }
            }

            facebookLogin.setOnClickListener {
                Toast.makeText(this, "Facebook Login Clicked", Toast.LENGTH_SHORT).show()
            }

            googleLogin.setOnClickListener {
                Toast.makeText(this, "Google Login Clicked", Toast.LENGTH_SHORT).show()
            }

            twitterLogin.setOnClickListener {
                Toast.makeText(this, "Twitter Login Clicked", Toast.LENGTH_SHORT).show()
            }

            linkToSignUp.setOnClickListener {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
