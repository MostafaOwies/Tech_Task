package com.aqua_waterfliter.technicaltask.domain.usecases

import com.aqua_waterfliter.technicaltask.data.repo.HomeRepoI
import com.aqua_waterfliter.technicaltask.domain.entities.ProductsItem
import javax.inject.Inject

class GetProducts @Inject constructor(
    private val homeRepoI: HomeRepoI,
) {

    suspend operator fun invoke(): List<ProductsItem> {
        return homeRepoI.getProducts()
    }
}