package com.slipp.race.application.support

infix fun String.repeat(no: Int): String {
    val sb = StringBuilder()
    (0 until no).forEach { sb.append(this) }
    return sb.toString()
}