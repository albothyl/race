package com.slipp.race.hello

import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWorldControllerTest {
    @Autowired
    lateinit var client : WebTestClient

    @Test
    fun helloWorld1() {
        client.get().uri("/helloworld1")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith {
                    Assertions.assertThat(String(it.responseBody)).isEqualTo("Hello World")
                }
    }

    @Test
    fun helloWorld2() {
        client.get().uri("/helloworld2")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith {
                    Assertions.assertThat(String(it.responseBody)).isEqualTo("Hello World")
                }
    }

    @Test
    fun helloWorld3() {
        client.get().uri("/helloworld3")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith {
                    Assertions.assertThat(String(it.responseBody)).isEqualTo("Hello World")
                }
    }

    @Test
    fun helloWorld4() {
        client.get().uri("/helloworld4")
                .accept(MediaType.TEXT_HTML)
                .exchange()
                .expectStatus().isOk
                .expectBody()
                .consumeWith {
                    Assertions.assertThat(String(it.responseBody)).isEqualTo("helloworld")
                }
    }
}
