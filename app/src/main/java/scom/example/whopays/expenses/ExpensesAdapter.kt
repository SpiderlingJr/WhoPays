package scom.example.whopays.expenses

import android.nfc.Tag
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import scom.example.whopays.ExpenseItemViewHolder
import scom.example.whopays.R

class ExpensesAdapter(private val data: List<Expense>) : RecyclerView.Adapter<ExpensesAdapter.ViewHolder>() {
    //var data = listOf<Expense>()
      /*  set(value) {
            field = value
            notifyDataSetChanged()
        }*/
    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        Log.d("TAG", "In onBindViewHolder")
        holder.textView.text = item.amount.toString()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.expense_item_view, parent, false)
        return ViewHolder(view)
    }
    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.expenseViewSingle)
    }
}