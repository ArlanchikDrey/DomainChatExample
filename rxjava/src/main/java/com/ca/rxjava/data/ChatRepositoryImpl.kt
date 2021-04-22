package com.ca.rxjava.data
import com.ca.entities.ChatName
import com.ca.entities.Message
import com.ca.rxjava.domain.models.Result
import com.ca.rxjava.domain.models.Success
import com.ca.rxjava.domain.repository.IChatRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.internal.operators.single.SingleCreate
import io.reactivex.rxjava3.schedulers.Schedulers

class ChatRepositoryImpl: IChatRepository {
    override fun getMessages(): Single<Result<List<Message>>> {
        val messages = mutableListOf<Message>()

        messages.add(Message(date = "20.02.21", text = "Hello",
            chatName = ChatName(name = "Andrey").chatName))
        messages.add(Message(date = "25.03.21", text = "Bye",
            chatName = ChatName(name = "Dima").chatName))

        return SingleCreate<Result<List<Message>>>{
            emitter -> emitter.onSuccess(Success(data = messages))
        }.subscribeOn(Schedulers.io())
    }
}