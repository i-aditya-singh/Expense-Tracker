package com.example.myexpensetracker.database

import androidx.room.*
import com.example.myexpensetracker.Model.Transaction
import com.example.myexpensetracker.table_name
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDAO {

    @Query("SELECT * FROM transaction_table")
    fun getAllTransactions(): Flow<List<Transaction>>

    @Query("DELETE FROM transaction_table")
    suspend fun deleteAll()

    @Query("SELECT SUM(amount) FROM transaction_table")
    fun getTotalSpent(): Flow<Int>

    @Query("SELECT SUM(amount) FROM transaction_table WHERE time >= :time")
    fun getTodaySpent(time: Long): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(transaction: Transaction)

    @Delete
    suspend fun delete(transaction: Transaction)
}
