package com.zerofield.calculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zerofield.calculator.ERROR
import com.zerofield.calculator.ExpressionEvaluator
import com.zerofield.calculator.data.repository.Repository
import com.zerofield.calculator.domain.ButtonType
import com.zerofield.calculator.domain.CalculatorButtonData
import com.zerofield.calculator.domain.model.HistoryItemModel
import com.zerofield.calculator.routing.CalculatorRouter
import com.zerofield.calculator.routing.Screen
import com.zerofield.utils.canInsertDecimal
import com.zerofield.utils.numberOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.exp

class CalculatorViewModel(private val repository: Repository) : ViewModel() {

    private val evaluator: ExpressionEvaluator by lazy {
        ExpressionEvaluator()
    }

    private val _expression = MutableLiveData<String>("0")
    val expression: LiveData<String> = _expression

    private val _result = MutableLiveData<String>("")
    val result: LiveData<String> = _result

    var evaluated = false

    fun getHistoryList(): LiveData<List<HistoryItemModel>> = repository.getAllHistories()

    fun onHistoryBackClick() {
        CalculatorRouter.navigateTo(Screen.Calculator)
    }

    private fun insertHistory() {
        val exp = expression.value
        val res = result.value

        viewModelScope.launch(Dispatchers.Default) {
            if (exp != null && res != null) {
                val history = HistoryItemModel(expression = exp, result = res)
                repository.insertHistory(history)
            }
        }
    }

    fun onDeleteHistoryButtonClick() {
        viewModelScope.launch(Dispatchers.Default) {
            repository.deleteAllHistories()
        }
    }

    fun onHistoryClick() {
        CalculatorRouter.navigateTo(Screen.History)
    }

    fun onHistoryItemClick(historyItem: HistoryItemModel) {
        _expression.value = historyItem.expression
        _result.value = ""
        evaluated = false
    }

    fun onButtonClick(button: CalculatorButtonData) {
        handleEvaluatedValue()

        when (button.type) {
            is ButtonType.DeleteType -> delete()
            is ButtonType.ClearType -> clear()
            is ButtonType.EvaluateType -> evaluate()
            is ButtonType.DOTType -> appendDot(button)
            is ButtonType.BracketType -> appendBracket(button)
            is ButtonType.SymbolType, ButtonType.DigitType -> appendDigitAndSymbol(button)
            is ButtonType.FunctionType -> appendFunction(button)
            else -> append(button)
        }
    }

    private fun handleEvaluatedValue() {
        if (evaluated) {
            if (_result.value != ERROR) {
                _expression.value = _result.value
            } else {
                _expression.value = "0"
            }
            _result.value = ""
            evaluated = false
        }
    }

    private fun delete() {
        var exp = _expression.value

        if (exp == null) {
            exp = "0"
        }

        exp = if (exp.length == 1) {
            "0"
        } else {
            exp.substring(0, exp.length - 1)
        }

        _expression.value = exp
    }

    private fun clear() {
        _result.value = ""
        _expression.value = "0"
    }

    private fun evaluate() {
        _result.value = _expression.value?.let { evaluator.evaluate(it) }
        insertHistory()
        evaluated = true
    }

    private fun appendDot(button: CalculatorButtonData) {
        _expression.value?.let {
            if (canInsertDecimal(_expression.value!!)) {
                _expression.value += button.inputText
            }
        }
    }

    private fun appendDigitAndSymbol(button: CalculatorButtonData) {
        if (_expression.value == "0") {
            _expression.value = button.inputText
        } else {
            _expression.value += button.inputText
        }
    }

    private fun appendBracket(button: CalculatorButtonData) {
        if (button.inputText == ")") {
            val expr = _expression.value
            expr?.let {
                if (expr.numberOf('(') > expr.numberOf(')')) {
                    _expression.value += button.inputText
                }
            }
        } else {
            if (_expression.value == "0") {
                _expression.value = button.inputText
            } else {
                _expression.value += button.inputText
            }
        }
    }

    private fun appendFunction(button: CalculatorButtonData) {
        if (_expression.value == "0") {
            if (button.inputText == "^") {
                _expression.value += button.inputText
            } else {
                _expression.value = button.inputText
            }
        } else {
            _expression.value += button.inputText
        }
    }

    private fun append(button: CalculatorButtonData) {
        _expression.value += button.inputText
    }
}