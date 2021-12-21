package scom.example.whopays

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import scom.example.whopays.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRegisterBinding>(
            inflater, R.layout.fragment_register, container, false
        )
        return binding.root
    }
}

/* OLD REGISTER ACTIVITY
package scom.example.whopays

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        // Hide Title in Action bar
        val btn_register = findViewById(R.id.button_login) as Button
        btn_register.setOnClickListener {
            val name = findViewById<EditText>(R.id.editTextPersonName)
            val email = findViewById<EditText>(R.id.editTextEmail)
            val pin = findViewById<EditText>(R.id.editTextPin)
            val confirmPin = findViewById<EditText>(R.id.editTextConfirmPin)

            if (TextUtils.isEmpty(name.text.toString())) {
                name.setError(resources.getString(R.string.setUserError))
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(email.text.toString())) {
                email.setError(resources.getString(R.string.setEmailError))
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(pin.text.toString())) {
                pin.setError(resources.getString(R.string.setPwdError))
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(confirmPin.text.toString())) {
                confirmPin.setError(resources.getString(R.string.setPwdConfirmError))
                return@setOnClickListener
            }
            if (!TextUtils.equals(pin.text.toString(), confirmPin.text.toString())) {
                pin.setError(resources.getString(R.string.setPwdNotMatchingError))
                confirmPin.setError(resources.getString(R.string.setPwdNotMatchingError))
                return@setOnClickListener
            }
            createAccount(
                email = email.text.toString(),
                password = pin.text.toString()
            )
        }
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }
}
 */