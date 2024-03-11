package com.aqua_waterfliter.technicaltask.utils

interface ApiMapper<E, D> {
    fun mapToDomain(apiEntity: E): D
}
