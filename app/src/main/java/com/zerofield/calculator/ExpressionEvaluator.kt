package com.zerofield.calculator

import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.function.Function
import java.util.*

const val ERROR = "NaN"

class ExpressionEvaluator() {

    fun evaluate(expression: String): String {
        var expr = expression.replace("%", "/100")
        expr = expr.replace("×", "*")
        expr = expr.replace("÷", "/")

        return try {
            val result = ExpressionBuilder(expr)
                .function(rand)
                .function(ln)
                .function(lg)
                .build()
                .evaluate()
            "${result}"
        } catch (e: Exception) {
            ERROR
        }
    }

    private val rand: Function = object : Function("rand", 1) {
        override fun apply(vararg p0: Double): Double {
            val random : Random = Random()
            return random.nextDouble() * p0[0]
        }
    }

    private val ln: Function = object : Function("ln", 1) {
        override fun apply(vararg p0: Double): Double = Math.log(p0[0])
    }

    private val lg: Function = object : Function("lg", 1) {
        override fun apply(vararg p0: Double): Double = Math.log10(p0[0])
    }
}