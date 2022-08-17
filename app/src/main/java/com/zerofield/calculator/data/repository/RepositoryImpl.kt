package com.zerofield.calculator.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zerofield.calculator.data.database.CalculatorDatabase
import com.zerofield.calculator.data.database.dbmapper.DBMapper
import com.zerofield.calculator.domain.model.HistoryItemModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RepositoryImpl(
    private val db: CalculatorDatabase,
    private val mapper: DBMapper
) : Repository {

    private val historyList: MutableLiveData<List<HistoryItemModel>> by lazy {
        MutableLiveData<List<HistoryItemModel>>()
    }

    init {
        initData()
    }

    private fun initData() {
        GlobalScope.launch {
            updateHistoryLiveData()
        }
    }

    override fun getAllHistories(): LiveData<List<HistoryItemModel>> = historyList

    override fun insertHistory(history: HistoryItemModel) {
        db.historyDao().insertHistory(mapper.mapHistoryItem(history))
        updateHistoryLiveData()
    }

    override fun deleteAllHistories() {
        db.historyDao().deleteAllHistories()
        updateHistoryLiveData()
    }

    private fun queryAllHistoriesSync(): List<HistoryItemModel> =
        db.historyDao().queryAllHistories().map {
            mapper.mapHistoryItemDBModel(it)
        }

    private fun updateHistoryLiveData() {
        historyList.postValue(queryAllHistoriesSync())
    }
}