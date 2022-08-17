package com.zerofield.calculator.domain

fun getCalculatorButtons(portrait: Boolean = true): List<List<CalculatorButtonData>> =
    if (portrait) {
        listOf(
            listOf(
                CalculatorButtonData(buttonText = "C", type = ButtonType.ClearType),
                CalculatorButtonData(buttonText = "%", type = ButtonType.OperationType),
                CalculatorButtonData(buttonText = "del", type = ButtonType.DeleteType),
                CalculatorButtonData(buttonText = "÷", type = ButtonType.OperationType)
            ),
            listOf(
                CalculatorButtonData(buttonText = "7", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "8", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "9", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "×", type = ButtonType.OperationType),

                ),
            listOf(
                CalculatorButtonData(buttonText = "4", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "5", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "6", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "-", type = ButtonType.OperationType),
            ),
            listOf(
                CalculatorButtonData(buttonText = "1", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "2", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "3", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "+", type = ButtonType.OperationType),
            ),
            listOf(
                CalculatorButtonData(buttonText = "0", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = ".", type = ButtonType.DOTType),
                CalculatorButtonData(buttonText = "=", type = ButtonType.EvaluateType),
            )
        )
    } else {
        listOf(
            listOf(
                CalculatorButtonData(
                    buttonText = "rand",
                    inputText = "rand(",
                    type = ButtonType.FunctionType
                ),
                CalculatorButtonData(buttonText = "e", type = ButtonType.SymbolType),
                CalculatorButtonData(buttonText = "C", type = ButtonType.ClearType),
                CalculatorButtonData(buttonText = "(", type = ButtonType.BracketType),
                CalculatorButtonData(buttonText = ")", type = ButtonType.BracketType),
                CalculatorButtonData(buttonText = "del", type = ButtonType.DeleteType),
                CalculatorButtonData(buttonText = "÷", type = ButtonType.OperationType),
            ),
            listOf(
                CalculatorButtonData(
                    buttonText = "sin",
                    inputText = "sin(",
                    type = ButtonType.FunctionType
                ),
                CalculatorButtonData(
                    buttonText = "ceil",
                    inputText = "ceil(",
                    type = ButtonType.FunctionType
                ),
                CalculatorButtonData(buttonText = "π", type = ButtonType.SymbolType),
                CalculatorButtonData(buttonText = "7", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "8", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "9", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "×", type = ButtonType.OperationType),
            ),

            listOf(
                CalculatorButtonData(
                    buttonText = "cos",
                    inputText = "cos(",
                    type = ButtonType.FunctionType
                ),
                CalculatorButtonData(
                    buttonText = "floor",
                    inputText = "floor(",
                    type = ButtonType.FunctionType
                ),
                CalculatorButtonData(
                    buttonText = "x^y",
                    inputText = "^",
                    type = ButtonType.FunctionType
                ),
                CalculatorButtonData(buttonText = "4", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "5", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "6", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "-", type = ButtonType.OperationType),
            ),
            listOf(
                CalculatorButtonData(
                    buttonText = "tan",
                    inputText = "tan(",
                    type = ButtonType.FunctionType
                ),
                CalculatorButtonData(
                    buttonText = "ln",
                    inputText = "ln(",
                    type = ButtonType.FunctionType
                ),
                CalculatorButtonData(
                    buttonText = "x^2",
                    inputText = "^2",
                    type = ButtonType.FunctionType
                ),
                CalculatorButtonData(buttonText = "1", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "2", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "3", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = "+", type = ButtonType.OperationType),
            ),
            listOf(
                CalculatorButtonData(
                    buttonText = "cot",
                    inputText = "cot(",
                    type = ButtonType.FunctionType
                ),
                CalculatorButtonData(
                    buttonText = "lg",
                    inputText = "lg(",
                    type = ButtonType.FunctionType
                ),
                CalculatorButtonData(
                    buttonText = "x^3",
                    inputText = "^3",
                    type = ButtonType.FunctionType
                ),
                CalculatorButtonData(buttonText = "0", type = ButtonType.DigitType),
                CalculatorButtonData(buttonText = ".", type = ButtonType.DOTType),
                CalculatorButtonData(buttonText = "%", type = ButtonType.OperationType),
                CalculatorButtonData(buttonText = "=", type = ButtonType.EvaluateType),
            )
        )
    }
