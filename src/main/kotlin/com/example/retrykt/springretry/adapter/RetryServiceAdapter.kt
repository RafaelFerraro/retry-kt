package com.example.retrykt.springretry.adapter

import org.springframework.stereotype.Service

@Service
class RetryServiceAdapter: RetryServiceAdapterInterface {
    private var countToSucceed: Int = 0

    override fun getRetryResponse() {
        if (countToSucceed > 3) {
            println("Without retry! Success!")
        } else {
            println("We will try again soon...")
            countToSucceed++
            throw RemoteServiceNotAvailableException("Retry exception message")
        }
    }

    override fun retriesFallback() {
        println("All retries completed. I'm here to avoid the retry exception bubble up. You are welcome =)")
    }
}