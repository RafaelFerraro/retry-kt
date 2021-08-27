package com.example.retrykt.kotlinretry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry

@EnableRetry
@SpringBootApplication
class RetryKtApplicationKotlinRetry

fun main(args: Array<String>) {
    runApplication<RetryKtApplicationKotlinRetry>(*args)
}
