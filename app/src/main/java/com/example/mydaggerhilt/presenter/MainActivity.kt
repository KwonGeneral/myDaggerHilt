package com.example.mydaggerhilt.presenter

import com.example.mydaggerhilt.domain.usecase.GetTestUsecase
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.mydaggerhilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    @Inject lateinit var getTestUsecase: GetTestUsecase
//    var getTestUsecase: com.example.mydaggerhilt.domain.usecase.GetTestUsecase = com.example.mydaggerhilt.domain.usecase.GetTestUsecase(TestRepository())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        CoroutineScope(Dispatchers.IO).launch {
            getTestUsecase().let {
                Log.d("KWON_LOG", "com.example.mydaggerhilt.presenter.MainActivity.onCreate() : ${it.title}")
            }
        }
    }
}
