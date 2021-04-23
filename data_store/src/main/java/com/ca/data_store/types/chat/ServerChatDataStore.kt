package com.ca.data_store.types.chat

import com.ca.entities.Message

class ServerChatDataStore: ChatDataStore {
    override fun getMessages(): List<Message> {
        //Request to network and get response
        //Mapping before return
        return listOf()
    }
}