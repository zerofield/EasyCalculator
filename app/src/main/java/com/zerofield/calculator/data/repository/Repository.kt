package com.zerofield.calculator.data.repository

import androidx.lifecycle.LiveData
import com.zerofield.calculator.domain.model.HistoryItemModel

interface Repository {

    fun getAllHistories(): LiveData<List<HistoryItemModel>>

    fun insertHistory(history: HistoryItemModel)

    fun deleteAllHistories()
}