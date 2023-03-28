package com.example.mydaggerhilt.data.repository

import android.util.Log
import com.example.mydaggerhilt.domain.repository.TestRepositoryImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async

class TestRepository: TestRepositoryImpl {
    override suspend fun test(): String {
        return CoroutineScope(Dispatchers.IO).async {
            Log.d("KWON_LOG", "TestRepository.test()")
            return@async ""
        }.await()
    }
}