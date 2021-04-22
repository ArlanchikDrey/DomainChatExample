package com.ca.rxjava.domain.usecases

import io.reactivex.rxjava3.core.Single

interface BaseUseCase<R: Any> {
    fun invoke(): Single<R>
}