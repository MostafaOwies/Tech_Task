package com.aqua_waterfliter.technicaltask.presentation.domain

import com.aqua_waterfliter.technicaltask.domain.entities.ProductsItem


data class ProductsViewState(
    val products: List<ProductsItem> = emptyList(),
)