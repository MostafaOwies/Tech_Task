package com.aqua_waterfliter.technicaltask.data.api

import com.aqua_waterfliter.technicaltask.utils.Constants
import retrofit2.http.GET

interface ProductsApi {
    @GET(Constants.END_POINT)
    suspend fun getProducts(): List<ApiProductsItem>
}