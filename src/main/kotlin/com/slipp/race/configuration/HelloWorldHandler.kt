package com.slipp.race.configuration

import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class HelloWorldHandler {
    fun hello3() : Mono<String> {
        println("HelloWorldHandler::hello3")
        return Mono.just("Hello World")
    }
}