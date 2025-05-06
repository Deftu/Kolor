package dev.deftu.kolor

import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlin.random.Random

/**
 * Provides static color constants and factory methods for creating [Color] instances.
 */
public object Kolor {

    /**
     * Creates a [StaticColor] from red, green, blue, and alpha components.
     *
     * @param red The red channel (0-255).
     * @param green The green channel (0-255).
     * @param blue The blue channel (0-255).
     * @param alpha The alpha channel (0-255).
     * @return A new [StaticColor].
     */
    @JvmStatic
    public fun rgba(red: Int, green: Int, blue: Int, alpha: Int): StaticColor {
        return StaticColor(red = red, green = green, blue = blue, alpha = alpha)
    }

    /**
     * Creates a [StaticColor] from a packed RGBA integer (0xAARRGGBB).
     *
     * @param rgba The integer value containing ARGB channels.
     * @return A new [StaticColor].
     */
    @JvmStatic
    public fun rgba(rgba: Int): StaticColor {
        return StaticColor(
            red = (rgba shr 16) and 0xFF,
            green = (rgba shr 8) and 0xFF,
            blue = rgba and 0xFF,
            alpha = (rgba shr 24) and 0xFF
        )
    }

    /**
     * Creates a [StaticColor] from red, green, and blue components (alpha = 255).
     *
     * @param red The red channel (0-255).
     * @param green The green channel (0-255).
     * @param blue The blue channel (0-255).
     * @return A new [StaticColor].
     */
    @JvmStatic
    public fun rgb(red: Int, green: Int, blue: Int): StaticColor {
        return StaticColor(red = red, green = green, blue = blue)
    }

    /**
     * Creates a [StaticColor] from a packed RGB integer (0xRRGGBB).
     *
     * @param rgb The integer value containing RGB channels.
     * @return A new [StaticColor] with alpha = 255.
     */
    @JvmStatic
    public fun rgb(rgb: Int): StaticColor {
        return rgba(
            red = (rgb shr 16) and 0xFF,
            green = (rgb shr 8) and 0xFF,
            blue = rgb and 0xFF,
            alpha = 255
        )
    }

    /**
     * Creates a [StaticColor] from alpha, red, green, and blue components.
     *
     * @param alpha The alpha channel (0-255).
     * @param red The red channel (0-255).
     * @param green The green channel (0-255).
     * @param blue The blue channel (0-255).
     * @return A new [StaticColor].
     */
    @JvmStatic
    public fun argb(alpha: Int, red: Int, green: Int, blue: Int): StaticColor {
        return StaticColor(red = red, green = green, blue = blue, alpha = alpha)
    }

    /**
     * Creates a [StaticColor] from hue, saturation, brightness, and optional alpha.
     *
     * @param hue The hue (0.0-1.0).
     * @param saturation The saturation (0.0-1.0).
     * @param brightness The brightness (0.0-1.0).
     * @param alpha The alpha channel (0-255).
     * @return A new [StaticColor].
     */
    @JvmStatic
    @JvmOverloads
    public fun hsb(hue: Float, saturation: Float, brightness: Float, alpha: Int = 255): StaticColor {
        return StaticColor(hue = hue, saturation = saturation, brightness = brightness, alpha = alpha)
    }

    /**
     * Creates a [GradientColor] between [first] and [second] using the given [type] and optional alpha.
     *
     * @param first The first color.
     * @param second The second color.
     * @param type The gradient type (e.g. linear, radial).
     * @param alpha The alpha channel (0-255).
     * @return A new [GradientColor].
     */
    @JvmStatic
    @JvmOverloads
    public fun gradient(first: Color, second: Color, type: GradientType, alpha: Int = 255): GradientColor {
        return GradientColor(first, second, type, alpha)
    }

    /**
     * Parses a hexadecimal color string into a [StaticColor].
     *
     * Supports "#RRGGBB", "#AARRGGBB", "RRGGBB", or "AARRGGBB" formats.
     *
     * @param hex The hex string to parse.
     * @return A [StaticColor].
     * @throws IllegalArgumentException if the format is invalid.
     */
    @JvmStatic
    public fun parseHex(hex: String): StaticColor {
        val cleaned = hex.removePrefix("#")
        return when (cleaned.length) {
            3 -> rgb(
                cleaned[0].digitToInt(16) * 17,
                cleaned[1].digitToInt(16) * 17,
                cleaned[2].digitToInt(16) * 17
            )

            6 -> rgb(
                cleaned.substring(0, 2).toInt(16),
                cleaned.substring(2, 4).toInt(16),
                cleaned.substring(4, 6).toInt(16)
            )

            8 -> rgba(
                cleaned.substring(2, 4).toInt(16),
                cleaned.substring(4, 6).toInt(16),
                cleaned.substring(6, 8).toInt(16),
                cleaned.substring(0, 2).toInt(16)
            )

            else -> throw IllegalArgumentException("Invalid hex color: $hex")
        }
    }

    /**
     * Generates a random [StaticColor].
     *
     * @param alpha The alpha channel (0-255), default 255.
     * @return A random [StaticColor].
     */
    @JvmStatic
    @JvmOverloads
    public fun random(alpha: Int = 255): StaticColor {
        return rgba(
            red = Random.nextInt(0, 256),
            green = Random.nextInt(0, 256),
            blue = Random.nextInt(0, 256),
            alpha = alpha
        )
    }

}
