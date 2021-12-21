package scom.example.whopays

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import scom.example.whopays.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login, container, false
        )
        // Inflate the layout for this fragment
        binding.buttonLogin.setOnClickListener{
            val startMainActivity = Intent(activity, MainActivity::class.java)
            startActivity(startMainActivity)

        }
        binding.buttonRegister.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_registerFragment))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireView().findViewById<EditText>(R.id.editTextEmail)?.setText(R.string.devuser)
        requireView().findViewById<EditText>(R.id.editTextPin)?.setText(R.string.devpwd)

    }
}
