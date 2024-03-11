package com.aqua_waterfliter.technicaltask.data.di.app

import com.aqua_waterfliter.technicaltask.data.repo.HomeRepo
import com.aqua_waterfliter.technicaltask.data.repo.HomeRepoI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun bindHomeRepository(repository: HomeRepo): HomeRepoI
}