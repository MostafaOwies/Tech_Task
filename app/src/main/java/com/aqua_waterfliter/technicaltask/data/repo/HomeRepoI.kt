package com.aqua_waterfliter.technicaltask.data.repo

import com.aqua_waterfliter.technicaltask.domain.entities.ProductsItem

interface HomeRepoI {
    suspend fun getProducts() : List<ProductsItem>
}
