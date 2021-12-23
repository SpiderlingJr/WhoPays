package scom.example.whopays.loginregister

import android.app.Activity
import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import scom.example.whopays.R
import scom.example.whopays.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private val db = Firebase.firestore


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRegisterBinding>(
            inflater, R.layout.fragment_register, container, false
        )
        binding.buttonCreateAccount.setOnClickListener {
            if (checkRegisterInputs()) {
                val name =
                    requireView().findViewById<EditText>(R.id.editTextPersonName).text.toString()
                val email = requireView().findViewById<EditText>(R.id.editTextEmail).text.toString()
                val pwd = requireView().findViewById<EditText>(R.id.editTextPin).text.toString()
                createAccount(name, email, pwd)
            }
        }
        auth = FirebaseAuth.getInstance()

        return binding.root
    }

    //override fun onViewCreated(view: View, savedInstanceState: Bundle?) {}

    private fun checkRegisterInputs(): Boolean {
        val name = requireView().findViewById<EditText>(R.id.editTextPersonName)
        val email = requireView().findViewById<EditText>(R.id.editTextEmail)
        val pin = requireView().findViewById<EditText>(R.id.editTextPin)
        val confirmPin = requireView().findViewById<EditText>(R.id.editTextConfirmPin)

        var validInput = true
        if (TextUtils.isEmpty(name.text.toString())) {
            name.setError(resources.getString(R.string.setUserError))
            validInput = false
        }
        if (TextUtils.isEmpty(email.text.toString())) {
            email.setError(resources.getString(R.string.setEmailError))
            validInput = false
        }
        if (TextUtils.isEmpty(pin.text.toString())) {
            pin.setError(resources.getString(R.string.setPwdError))
            validInput = false
        }
        if (TextUtils.isEmpty(confirmPin.text.toString())) {
            confirmPin.setError(resources.getString(R.string.setPwdConfirmError))
            validInput = false
        }
        if (!TextUtils.equals(pin.text.toString(), confirmPin.text.toString())) {
            pin.setError(resources.getString(R.string.setPwdNotMatchingError))
            confirmPin.setError(resources.getString(R.string.setPwdNotMatchingError))
            validInput = false
        }
        return validInput
    }

    private fun createAccount(name: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity as Activity) { task ->
                if (task.isSuccessful) {
                    val uid = auth.currentUser!!.uid
                    putNewUserInFirestore(uid, name)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        activity, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }
            }
    }

    private fun putNewUserInFirestore(uid: String, name: String) {
        /** Stores the new User's Name and UID in Firestore */
        val user = hashMapOf(
            "Name" to name
        )
        val docRef = db.collection("Nutzer").document(uid)
        docRef.set(user)
        .addOnSuccessListener {
            Log.d(tag, "SUCCESS IN SUCCESS")
        }
        .addOnCompleteListener {
            Toast.makeText(
                activity, "Nutzer erstellt!",
                Toast.LENGTH_SHORT
            ).show()
            findNavController().navigateUp()
        }


    }
}
