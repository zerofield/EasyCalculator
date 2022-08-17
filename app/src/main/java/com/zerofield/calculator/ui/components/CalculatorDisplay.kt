package com.zerofield.calculator.ui.components

import android.text.TextUtils
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zerofield.calculator.ERROR
import com.zerofield.calculator.ui.theme.MyError
import com.zerofield.calculator.ui.theme.MyGray
import com.zerofield.calculator.ui.theme.MyResult
import com.zerofield.calculator.viewmodel.CalculatorViewModel

@Composable
fun CalculatorDisplay(
    modifier: Modifier = Modifier,
    portrait: Boolean,
    viewModel: CalculatorViewModel
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .padding(bottom = 16.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Bottom
    ) {

        val expression by viewModel.expression.observeAsState(initial = "0")
        val result by viewModel.result.observeAsState("")

        val fontSize = if (!TextUtils.isEmpty(result)) {
            20.sp
        } else {
            if (expression.length < 20) 36.sp else 24.sp
        }
        val expressionFontColor = if (!TextUtils.isEmpty(result)) Color(0xFF919191) else MyGray

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            text = expression,
            fontSize = fontSize,
            color = expressionFontColor,
            textAlign = TextAlign.End
        )

        if (!TextUtils.isEmpty(result)) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                text = result,
                fontSize = 36.sp,
                color = if (result == ERROR) MyError else MyResult,
                textAlign = TextAlign.End
            )
        }
    }
}