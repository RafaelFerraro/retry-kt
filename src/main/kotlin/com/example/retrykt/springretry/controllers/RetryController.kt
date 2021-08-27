package com.example.retrykt.springretry.controllers

import com.example.retrykt.springretry.adapter.RetryServiceAdapterInterface
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RetryController(private val retryServiceAdapter: RetryServiceAdapterInterface) {
    @GetMapping("/retry")
    fun retry() {
        println("==========================")

        retryServiceAdapter.getRetryResponse()

        println("==========================")
    }
}