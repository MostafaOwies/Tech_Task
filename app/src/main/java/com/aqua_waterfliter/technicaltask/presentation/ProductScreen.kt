package com.aqua_waterfliter.technicaltask.presentation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aqua_waterfliter.technicaltask.domain.entities.ProductsItem
import com.aqua_waterfliter.technicaltask.presentation.componants.ProductDetailsSheet
import com.aqua_waterfliter.technicaltask.presentation.componants.ProductsCard
import com.aqua_waterfliter.technicaltask.presentation.domain.ProductsEvent
import com.aqua_waterfliter.technicaltask.presentation.domain.ProductsViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen() {
    val productsViewModel = hiltViewModel<ProductsViewModel>()
    productsViewModel.onEVent(ProductsEvent.LoadProducts)
    val state = productsViewModel.state.collectAsState().value
    val selectedProduct = remember { mutableStateOf<ProductsItem?>(null) }
    val bottomSheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Log.d(TAG, "ProductsScreen: ${state.products}")

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = MaterialTheme.colorScheme.surfaceColorAtElevation(5.dp),
    ) {

        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
        ) {
            items(
                items = state.products,
                key = {
                    val anyId: Any = it.id
                    anyId
                }
            ) {

                ProductsCard(
                    it,
                    onProductsClick = {
                        selectedProduct.value = it
                        showBottomSheet = true
                    }


                )
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp)
                )
            }
        }

        if (showBottomSheet) {
            ModalBottomSheet(
                content = {
                    ProductDetailsSheet(
                        selectedProduct = selectedProduct,
                        onConfirmClick = {
                            coroutineScope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                if (!bottomSheetState.isVisible) {
                                    showBottomSheet = false
                                }
                            }
                        }
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                sheetState = bottomSheetState,
                onDismissRequest = { showBottomSheet = false }
            )
        }
    }
}