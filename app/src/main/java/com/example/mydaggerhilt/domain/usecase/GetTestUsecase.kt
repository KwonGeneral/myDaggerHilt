package com.example.mydaggerhilt.domain.usecase

import com.example.mydaggerhilt.domain.repository.TestRepositoryImpl

class GetTestUsecase(private val repository: TestRepositoryImpl) {
    suspend operator fun invoke() = repository.test()
}