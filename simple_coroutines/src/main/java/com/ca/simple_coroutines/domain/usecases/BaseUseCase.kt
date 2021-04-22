package com.ca.simple_coroutines.domain.usecases

import com.ca.simple_coroutines.domain.models.Result

interface BaseUseCase<R: Any> {
    suspend operator fun invoke(): Result<R>
}