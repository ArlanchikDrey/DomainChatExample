package com.ca.rxjava.domain.repository

import com.ca.entities.Message
import com.ca.rxjava.domain.models.Result
import io.reactivex.rxjava3.core.Single

interface IChatRepository {
    fun getMessages(): Single<Result<List<Message>>>
}