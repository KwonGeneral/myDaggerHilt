package com.example.mydaggerhilt.domain.repository

interface TestRepositoryImpl {
    suspend fun test(): String
}