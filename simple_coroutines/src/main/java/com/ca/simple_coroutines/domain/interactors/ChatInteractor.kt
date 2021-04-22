package com.ca.simple_coroutines.domain.interactors

import com.ca.entities.Message
import com.ca.simple_coroutines.domain.models.Result
import com.ca.simple_coroutines.domain.repository.IChatRepository
import com.ca.simple_coroutines.domain.usecases.ChatUseCase

class ChatInteractor(private var chatRepository: IChatRepository): ChatUseCase {

    override suspend fun invoke(): Result<List<Message>> = chatRepository.getMessages()

}