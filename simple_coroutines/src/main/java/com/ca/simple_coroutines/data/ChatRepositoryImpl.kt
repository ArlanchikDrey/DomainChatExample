package com.ca.simple_coroutines.data

import com.ca.data_store.types.chat.ChatDataStoreFactory
import com.ca.data_store.types.chat.DataStore
import com.ca.entities.Message
import com.ca.simple_coroutines.domain.models.Result
import com.ca.simple_coroutines.domain.models.Success
import com.ca.simple_coroutines.domain.repository.IChatRepository

class ChatRepositoryImpl: IChatRepository {
    private val chatDataStoreFactory: ChatDataStoreFactory by lazy { ChatDataStoreFactory() }

    override suspend fun getMessages(): Result<List<Message>> {

        val chatDataStore = chatDataStoreFactory.create(DataStore.CACHE)

        return Success(data = chatDataStore.getMessages())
    }
}