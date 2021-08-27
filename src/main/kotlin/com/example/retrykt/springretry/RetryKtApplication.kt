package com.example.retrykt.springretry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.retry.annotation.EnableRetry

@EnableRetry
@SpringBootApplication
class RetryKtApplication

fun main(args: Array<String>) {
	runApplication<RetryKtApplication>(*args)
}
