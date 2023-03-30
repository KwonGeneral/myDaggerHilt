package com.example.mydaggerhilt.domain.usecase

import com.example.mydaggerhilt.domain.repository.TestRepositoryImpl
import javax.inject.Inject

class GetTestUsecase @Inject constructor(private val repository: TestRepositoryImpl) {
    suspend operator fun invoke() = repository.test()
}
