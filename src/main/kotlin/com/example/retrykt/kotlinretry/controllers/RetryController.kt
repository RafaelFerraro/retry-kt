package com.example.retrykt.kotlinretry.controllers

import com.github.michaelbull.retry.ContinueRetrying
import com.github.michaelbull.retry.StopRetrying
import com.github.michaelbull.retry.policy.*
import com.github.michaelbull.retry.retry
import kotlinx.coroutines.runBlocking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class RetryController {
    @GetMapping("/kotlin-retry")
    fun retry() {
        println("==============================")

        RetryService().execute()

        println("==============================")
    }
}

class RetryService {
    private var errorCount = 0

    private val retryPolicy: RetryPolicy<Throwable> = {
        if (reason is KotlinRetryException) ContinueRetrying else StopRetrying
    }

    private suspend fun logic() {
        if (errorCount > 8) {
            println("End of retries, success!")
        } else {
            errorCount++
            val localDateTime = LocalDateTime.now()
            println("$localDateTime Let's try again...")
            throw KotlinRetryException("Retry exception message $localDateTime")
        }
    }

    fun execute() = runBlocking {
        retry(retryPolicy + limitAttempts(10) + decorrelatedJitterBackoff(base = 1000, max = 20000)) {
            logic()
        }
    }
}
class KotlinRetryException(message: String): Exception(message)