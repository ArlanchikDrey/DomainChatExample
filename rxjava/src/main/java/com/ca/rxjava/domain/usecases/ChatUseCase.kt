package com.ca.rxjava.domain.usecases

import com.ca.entities.Message
import io.reactivex.rxjava3.core.Single
import com.ca.rxjava.domain.models.Result

interface ChatUseCase: BaseUseCase<Result<List<Message>>> {
    override fun invoke(): Single<Result<List<Message>>>
}