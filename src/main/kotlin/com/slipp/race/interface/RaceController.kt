package com.slipp.race.`interface`

import com.slipp.race.application.grandprix.GrandPrix
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class RaceController @Autowired constructor(private val granPrix: GrandPrix) {

    @GetMapping("/")
    fun createGranPrixForm(model: Model): String {
        model.addAttribute("name", "World")

        return "index"
    }

    @PostMapping("/regist")
    fun regist(race: Race, model: Model): String {
        val registedRacers = granPrix.regist(race)

        model["racerList"] = registedRacers

        return "game"
    }

    @GetMapping("/race")
    fun finalLap(race: Race, model: Model): String {

        model["winner"] = granPrix.race(race.finalLap)

        return "result"
    }
}
