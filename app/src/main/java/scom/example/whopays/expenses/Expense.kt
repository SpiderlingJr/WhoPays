package scom.example.whopays.expenses

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ExpensesTable")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    var expenseId: Long = 0L,

    @ColumnInfo(name = "Amount")
    var amount: Float = 0.0f,

    @ColumnInfo(name="Date")
    val date: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "Accepted")
    val accepted: Boolean = false,

    @ColumnInfo(name = "Amount")
    var payorShare: Float = 0.5f,

    @ColumnInfo(name = "Payor")
    var payor: String = "",

    @ColumnInfo(name = "Partner")
    var partner: String = "",

    @ColumnInfo(name = "Where")
    var where: String = "",

    @ColumnInfo(name = "Description")
    var description: String = "",
)
/*data class Expense(val amount: Float) {
}
/
 */

