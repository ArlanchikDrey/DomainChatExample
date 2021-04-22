package com.ca.simple_coroutines.data

import com.ca.entities.Message
import com.ca.entities.ChatName
import com.ca.simple_coroutines.domain.models.Result
import com.ca.simple_coroutines.domain.models.Success
import com.ca.simple_coroutines.domain.repository.IChatRepository

class ChatRepositoryImpl: IChatRepository {
    override suspend fun getMessages(): Result<List<Message>> {
        val messages = mutableListOf<Message>()

        messages.add(Message(date = "20.02.21", text = "Hello",
            chatName = ChatName(name = "Andrey").chatName))
        messages.add(Message(date = "25.03.21", text = "Bye",
            chatName = ChatName(name = "Dima").chatName))

        return Success(data = messages)
    }
}