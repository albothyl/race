package com.slipp.race.`interface`.hello

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class InitController {

    @GetMapping("/")
    fun hello(model: Model): String {
        println("InitController ===============")
        model.addAttribute("name", "World")

        return "index"
    }
}
