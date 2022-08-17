package com.zerofield.calculator.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.zerofield.calculator.data.database.model.HistoryItemDBModel

@Dao
interface HistoryDao {

    @Query("SELECT * from history")
    fun queryAllHistories(): List<HistoryItemDBModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHistory(history: HistoryItemDBModel)

    @Query("DELETE FROM history")
    fun deleteAllHistories()
}