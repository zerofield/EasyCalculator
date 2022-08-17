package com.zerofield.calculator.routing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

sealed class Screen {
    object Calculator : Screen()
    object History : Screen()
}

object CalculatorRouter {

    var currentScreen: Screen by mutableStateOf(Screen.Calculator)

    fun navigateTo(screen: Screen) {
        currentScreen = screen
    }
}

