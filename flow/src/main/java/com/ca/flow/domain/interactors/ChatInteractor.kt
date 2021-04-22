package com.ca.flow.domain.interactors

import com.ca.entities.Message
import com.ca.flow.domain.models.Result
import com.ca.flow.domain.repository.IChatRepository
import com.ca.flow.domain.usecases.ChatUseCase
import kotlinx.coroutines.flow.Flow

class ChatInteractor(private var chatRepository: IChatRepository): ChatUseCase {
    override fun invoke(): Flow<Result<List<Message>>> = chatRepository.getMessages()
}