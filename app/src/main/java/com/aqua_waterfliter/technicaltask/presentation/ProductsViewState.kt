package com.aqua_waterfliter.technicaltask.presentation

import com.aqua_waterfliter.technicaltask.domain.entities.ProductsItem


data class ProductsViewState(
    val products: List<ProductsItem> = emptyList(),
)