package com.ca.data_store.types.chat

enum class DataStore{
    CACHE, SERVER
}

class ChatDataStoreFactory {

    fun create(dataStore: DataStore): ChatDataStore{
        return when(dataStore){
            DataStore.CACHE -> CacheChatDataStore()

            DataStore.SERVER -> ServerChatDataStore()
        }
    }
}