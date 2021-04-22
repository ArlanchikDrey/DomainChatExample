package com.ca.flow.data

import com.ca.entities.ChatName
import com.ca.entities.Message
import com.ca.flow.domain.models.Result
import com.ca.flow.domain.models.Success
import com.ca.flow.domain.repository.IChatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ChatRepositoryImpl: IChatRepository {
    override fun getMessages(): Flow<Result<List<Message>>> {
        val messages = mutableListOf<Message>()

        messages.add(Message(date = "20.02.21", text = "Hello",
            chatName = ChatName(name = "Andrey").chatName))
        messages.add(Message(date = "25.03.21", text = "Bye",
            chatName = ChatName(name = "Dima").chatName))

        return flow {
            emit(Success(data = messages))
        }
    }
}