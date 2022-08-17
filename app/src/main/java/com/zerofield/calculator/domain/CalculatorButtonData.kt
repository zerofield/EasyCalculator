package com.zerofield.calculator.domain

class CalculatorButtonData(
    val buttonText: String,
    val inputText: String = buttonText,
    val type: ButtonType
)