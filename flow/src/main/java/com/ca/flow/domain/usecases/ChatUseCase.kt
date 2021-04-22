package com.ca.flow.domain.usecases

import com.ca.entities.Message
import com.ca.flow.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface ChatUseCase: BaseUseCase<List<Message>> {
    override fun invoke(): Flow<Result<List<Message>>>
}