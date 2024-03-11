package com.aqua_waterfliter.technicaltask.data.di.app

import dagger.hilt.migration.AliasOf
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@AliasOf(Singleton::class)
annotation class AppScope
