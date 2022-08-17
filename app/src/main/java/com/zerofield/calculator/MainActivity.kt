package com.zerofield.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import com.zerofield.calculator.routing.CalculatorRouter
import com.zerofield.calculator.routing.Screen
import com.zerofield.calculator.ui.screens.CalculatorScreen
import com.zerofield.calculator.ui.screens.HistoryScreen
import com.zerofield.calculator.ui.theme.EasyCalculatorTheme
import com.zerofield.calculator.viewmodel.CalculatorViewModel
import com.zerofield.calculator.viewmodel.CalculatorViewModelFactory

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<CalculatorViewModel>(factoryProducer = {
        val repository = (application as CalculatorApplication).repository
        CalculatorViewModelFactory(this, repository)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EasyCalculatorTheme {
                Surface {
                    when (CalculatorRouter.currentScreen) {
                        is Screen.Calculator -> CalculatorScreen(viewModel)
                        is Screen.History -> HistoryScreen(viewModel)
                    }
                }
            }
        }
    }
}