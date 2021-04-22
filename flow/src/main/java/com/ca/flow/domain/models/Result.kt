package com.ca.flow.domain.models

sealed class Result<out T : Any>
data class Success<out T : Any>(val data: T) : Result<T>()