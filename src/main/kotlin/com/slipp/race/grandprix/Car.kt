package com.slipp.race.grandprix

class Car(val _name: String) {
    val name = _name
    var lap: Int = 0

    fun move(distance: Int) {
        if (distance > 4) {
            lap++
        }

        println("${name}'s distance : ${"-".repeat(lap)}")
    }
}

infix fun String.repeat(no: Int): String {
    val sb = StringBuilder()
    (0 until no).forEach { sb.append(this) }
    return sb.toString()
}