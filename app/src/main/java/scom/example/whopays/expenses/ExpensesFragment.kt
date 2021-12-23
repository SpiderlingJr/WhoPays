package scom.example.whopays.expenses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import scom.example.whopays.R
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

        val data = ArrayList<Expense>()

        for (i in 1..10){
            data.add(Expense(i.toFloat()))
        }
        val adapter = ExpensesAdapter(data)

        binding.expensesList.adapter = adapter
        // End Test RecyclerView

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //val currentUser = auth.currentUser
        val user = requireActivity().intent.extras!!.get("Username").toString()
        requireView().findViewById<TextView>(R.id.helloUser).setText(user)

        // Test Recyclerview
        val recyclerview = requireView().findViewById<RecyclerView>(R.id.expenses_list)
        recyclerview.layoutManager = LinearLayoutManager(activity)




    }

}
