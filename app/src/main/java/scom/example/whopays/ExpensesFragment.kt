package scom.example.whopays

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.google.firebase.auth.FirebaseAuth
import scom.example.whopays.databinding.FragmentExpensesBinding

// TODO: Rename parameter arguments, choose names that match

class ExpensesFragment : Fragment() {
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentExpensesBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_expenses, container, false
        )
        // Inflate the layout for this fragment
        binding.buttonSwapPartner.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_expensesFragment_to_partnerViewFragment)
        )
        binding.buttonNewExpense.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_expensesFragment_to_newExpenseFragment)
        )
        auth = FirebaseAuth.getInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //val currentUser = auth.currentUser
        val user = requireActivity().intent.extras!!.get("Username").toString()
        requireView().findViewById<TextView>(R.id.helloUser).setText(user)
    }

}
