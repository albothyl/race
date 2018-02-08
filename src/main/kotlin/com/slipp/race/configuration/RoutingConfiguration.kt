package com.slipp.race.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router


@Configuration
class RoutingConfiguration {
    @Bean
    fun routeFunction(handler: HelloWorldHandler): RouterFunction<ServerResponse> = router {
        GET("/helloworld3") { req ->
            println("come in helloworld3")
            ServerResponse.ok().body(
                    handler.hello3()
            )
        }
    }

    @Bean
    fun routeFunction1(handler: HelloWorldHandler): RouterFunction<ServerResponse> = router {
        accept(MediaType.TEXT_HTML).nest {
            GET("/v1/helloworld4") {
                println("come in /v1/helloworld4")
                ServerResponse.ok().render("game")
            }
        }
    }

    @Bean
    fun routeFunction3(handler: HelloWorldHandler): RouterFunction<ServerResponse> = router {
        GET("/v2/helloworld4") {
            ServerResponse.ok().body(
                    handler.hello3()
            ).checkpoint()
        }
    }
}