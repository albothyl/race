package com.slipp.race

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication()
@ComponentScan(basePackages = arrayOf("com.slipp"))
class RaceApplication

fun main(args: Array<String>) {
    runApplication<RaceApplication>(*args)
}
