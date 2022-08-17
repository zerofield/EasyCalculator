package com.zerofield.calculator.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zerofield.calculator.R
import com.zerofield.calculator.domain.model.HistoryItemModel
import com.zerofield.calculator.routing.BackButtonHandler
import com.zerofield.calculator.routing.CalculatorRouter
import com.zerofield.calculator.routing.Screen
import com.zerofield.calculator.ui.components.HistoryItem
import com.zerofield.calculator.ui.theme.MyBlue
import com.zerofield.calculator.ui.theme.MyGray
import com.zerofield.calculator.viewmodel.CalculatorViewModel
import kotlinx.coroutines.launch

@Composable
fun HistoryScreen(viewModel: CalculatorViewModel) {

    val historyItems by viewModel.getHistoryList().observeAsState(listOf())
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            HistoryTopAppBar(
                onBackClick = viewModel::onHistoryBackClick,
                onDeleteButtonClick = viewModel::onDeleteHistoryButtonClick
            )
        },
        content = {
            HistoryList(historyItems,
                onItemClick = {
                    viewModel.onHistoryItemClick(it)
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("已添加该运算公式")
                    }
                }
            )
        },
        snackbarHost = {
            SnackbarHost(it) { data ->
                Snackbar(
                    snackbarData = data,
                    backgroundColor = MyBlue,
                    contentColor = MyGray,
                    shape = RoundedCornerShape(10.dp)
                )
            }
        }
    )
    BackButtonHandler {
        CalculatorRouter.navigateTo(Screen.Calculator)
    }
}

@Composable
private fun HistoryTopAppBar(
    onBackClick: () -> Unit,
    onDeleteButtonClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.history)
            )
        },
        navigationIcon = {
            IconButton(
                content = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(id = R.string.back)
                    )
                },
                onClick = onBackClick
            )
        },
        actions = {
            IconButton(
                content = {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = stringResource(id = R.string.delete)
                    )
                },
                onClick = onDeleteButtonClick
            )
        },
        elevation = 5.dp
    )
}

@Composable
private fun HistoryList(
    historyItems: List<HistoryItemModel>,
    onItemClick: (HistoryItemModel) -> Unit
) {
    LazyColumn {
        items(historyItems.size) { index ->
            HistoryItem(historyItems[index], onItemClick)
        }
    }
}