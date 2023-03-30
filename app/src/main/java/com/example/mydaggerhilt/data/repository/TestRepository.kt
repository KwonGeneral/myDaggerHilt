package com.example.mydaggerhilt.data.repository

import android.util.Log
import com.example.mydaggerhilt.data.model.TestData
import com.example.mydaggerhilt.domain.repository.TestRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestRepository @Inject constructor(): TestRepositoryImpl {
    override suspend fun test(): TestData {
        return CoroutineScope(Dispatchers.IO).async {
            Log.d("KWON_LOG", "TestRepository.test()")
            return@async TestData(
                1,
                "title",
                "content",
                1234567890,
                1234567890
            )
        }.await()
    }
}
