package dev.deftu.kolor

import kotlin.math.floor

@Suppress("FunctionName")
public fun HSBtoRGB(hue: Float, saturation: Float, brightness: Float): Int {
    val r: Int
    val g: Int
    val b: Int
    if (saturation == 0f) {
        r = (brightness * 255.0f + 0.5f).toInt()
        g = r
        b = r
    } else {
        val h = (hue - floor(hue)) * 6.0f
        val f = h - floor(h)
        val p = brightness * (1.0f - saturation)
        val q = brightness * (1.0f - saturation * f)
        val t = brightness * (1.0f - saturation * (1.0f - f))
        when (h.toInt()) {
            0 -> {
                r = (brightness * 255.0f + 0.5f).toInt()
                g = (t * 255.0f + 0.5f).toInt()
                b = (p * 255.0f + 0.5f).toInt()
            }

            1 -> {
                r = (q * 255.0f + 0.5f).toInt()
                g = (brightness * 255.0f + 0.5f).toInt()
                b = (p * 255.0f + 0.5f).toInt()
            }

            2 -> {
                r = (p * 255.0f + 0.5f).toInt()
                g = (brightness * 255.0f + 0.5f).toInt()
                b = (t * 255.0f + 0.5f).toInt()
            }

            3 -> {
                r = (p * 255.0f + 0.5f).toInt()
                g = (q * 255.0f + 0.5f).toInt()
                b = (brightness * 255.0f + 0.5f).toInt()
            }

            4 -> {
                r = (t * 255.0f + 0.5f).toInt()
                g = (p * 255.0f + 0.5f).toInt()
                b = (brightness * 255.0f + 0.5f).toInt()
            }

            5 -> {
                r = (brightness * 255.0f + 0.5f).toInt()
                g = (p * 255.0f + 0.5f).toInt()
                b = (q * 255.0f + 0.5f).toInt()
            }

            else -> {
                r = 0
                g = 0
                b = 0
            }
        }
    }
    return (r shl 16) or (g shl 8) or b
}

@Suppress("FunctionName")
public fun RGBtoHSB(red: Int, green: Int, blue: Int, output: FloatArray? = null): FloatArray {
    val output = output ?: FloatArray(3)

    var cmax = if (red > green) red else green
    if (blue > cmax) {
        cmax = blue
    }

    var cmin = if (red < green) red else green
    if (blue < cmin) {
        cmin = blue
    }

    val brightness = cmax.toFloat() / 255.0f
    val saturation = if (cmax != 0) {
        (cmax - cmin).toFloat() / cmax.toFloat()
    } else {
        0f
    }

    val hue = if (saturation != 0f) {
        val redc = (cmax - red).toFloat() / (cmax - cmin).toFloat()
        val greenc = (cmax - green).toFloat() / (cmax - cmin).toFloat()
        val bluec = (cmax - blue).toFloat() / (cmax - cmin).toFloat()
        (when (cmax) {
            red -> {
                bluec - greenc
            }

            green -> {
                2f + redc - bluec
            }

            else -> {
                4f + greenc - redc
            }
        } / 6.0f).coerceAtLeast(0f)
    } else {
        0f
    }

    output[0] = hue
    output[1] = saturation
    output[2] = brightness

    return output
}
