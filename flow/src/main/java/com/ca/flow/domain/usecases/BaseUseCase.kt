package com.ca.flow.domain.usecases

import com.ca.flow.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface BaseUseCase<R: Any> {
    fun invoke(): Flow<Result<R>>
}