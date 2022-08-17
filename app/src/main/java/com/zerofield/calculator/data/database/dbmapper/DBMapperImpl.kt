package com.zerofield.calculator.data.database.dbmapper

import com.zerofield.calculator.data.database.model.HistoryItemDBModel
import com.zerofield.calculator.domain.model.HistoryItemModel

class DBMapperImpl : DBMapper {

    override fun mapHistoryItem(historyItem: HistoryItemModel): HistoryItemDBModel =
        with(historyItem) {
            HistoryItemDBModel(id, expression, result)
        }

    override fun mapHistoryItemDBModel(historyItem: HistoryItemDBModel): HistoryItemModel =
        with(historyItem) {
            HistoryItemModel(id, expression, result)
        }
}