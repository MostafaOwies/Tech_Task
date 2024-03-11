package com.aqua_waterfliter.technicaltask.data.api

import com.aqua_waterfliter.technicaltask.domain.entities.ProductsItem
import com.aqua_waterfliter.technicaltask.domain.entities.Rating
import com.aqua_waterfliter.technicaltask.utils.ApiMapper
import javax.inject.Inject

class ApiProductsMapper @Inject constructor() :
    ApiMapper<List<ApiProductsItem>, List<ProductsItem>> {
    override fun mapToDomain(apiEntity: List<ApiProductsItem>): List<ProductsItem> {
        return apiEntity.map { apiProductItem ->
            ProductsItem(
                category = apiProductItem.category.orEmpty(),
                description = apiProductItem.description.orEmpty(),
                id = apiProductItem.id ?: 0,
                image = apiProductItem.image.orEmpty(),
                price = apiProductItem.price ?: 0.0,
                title = apiProductItem.title.orEmpty(),
                rating = Rating(
                    count = apiProductItem.rating?.count ?: 0,
                    rate = apiProductItem.rating?.rate ?: 0.0,
                )
            )
        }
    }
}
