package com.aqua_waterfliter.technicaltask.data.api

import com.aqua_waterfliter.technicaltask.domain.entities.Rating
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiProductsItem(
    @field:Json(name = "category") val category: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "image") val image: String?,
    @field:Json(name = "price") val price: Double?,
    @field:Json(name = "rating") val rating: Rating?,
    @field:Json(name = "title") val title: String?,

    )

@JsonClass(generateAdapter = true)
data class ApiRating(
    @field:Json(name = "count") val count: Int?,
    @field:Json(name = "rate") val rate: Double?,
)