package com.example.retrykt.springretry.adapter

import org.springframework.retry.annotation.Backoff
import org.springframework.retry.annotation.Recover
import org.springframework.retry.annotation.Retryable

interface RetryServiceAdapterInterface {
    @Retryable(value = [RemoteServiceNotAvailableException::class], maxAttempts = 3, backoff = Backoff(delay = 3000))
    fun getRetryResponse()

    @Recover
    fun retriesFallback()
}