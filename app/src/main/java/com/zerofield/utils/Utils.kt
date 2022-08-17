package com.zerofield.utils

fun String.numberOf(char: Char): Int {
    var counter = 0
    for (ch in this) {
        if (char == ch) {
            ++counter
        }
    }
    return counter
}


fun canInsertDecimal(express: String): Boolean {
    val reversed = express.reversed()
    for (char in reversed) {
        if (char.isDigit()) {
            continue
        }

        if (char == '.') {
            return false
        } else {
            break
        }
    }
    return true
}