package com.zerofield.calculator.domain.model

import androidx.room.Entity

data class HistoryItemModel(
    val id: Long = 0,
    val expression: String,
    val result: String
)