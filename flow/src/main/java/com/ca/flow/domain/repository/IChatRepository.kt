package com.ca.flow.domain.repository

import com.ca.entities.Message
import com.ca.flow.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface IChatRepository {
    fun getMessages(): Flow<Result<List<Message>>>
}