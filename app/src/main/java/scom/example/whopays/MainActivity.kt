package scom.example.whopays

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Hide Title in Action bar
        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false)
        }


        // Button event handlers
        val btn_register = findViewById(R.id.button_register2) as Button
        val btn_login = findViewById(R.id.button_login) as Button

        btn_register.setOnClickListener {
            val showRegisterScreen = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(showRegisterScreen)
            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
        btn_login.setOnClickListener {
            val showHomeScreen = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(showHomeScreen)
        }


    }


}