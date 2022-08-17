package com.zerofield.calculator.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.zerofield.calculator.data.repository.Repository

class CalculatorViewModelFactory(
    owner: SavedStateRegistryOwner,
    private val repository: Repository
) : AbstractSavedStateViewModelFactory(owner, null) {

    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return CalculatorViewModel(repository) as T
    }
}
