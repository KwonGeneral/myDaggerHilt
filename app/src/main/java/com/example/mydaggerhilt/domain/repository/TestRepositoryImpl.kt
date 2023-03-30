package com.example.mydaggerhilt.domain.repository

import com.example.mydaggerhilt.data.model.TestData

interface TestRepositoryImpl {
    suspend fun test(): TestData
}