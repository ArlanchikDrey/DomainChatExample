package com.ca.data_store.types.chat

import com.ca.entities.ChatName
import com.ca.entities.Message

class Cache{
    fun getMessagesFromCache(): List<Message>{
        //Get data from internal database

        val messages = mutableListOf<Message>()

        messages.add(Message(date = "20.02.21", text = "Hello",
            chatName = ChatName(name = "Andrey").chatName))
        messages.add(Message(date = "25.03.21", text = "Bye",
            chatName = ChatName(name = "Dima").chatName))

        return messages
    }
}

class CacheChatDataStore: ChatDataStore {

    private val cache: Cache by lazy { Cache() }

    override fun getMessages(): List<Message> {
        return cache.getMessagesFromCache()
    }
}