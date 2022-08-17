package com.zerofield.calculator.data.database.dbmapper

import com.zerofield.calculator.data.database.model.HistoryItemDBModel
import com.zerofield.calculator.domain.model.HistoryItemModel

interface DBMapper {
//    fun mapHistoryItemList(list: List<HistoryItemModel>): List<HistoryItemDBModel>

    fun mapHistoryItem(historyItem: HistoryItemModel): HistoryItemDBModel

//    fun mapHistoryItemDBList(list: List<HistoryItemDBModel>): List<HistoryItemModel>

    fun mapHistoryItemDBModel(historyItem: HistoryItemDBModel): HistoryItemModel
}