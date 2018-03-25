package com.slipp.race.`interface`

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class HelloWorldController {

    @GetMapping("/helloworld1")
    fun hello1(): String {
        return "Hello World"
    }

    @GetMapping("/helloworld2")
    fun hello2(): Mono<String> {
        return Mono.just("Hello World")
    }
}
