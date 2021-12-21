package scom.example.whopays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import scom.example.whopays.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val accountNavController = this.findNavController(R.id.mainNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, accountNavController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val accountNavController = this.findNavController(R.id.mainNavHostFragment)
        return accountNavController.navigateUp()
    }
}

/* OLD HOME ACTIVITY

package scom.example.whopays

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.lang.Exception
import kotlin.coroutines.coroutineContext

class HomeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseUser
    private lateinit var uid: String
    private lateinit var userName: String
    private val db = Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Hide Title in Action bar
        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false)
        }

        auth = Firebase.auth.currentUser!!
        uid = auth.uid
        val displayHello = findViewById(R.id.displayHello) as TextView


        fun signin() {
            db.collection("Nutzer")
            .document(uid)
            .get()
            .addOnSuccessListener { result ->
                userName = result["Name"] as String
                displayHello.setText(getString(R.string.HelloUser, userName))

            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
            .addOnCompleteListener {
                // ?
            }
        }

        signin()


        // Button event handlers
        val btn_logout = findViewById(R.id.button_logout) as Button

        btn_logout.setOnClickListener {
            val showRegisterScreen = Intent(this@HomeActivity, WelcomeLoginActivity::class.java)
            startActivity(showRegisterScreen)
            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun getUser(onResult: (Boolean) -> (Unit)): String {
        var uname: String = ""
        val docRef = db.collection("Nutzer")
            .document("Nutzer1")
            .get()
            .addOnSuccessListener { result ->
                uname = result["Name"] as String
                onResult(true)
            }
            .addOnFailureListener { exception ->
                Log.d("TAG", "Error getting documents: ", exception)
            }
        return uname
    }

}







 */