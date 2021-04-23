package com.ca.flow.data

import com.ca.data_store.types.chat.ChatDataStoreFactory
import com.ca.data_store.types.chat.DataStore
import com.ca.entities.ChatName
import com.ca.entities.Message
import com.ca.flow.domain.models.Result
import com.ca.flow.domain.models.Success
import com.ca.flow.domain.repository.IChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ChatRepositoryImpl: IChatRepository {
    private val chatDataStoreFactory: ChatDataStoreFactory by lazy { ChatDataStoreFactory() }

    override fun getMessages(): Flow<Result<List<Message>>> {
        val chatDataStore = chatDataStoreFactory.create(DataStore.CACHE)

        return flow {
            emit(Success(data = chatDataStore.getMessages()))
        }
    }
}