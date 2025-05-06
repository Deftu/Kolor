package dev.deftu.kolor.test

import dev.deftu.kolor.Color
import dev.deftu.kolor.Kolor.parseHex
import dev.deftu.kolor.NamedColors.findClosestNamedColor
import dev.deftu.kolor.toCss
import kotlin.test.Test

class CssTest {

    @Test
    fun test() {
        val color: Color = parseHex("#CC3F3F")
        println(color)
        println(color.name)

        val closest = findClosestNamedColor(color)
        println(closest)
        println(closest.name)

        val cssColor = color.toCss()
        println(cssColor)

        val cssClosest = closest.toCss()
        println(cssClosest)
    }

}
