package com.slipp.race.`interface`

import com.slipp.race.application.grandprix.GrandPrix
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable
import reactor.core.publisher.Flux

@Controller
class RaceController @Autowired constructor(private val granPrix: GrandPrix) {

    @GetMapping("/")
    fun createGranPrixForm(model: Model): String {
        return "index"
    }

    @PostMapping("/regist")
    fun regist(race: Race, model: Model): String {
        val registedRacers = granPrix.regist(race)

        model["racerList"] = registedRacers

        return "game"
    }

    @GetMapping("/race")
    fun finalLap(model: Model): String {
        val raceResult = Flux
                .fromIterable(granPrix.race())
                .repeat(granPrix.finalLap)
                .concatWith(Flux.fromIterable(granPrix.winner()))

        model.addAttribute("raceResult", ReactiveDataDriverContextVariable(raceResult, 5))

        return "result-reactive"
    }
}
