package com.zerofield.calculator.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zerofield.calculator.R
import com.zerofield.calculator.domain.CalculatorButtonData
import com.zerofield.calculator.ui.components.ButtonLayout
import com.zerofield.calculator.ui.components.CalculatorDisplay
import com.zerofield.calculator.viewmodel.CalculatorViewModel

@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(onHistoryClick = viewModel::onHistoryClick)
        },
        content = {
            val configuration = LocalConfiguration.current
            CalculatorLayout(
                viewModel = viewModel,
                portrait = configuration.orientation != Configuration.ORIENTATION_LANDSCAPE,
                onButtonClick = { viewModel.onButtonClick(it) }
            )
        }
    )
}


@Composable
private fun TopAppBar(
    onHistoryClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name)
            )
        },
        actions = {
            IconButton(
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_clock),
                        contentDescription = stringResource(id = R.string.delete)
                    )
                },
                onClick = onHistoryClick
            )
        },
        elevation = 5.dp
    )
}

@Composable
private fun CalculatorLayout(
    viewModel: CalculatorViewModel,
    portrait: Boolean = true,
    onButtonClick: (CalculatorButtonData) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        CalculatorDisplay(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            portrait = portrait,
            viewModel = viewModel
        )
        ButtonLayout(
            portrait = portrait,
            modifier = Modifier
                .fillMaxWidth(),
            onButtonClick = onButtonClick
        )
    }
}

