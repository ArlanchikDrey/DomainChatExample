package com.ca.rxjava.domain.interactors

import com.ca.entities.Message
import com.ca.rxjava.domain.models.Result
import com.ca.rxjava.domain.repository.IChatRepository
import com.ca.rxjava.domain.usecases.ChatUseCase
import io.reactivex.rxjava3.core.Single

class ChatInteractor(private var chatRepository: IChatRepository): ChatUseCase {

    override fun invoke(): Single<Result<List<Message>>> = chatRepository.getMessages()

}