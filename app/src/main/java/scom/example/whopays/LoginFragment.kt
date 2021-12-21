package scom.example.whopays

import android.app.Activity
import android.app.ActivityOptions
import android.content.ContentValues
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import scom.example.whopays.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private val db = Firebase.firestore

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        auth = Firebase.auth

        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_login, container, false
        )
        // Inflate the layout for this fragment
        binding.buttonLogin.setOnClickListener {
            signIn()
        }
        binding.buttonRegister.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_registerFragment)
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireView().findViewById<EditText>(R.id.editTextEmail)?.setText(R.string.devuser)
        requireView().findViewById<EditText>(R.id.editTextPin)?.setText(R.string.devpwd)

    }

    private fun signIn() {
        val email = requireView().findViewById<EditText>(R.id.editTextEmail)
        val password = requireView().findViewById<EditText>(R.id.editTextPin)

        if (TextUtils.isEmpty(email.text.toString())) {
            email.setError(resources.getString(R.string.setUserError))
            return
        }

        if (TextUtils.isEmpty(password.text.toString())) {
            password.setError(resources.getString(R.string.setPwdError))
            return
        }

        auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(activity as Activity) { task ->
                    if (task.isSuccessful) {
                        Log.d(ContentValues.TAG, "signInWithEmail:success")
                        getUsername(auth.currentUser!!)
                    } else {
                        Log.w(ContentValues.TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                                activity, "Authentication failed.",
                                Toast.LENGTH_SHORT
                        ).show()
                    }
                }

    }

    private fun getUsername(user: FirebaseUser) {
        val docRef = db.collection("Nutzer").document(user.uid)
        docRef.get()
                .addOnSuccessListener { result ->
                    val uname = result["Name"] as String
                    startMainActivity(uname)
                }
                .addOnFailureListener { exception ->
                    Log.d("TAG", "Error getting documents: ", exception)
                }
    }

    private fun startMainActivity(user: String) {
        val startMainActivity = Intent(activity, MainActivity::class.java)
        startMainActivity.putExtra("Username", user)
        startActivity(
                startMainActivity
        )
    }
}
