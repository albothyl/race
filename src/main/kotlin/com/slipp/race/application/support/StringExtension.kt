package com.slipp.race.application.support

import java.util.Arrays.asList

infix fun String.repeat(no: Int): String {
    val sb = StringBuilder()
    (0 until no).forEach { sb.append(this) }
    return sb.toString()
}

infix fun String.splitToList(seperator: String): List<String> {
    if (!this.contains(seperator)) {
        return asList(this)
    }

    return this.split(seperator)
            .asSequence()
            .toList()
}