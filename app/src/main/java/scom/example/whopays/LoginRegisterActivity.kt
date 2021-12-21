package scom.example.whopays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import scom.example.whopays.databinding.ActivityLoginRegisterBinding

class LoginRegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private lateinit var binding: ActivityLoginRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth

        val binding = DataBindingUtil.setContentView<ActivityLoginRegisterBinding>(this, R.layout.activity_login_register)
        val accountNavController = this.findNavController(R.id.accountNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, accountNavController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val accountNavController = this.findNavController(R.id.accountNavHostFragment)
        return accountNavController.navigateUp()
    }
}

/* OLD WELCOME LOGIN ACTIVITIY

package scom.example.whopays

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class WelcomeLoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        auth = Firebase.auth

        // Hide Title in Action bar
        val actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false)
        }

        // Button event handlers
        val btn_register = findViewById(R.id.buttonRegister) as Button
        val btn_login = findViewById(R.id.button_login) as Button


        // TODO REMOVE THIS \/
        findViewById<EditText>(R.id.editTextEmail).setText(R.string.devuser)
        findViewById<EditText>(R.id.editTextPin).setText(R.string.devpwd)
        // TODO REMOVE THIS /\


        btn_register.setOnClickListener {
            val showRegisterScreen = Intent(this@WelcomeLoginActivity, RegisterActivity::class.java)
            startActivity(showRegisterScreen)
            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
        btn_login.setOnClickListener {
            val email = findViewById<EditText>(R.id.editTextEmail)
            val password = findViewById<EditText>(R.id.editTextPin)

            if (TextUtils.isEmpty(email.text.toString())) {
                email.setError(resources.getString(R.string.setUserError))
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password.text.toString())) {
                password.setError(resources.getString(R.string.setPwdError))
                return@setOnClickListener
            }

            signIn(
                email = email.text.toString(),
                password = password.text.toString()
            )
        }
    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            //reload();
        }
    }


    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(ContentValues.TAG, "signInWithEmail:success")
                    val user = auth.currentUser

                    val value = "Hello world"
                    val i = Intent(this@WelcomeLoginActivity, HomeActivity::class.java)
                    i.putExtra("userName", value)

                    updateUI(user)
                } else {
                    Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }

    public fun sendEmailVerification() {
        val user = auth.currentUser!!
        user.sendEmailVerification()
            .addOnCompleteListener(this) { task ->
                // Email verification sent
            }
    }

    fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            val showHomeScreen = Intent(this@WelcomeLoginActivity, HomeActivity::class.java)
            startActivity(showHomeScreen)
        }
    }

}
 */