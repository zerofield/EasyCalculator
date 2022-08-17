package com.zerofield.calculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zerofield.calculator.R
import com.zerofield.calculator.domain.ButtonType
import com.zerofield.calculator.domain.CalculatorButtonData
import com.zerofield.calculator.domain.getCalculatorButtons


@Composable
fun ButtonLayout(
    modifier: Modifier = Modifier,
    portrait: Boolean = true,
    onButtonClick: (CalculatorButtonData) -> Unit
) {
    val buttons: List<List<CalculatorButtonData>> = getCalculatorButtons(portrait)

    Column(modifier = modifier.background(Color.DarkGray)) {
        buttons.forEach { list ->
            Row {
                list.forEach { item ->
                    val isZero = item.buttonText == "0"
                    val weight = if (isZero && portrait) 2f else 1f
                    val aspectRatio = if (portrait) {
                        if (isZero) 2f else 1f
                    } else {
                        2.5f
                    }

                    Column(
                        modifier = Modifier
                            .weight(weight)
                            .aspectRatio(aspectRatio),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CalculatorButton(portrait, item, onButtonClick)
                    }
                }
            }
        }
    }
}

@Composable
private fun CalculatorButton(
    portrait: Boolean = true,
    item: CalculatorButtonData,
    onButtonClick: (CalculatorButtonData) -> Unit
) {
    Button(
        modifier = Modifier
            .padding(1.dp)
            .fillMaxSize(),
        shape = RectangleShape,
        onClick = {
            onButtonClick(item)
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = item.type.getBackgroundColor()),
    ) {

        if (item.type == ButtonType.DeleteType) {
            Icon(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = stringResource(id = R.string.delete),
                tint = item.type.getTextColor()
            )
        } else {
            Text(
                text = item.buttonText,
                fontSize = if (portrait) 30.sp else 16.sp,
                color = item.type.getTextColor()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonLayoutPreview() {
    ButtonLayout(portrait = false, onButtonClick = {})
}
