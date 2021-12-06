package scom.example.whopays

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBar

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Hide Title in Action bar
        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false)
        }


        // Button event handlers
        val btn_logout = findViewById(R.id.button_logout) as Button

        btn_logout.setOnClickListener {
            val showRegisterScreen = Intent(this@HomeActivity, MainActivity::class.java)
            startActivity(showRegisterScreen)
            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }


    }


}