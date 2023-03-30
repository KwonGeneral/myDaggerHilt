package com.example.mydaggerhilt.domain.module

import com.example.mydaggerhilt.data.repository.TestRepository
import com.example.mydaggerhilt.domain.repository.TestRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TestModule {
    @Binds
    abstract fun bindTestRepository(repository: TestRepository): TestRepositoryImpl
}
