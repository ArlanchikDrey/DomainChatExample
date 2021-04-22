package com.ca.simple_coroutines.domain.usecases

import com.ca.entities.Message
import com.ca.simple_coroutines.domain.models.Result

interface ChatUseCase: BaseUseCase<List<Message>> {
    override suspend operator fun invoke(): Result<List<Message>>
}