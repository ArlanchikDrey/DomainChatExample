package com.ca.rxjava.data
import com.ca.data_store.types.chat.ChatDataStoreFactory
import com.ca.data_store.types.chat.DataStore
import com.ca.entities.ChatName
import com.ca.entities.Message
import com.ca.rxjava.domain.models.Result
import com.ca.rxjava.domain.models.Success
import com.ca.rxjava.domain.repository.IChatRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.internal.operators.single.SingleCreate
import io.reactivex.rxjava3.schedulers.Schedulers

class ChatRepositoryImpl: IChatRepository {

    private val chatDataStoreFactory: ChatDataStoreFactory by lazy { ChatDataStoreFactory() }


    override fun getMessages(): Single<Result<List<Message>>> {
        val chatDataStore = chatDataStoreFactory.create(DataStore.CACHE)

        return SingleCreate<Result<List<Message>>>{
            emitter -> emitter.onSuccess(Success(data = chatDataStore.getMessages()))
        }.subscribeOn(Schedulers.io())
    }
}