package com.example.mydaggerhilt

import android.os.Build.VERSION_CODES.O
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.mydaggerhilt.data.repository.TestRepository
import com.example.mydaggerhilt.domain.usecase.GetTestUsecase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    var getTestUsecase = GetTestUsecase(TestRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CoroutineScope(Dispatchers.IO).launch {
            getTestUsecase()
        }
    }
}

class AnalyticsAdapter @Inject constructor(private val service: AnalyticsService) {

    fun test() {
        service.analyticsMethod()
        Log.d("KWON_LOG", "AnalyticsAdapter.test()")
    }
}

interface AnalyticsService {
    fun analyticsMethod()
}

class AnalyticsServiceImpl @Inject constructor(): AnalyticsService {
    override fun analyticsMethod() {
        Log.d("KWON_LOG", "AnalyticsServiceImpl.analyticsMethod()")
    }
}

/**
 * @InstallIn(ActivityComponent::class)
 * 위 코드를 사용해서, 해당 AnalyticsModule이 ActivityComponent에 의해 생성되도록 한다.
 * ActivityComponent는 Activity의 생명주기를 따른다.
 */
@Module
@InstallIn(ActivityComponent::class)
abstract class AnalyticsModule {
    @Binds
    abstract fun bindAnalyticsService(impl: AnalyticsServiceImpl): AnalyticsService
}