package com.ca.data_store.types.chat

import com.ca.entities.Message

interface ChatDataStore {
    fun getMessages(): List<Message>
}