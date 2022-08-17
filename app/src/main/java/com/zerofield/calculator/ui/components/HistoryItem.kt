package com.zerofield.calculator.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zerofield.calculator.ERROR
import com.zerofield.calculator.domain.model.HistoryItemModel
import com.zerofield.calculator.ui.theme.MyError
import com.zerofield.calculator.ui.theme.MyGray
import com.zerofield.calculator.ui.theme.MyLightGray
import com.zerofield.calculator.ui.theme.MyResult

@Composable
fun HistoryItem(
    historyItem: HistoryItemModel,
    onItemClick: (HistoryItemModel) -> Unit
) {

    val backgroundShape: Shape = RoundedCornerShape(4.dp)

    Column(
        modifier = Modifier
            .padding(8.dp)
            .shadow(1.dp, backgroundShape)
            .background(MyLightGray, backgroundShape)
            .fillMaxWidth()
            .clickable { onItemClick(historyItem) }
    ) {
        Text(
            text = historyItem.expression,
            Modifier
                .fillMaxWidth()
                .padding(top = 6.dp, start = 8.dp, end = 8.dp),
            textAlign = TextAlign.End,
            maxLines = 3,
            fontSize = 14.sp,
            color = MyGray
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = historyItem.result,
            Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp, start = 8.dp, end = 8.dp),
            textAlign = TextAlign.End,
            maxLines = 1,
            fontSize = 28.sp,
            color = if (historyItem.result == ERROR) MyError else MyResult
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HistoryItemPreview() {
    val item = HistoryItemModel(
        id = 1,
        expression = "1+2=",
        result = "3"
    )
    HistoryItem(item, {})
}
