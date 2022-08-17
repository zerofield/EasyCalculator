package com.zerofield.calculator.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zerofield.calculator.data.database.dao.HistoryDao
import com.zerofield.calculator.data.database.model.HistoryItemDBModel


@Database(entities = [HistoryItemDBModel::class], version = 1, exportSchema = false)
abstract class CalculatorDatabase: RoomDatabase() {

    abstract fun historyDao(): HistoryDao

    companion object {
        const val DATABASE_NAME = "calculator_db"
    }

}