package com.zerofield.calculator

import android.app.Application
import androidx.room.Room
import com.zerofield.calculator.data.database.CalculatorDatabase
import com.zerofield.calculator.data.database.dbmapper.DBMapperImpl
import com.zerofield.calculator.data.repository.Repository
import com.zerofield.calculator.data.repository.RepositoryImpl

class CalculatorApplication : Application() {

    val repository: Repository by lazy {
        RepositoryImpl(database, DBMapperImpl())
    }

    private val database: CalculatorDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            CalculatorDatabase::class.java,
            CalculatorDatabase.DATABASE_NAME
        ).build()
    }
}