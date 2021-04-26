package com.ca.cleanrightway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.ca.flow.data.ChatRepositoryImpl as FlowChatRepositoryImpl
import com.ca.flow.domain.interactors.ChatInteractor as FlowChatInteractor
import com.ca.rxjava.data.ChatRepositoryImpl as RxChatRepositoryImpl
import com.ca.rxjava.domain.interactors.ChatInteractor as RxChatInteractor
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import com.ca.simple_coroutines.data.ChatRepositoryImpl as CoroutinesChatRepositoryImpl
import com.ca.simple_coroutines.domain.interactors.ChatInteractor as CoroutinesChatInteractor
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    private val disposables = CompositeDisposable()

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.tv)

        tv.setOnClickListener {
            if (tv.text != "Hello World!")
                tv.text = "Hello World!"

            //Use coroutine;
//          launch(coroutineContext) {
//               val res = useCoroutine()
//               tv.text = res.toString()
//          }

            //Use RxJava
//          useRx()

            //Use Flow
//          launch(coroutineContext) {
//              val res = useFlow()
//              Log.d("MSMDMDMD", res.toString())
//              tv.text = res.toString()
//          }


            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
        }

    }

    private suspend fun useCoroutine(): Any {

        return withContext(Dispatchers.IO) {
            val repository = CoroutinesChatRepositoryImpl()

            val messages = CoroutinesChatInteractor(repository).invoke()
            Log.d("MSMDMDMD", messages.toString())

            messages
        }
    }

    private fun useRx() {
        val repository = RxChatRepositoryImpl()

        disposables.add(RxChatInteractor(repository).invoke()
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    Log.d("MSMDMDMD", it.toString())
                    tv.text = it.toString()
                }, {
                    Log.d("ERROR", it.toString())
                }))
    }

    private suspend fun useFlow(): Any {

        return withContext(Dispatchers.IO){
            val repository = FlowChatRepositoryImpl()

            var messages: Any = ""
            FlowChatInteractor(repository).invoke().collect {
                messages = it
            }

            messages
        }
    }

    override fun onStop() {
        disposables.clear()
        super.onStop()
    }

    override fun onDestroy() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
        coroutineContext.cancelChildren()
        super.onDestroy()
    }
}