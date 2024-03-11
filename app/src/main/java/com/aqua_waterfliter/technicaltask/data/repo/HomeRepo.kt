package com.aqua_waterfliter.technicaltask.data.repo

import com.aqua_waterfliter.technicaltask.data.api.ApiProductsMapper
import com.aqua_waterfliter.technicaltask.data.api.ProductsApi
import com.aqua_waterfliter.technicaltask.domain.entities.ProductsItem
import javax.inject.Inject

class HomeRepo @Inject constructor(
    private val apiProductsMapper: ApiProductsMapper,
    private val productsApi: ProductsApi
) : HomeRepoI {
    override suspend fun getProducts(): List<ProductsItem> {
        try {
            return apiProductsMapper.mapToDomain(
                productsApi.getProducts()
            )
        } catch (e: Exception) {
            throw (e)
        }
    }
}
