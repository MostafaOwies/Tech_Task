package com.aqua_waterfliter.technicaltask.presentation.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aqua_waterfliter.technicaltask.domain.usecases.GetProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProducts: GetProducts,
) : ViewModel() {

    private val _state = MutableStateFlow(ProductsViewState())
    val state: StateFlow<ProductsViewState> = _state.asStateFlow()

    fun onEVent(event: ProductsEvent) {
        when (event) {
            is ProductsEvent.LoadProducts -> loadPProducts()
        }
    }

    private fun loadPProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = getProducts()

            _state.update { oldState ->
                oldState.copy(
                    products = response
                )
            }
        }
    }
}