package com.slipp.race.`interface`.hello

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class RaceController {

    @PostMapping("/race")
    fun hello(@ModelAttribute names: Names): String {
        println("RaceController ===============")
//        model.addAttribute("name", "World")

        return "index"
    }
}
