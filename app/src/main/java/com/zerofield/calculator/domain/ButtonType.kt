package com.zerofield.calculator.domain

import androidx.compose.ui.graphics.Color
import com.zerofield.calculator.ui.theme.MyBlack
import com.zerofield.calculator.ui.theme.MyGray
import com.zerofield.calculator.ui.theme.MyOrange
import com.zerofield.calculator.ui.theme.MyTeal


sealed class ButtonType {

    object DigitType : ButtonType()

    object DOTType : ButtonType()

    object SymbolType : ButtonType() {
        override fun getTextColor(): Color = MyTeal
    }

    object OperationType : ButtonType() {
        override fun getTextColor(): Color = MyOrange
    }

    object BracketType : ButtonType() {
        override fun getTextColor(): Color = MyOrange
    }

    object ClearType : ButtonType() {
        override fun getTextColor(): Color = MyOrange
    }

    object DeleteType : ButtonType() {
        override fun getTextColor(): Color = MyOrange
    }

    object FunctionType : ButtonType() {
        override fun getTextColor(): Color = MyTeal
    }

    object EvaluateType : ButtonType() {
        override fun getTextColor(): Color = MyGray
        override fun getBackgroundColor(): Color = MyOrange
    }

    open fun getTextColor(): Color = MyGray

    open fun getBackgroundColor(): Color = MyBlack
}