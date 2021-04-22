package com.ca.simple_coroutines.domain.repository

import com.ca.entities.Message
import com.ca.simple_coroutines.domain.models.Result

interface IChatRepository {
    suspend fun getMessages(): Result<List<Message>>
}