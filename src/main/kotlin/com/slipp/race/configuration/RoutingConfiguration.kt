package com.slipp.race.configuration

import com.google.common.collect.Maps
import com.slipp.race.`interface`.Race
import com.slipp.race.application.grandprix.Car
import com.slipp.race.application.grandprix.GrandPrix
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyExtractors
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono


@Configuration
class RoutingConfiguration @Autowired constructor(private val granPrix: GrandPrix) {
    @Bean
    fun routeFunctionExample1(handler: HelloWorldHandler): RouterFunction<ServerResponse> = router {
        GET("/helloworld3") { req ->
            println("come in helloworld3")
            ServerResponse.ok().body(
                    handler.hello3()
            )
        }
    }

    @Bean
    fun routeFunctionExample2(handler: HelloWorldHandler): RouterFunction<ServerResponse> = router {
        accept(MediaType.TEXT_HTML).nest {
            GET("/helloworld4") {
                println("come in helloworld4")
                ServerResponse.ok().render("index")
            }
        }
    }

    @Bean
    fun raceRouteFunction1(): RouterFunction<ServerResponse> = router {
        accept(MediaType.TEXT_HTML).nest {
            GET("/v1/regist") {
                println("come in helloworld4")
                ServerResponse.ok().render("index")
            }
        }
    }

    @Bean
    fun raceFormRouteFunction3(): RouterFunction<ServerResponse> = router {
        accept(MediaType.APPLICATION_FORM_URLENCODED).nest {
            POST("/v1/regist") { req ->

//                val racerList = req.body(BodyExtractors.toMono(Race::class.java))
//                val racerList = req.body(BodyExtractors.toFormData())
                val racerList = req.body(BodyExtractors.toMono(Race::class.java))
                        .flatMap {
                            race ->
//                            val racers = race.get("racers")
//                            val finalLap = race.get("finalLap")

                                Mono.just(granPrix.regist(race))
                        }

                val resultMap = Maps.newHashMap<String, Mono<List<String>>>()
                resultMap.put("racerList", racerList)
                ServerResponse.ok().render("game", resultMap)
            }
        }
    }

    @Bean
    fun raceRouteFunction2(): RouterFunction<ServerResponse> = router {
        ("/v1").nest {
            GET("/indexRace") {
                ServerResponse.ok().render("index")
            }
            POST("/regist") { req ->
                val racerList = req.bodyToMono(Race::class.java)
                        .flatMap { race -> Mono.just(granPrix.regist(race)) }

                val resultMap = Maps.newHashMap<String, Mono<List<String>>>()
                resultMap.put("racerList", racerList)
                ServerResponse.ok().render("game", resultMap)
            }
            GET("/race") { req ->
                val winner = req.bodyToMono(Integer::class.java)
                        .flatMap { finalLap -> Mono.just(granPrix.race(finalLap.toInt())) }

                val resultMap = Maps.newHashMap<String, Mono<Car>>()
                resultMap.put("winner", winner)
                ServerResponse.ok().render("result", resultMap)
            }
        }
    }
}