package com.slipp.race

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.reactive.config.EnableWebFlux

@SpringBootApplication()
@EnableWebFlux
@ComponentScan(basePackages = arrayOf("com.slipp"))
class RaceApplication

fun main(args: Array<String>) {
    runApplication<RaceApplication>(*args)
}
