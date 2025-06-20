package com.example.myexpensetracker

import androidx.annotation.WorkerThread
import com.example.myexpensetracker.Model.Transaction
import com.example.myexpensetracker.database.TransactionDAO
import kotlinx.coroutines.flow.Flow

class TransactionRepository(private val transactionDAO: TransactionDAO) {

    val allTransactions: Flow<List<Transaction>> = transactionDAO.getAllTransactions()
    val totalSpent: Flow<Int> = transactionDAO.getTotalSpent()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getTodaySpent(time: Long): Flow<Int>{
        return transactionDAO.getTodaySpent(time)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(transaction: Transaction) {
        transactionDAO.insert(transaction)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(transaction: Transaction) {
        transactionDAO.delete(transaction)
    }

}