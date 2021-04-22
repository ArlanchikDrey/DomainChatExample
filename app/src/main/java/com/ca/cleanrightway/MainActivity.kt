package com.ca.cleanrightway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    private val disposables = CompositeDisposable()

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//Use coroutine; GlobalScope - just example
//        val repository = ChatRepositoryImpl()
//
//        launch(coroutineContext) {
//            val messages = ChatInteractor(repository).invoke()
//            Log.d("MSMDMDMD", messages.toString())
//        }

//Use RxJava
//        val repository = ChatRepositoryImpl()
//
//        disposables.add(ChatInteractor(repository).invoke()
//            .observeOn(AndroidSchedulers.mainThread()).subscribe({
//                Log.d("MSMDMDMD", it.toString())
//            },{
//                Log.d("ERROR", it.toString())
//            }))

//Use Flow
//        val repository = ChatRepositoryImpl()
//
//
//        launch(coroutineContext) {
//            ChatInteractor(repository).invoke().collect {
//                Log.d("MSMDMDMD", it.toString())
//            }
//        }
    }

    override fun onStop() {
        disposables.clear()
        super.onStop()
    }

    override fun onDestroy() {
        if(!disposables.isDisposed){
            disposables.dispose()
        }
        coroutineContext.cancelChildren()
        super.onDestroy()
    }
}