package dev.deftu.kolor

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Represents a color with hue, saturation, brightness, and alpha properties.
 * Provides RGB, ARGB, and RGBA integer representations, as well as derived color manipulation functions.
 *
 * This is an abstract base class. Use [Kolor.rgba], [Kolor.rgb], [Kolor.hsb], or similar factory methods to create instances.
 *
 * @property alpha The alpha channel (0-255), where 0 is fully transparent and 255 is fully opaque.
 * @property hue The hue component (0.0-1.0).
 * @property saturation The saturation component (0.0-1.0).
 * @property brightness The brightness component (0.0-1.0).
 */
public abstract class Color(
    public val alpha: Int,
    hue: Float = 0f,
    saturation: Float = 0f,
    brightness: Float = 0f
) {

    /** The hue component (0.0-1.0). */
    public open val hue: Float = hue

    /** The saturation component (0.0-1.0). */
    public open val saturation: Float = saturation

    /** The brightness component (0.0-1.0). */
    public open val brightness: Float = brightness

    /**
     * Creates an integer-packed colour value using this color's hue, saturation, and brightness values converted to RGB.
     *
     * @return A bitshifted integer containing the RGB values of this color - 0bRRRRRRRRGGGGGGGGBBBBBBBB (0xRRGGBB)
     */
    public open val rgb: Int
        get() = HSBtoRGB(hue, saturation, brightness)

    /**
     * Creates an integer-packed colour value using this color's red, green, blue, and alpha values.
     *
     * @return A bitshifted integer containing the ARGB values of this color - 0bAAAAAAAARRRRRRRRGGGGGGGGBBBBBBBB (0xAARRGGBB)
     */
    public open val argb: Int
        get() = ((alpha * 255f).toInt() shl 24) or rgb

    /**
     * Creates an integer-packed colour value using this color's red, green, and blue values.
     *
     * @return A bitshifted integer containing the RGB values of this color - 0bRRRRRRRRGGGGGGGGBBBBBBBB (0xRRGGBB)
     */
    public open val rgba: Int
        get() = rgb or (alpha shl 24)

    /** The red channel value (0-255). */
    public open val red: Int
        get() = (rgba shr 16) and 0xFF

    /** The green channel value (0-255). */
    public open val green: Int
        get() = (rgba shr 8) and 0xFF

    /** The blue channel value (0-255). */
    public open val blue: Int
        get() = rgba and 0xFF

    /** Whether this color is fully opaque (alpha == 255). */
    public open val isOpaque: Boolean
        get() = alpha == 255

    /** Whether this color is partially transparent (alpha between 1 and 254). */
    public open val isTranslucent: Boolean
        get() = alpha != 255

    /** Whether this color is fully transparent (alpha == 0). */
    public open val isTransparent: Boolean
        get() = alpha == 0

    /** Whether this color is grayscale (red == green == blue). */
    public open val isGrayscale: Boolean
        get() = red == green && green == blue

    /**
     * The name of this color, if available.
     *
     * @see NamedColors
     * @see NamedColors.getColorName
     */
    public val name: String?
        get() = NamedColors.getColorName(this)

    /**
     * Creates a new [Color] using the given HSB values.
     *
     * @param values A triple of (hue, saturation, brightness).
     * @param alpha The alpha channel (0-255).
     */
    public constructor(
        values: Triple<Float, Float, Float>,
        alpha: Int = 255
    ) : this(alpha, values.first, values.second, values.third)

    /**
     * Creates a new [Color] using the given HSB values.
     *
     * @param values A float array of size 3 containing hue, saturation, and brightness.
     * @param alpha The alpha channel (0-255).
     */
    public constructor(
        values: FloatArray,
        alpha: Int = 255
    ) : this(alpha, values[0], values[1], values[2])

    /**
     * Creates a new [Color] from RGB values.
     *
     * @param red The red channel (0-255).
     * @param green The green channel (0-255).
     * @param blue The blue channel (0-255).
     * @param alpha The alpha channel (0-255).
     */
    public constructor(
        red: Int,
        green: Int,
        blue: Int,
        alpha: Int = 255
    ) : this(RGBtoHSB(red, green, blue), alpha)

    /**
     * Mixes this color with [other] by the given [ratio].
     * Ratio is `0.0` = only this color, `1.0` = only other color.
     */
    public fun mix(other: Color, ratio: Float): StaticColor {
        val clampedRatio = ratio.coerceIn(0f, 1f)
        val inverseRatio = 1f - clampedRatio

        val r = (this.red * inverseRatio + other.red * clampedRatio).toInt()
        val g = (this.green * inverseRatio + other.green * clampedRatio).toInt()
        val b = (this.blue * inverseRatio + other.blue * clampedRatio).toInt()
        val a = (this.alpha * inverseRatio + other.alpha * clampedRatio).toInt()

        return Kolor.rgba(r, g, b, a)
    }

    /**
     * Returns a new color lightened by [amount] (0.0 = no change, 1.0 = fully white).
     */
    public fun lighten(amount: Float): StaticColor {
        val clampedAmount = amount.coerceIn(0f, 1f)
        val r = red + ((255 - red) * clampedAmount).toInt()
        val g = green + ((255 - green) * clampedAmount).toInt()
        val b = blue + ((255 - blue) * clampedAmount).toInt()
        return Kolor.rgba(r.coerceAtMost(255), g.coerceAtMost(255), b.coerceAtMost(255), alpha)
    }

    /**
     * Returns a new color darkened by [amount] (0.0 = no change, 1.0 = fully black).
     */
    public fun darken(amount: Float): StaticColor {
        val clampedAmount = amount.coerceIn(0f, 1f)
        val r = (red * (1f - clampedAmount)).toInt()
        val g = (green * (1f - clampedAmount)).toInt()
        val b = (blue * (1f - clampedAmount)).toInt()
        return Kolor.rgba(r, g, b, alpha)
    }

    /**
     * Inverts this color (RGB channels only; alpha remains unchanged).
     */
    public fun invert(): StaticColor {
        return Kolor.rgba(255 - red, 255 - green, 255 - blue, alpha)
    }

    /**
     * Adjusts the brightness by multiplying current brightness by [factor].
     */
    public fun adjustBrightness(factor: Float): StaticColor {
        val hsv = FloatArray(3)
        RGBtoHSB(red, green, blue, hsv)
        hsv[2] = (hsv[2] * factor).coerceIn(0f, 1f)
        val rgb = HSBtoRGB(hsv[0], hsv[1], hsv[2])
        return Kolor.rgba(
            (rgb shr 16) and 0xFF,
            (rgb shr 8) and 0xFF,
            rgb and 0xFF,
            alpha
        )
    }

    /**
     * Rotates the hue by [degrees] (wraps around 0-1 range).
     */
    public fun rotateHue(degrees: Float): StaticColor {
        val hsv = FloatArray(3)
        RGBtoHSB(red, green, blue, hsv)
        hsv[0] = ((hsv[0] + degrees / 360f) % 1f + 1f) % 1f
        val rgb = HSBtoRGB(hsv[0], hsv[1], hsv[2])
        return Kolor.rgba(
            (rgb shr 16) and 0xFF,
            (rgb shr 8) and 0xFF,
            rgb and 0xFF,
            alpha
        )
    }

    /**
     * Returns a grayscale version of this color by setting red, green, and blue channels
     * to their average value while preserving alpha.
     *
     * @return A new [StaticColor] representing the grayscale equivalent of this color.
     */
    public fun grayScale(): StaticColor {
        val gray = ((red + green + blue) / 3)
        return Kolor.rgba(gray, gray, gray, alpha)
    }

    /**
     * Returns a copy of this color with a new alpha value.
     *
     * @param alpha The new alpha channel (0-255).
     * @return A new [StaticColor] with the specified alpha.
     */
    public fun withAlpha(alpha: Int): StaticColor {
        return Kolor.rgba(red, green, blue, alpha)
    }

    /**
     * Returns a copy of this color with a new alpha percentage.
     *
     * @param percent The alpha percentage (0.0 - 1.0).
     * @return A new [StaticColor] with the computed alpha.
     */
    public fun withAlphaPercentage(percent: Float): StaticColor {
        val alpha = (percent * 255).toInt()
        return Kolor.rgba(red, green, blue, alpha)
    }

    /**
     * Returns this color as a hexadecimal string ("#RRGGBB" or "#AARRGGBB" if [includeAlpha] is true).
     *
     * @param includeAlpha Whether to include the alpha channel in the output.
     * @return The hex string representation.
     */
    public fun toHex(includeAlpha: Boolean = false): String {
        val r = red.toString(16).padStart(2, '0').uppercase()
        val g = green.toString(16).padStart(2, '0').uppercase()
        val b = blue.toString(16).padStart(2, '0').uppercase()
        return if (includeAlpha) {
            val a = alpha.toString(16).padStart(2, '0').uppercase()
            "#$a$r$g$b"
        } else {
            "#$r$g$b"
        }
    }

    /**
     * Computes the relative luminance of this color (0.0 - 1.0).
     */
    public fun luminance(): Float {
        fun channel(c: Int): Float {
            val s = c / 255f
            return if (s <= 0.03928f) s / 12.92f else ((s + 0.055f) / 1.055f).pow(2.4f)
        }

        return 0.2126f * channel(red) + 0.7152f * channel(green) + 0.0722f * channel(blue)
    }

    /**
     * Calculates the contrast ratio between this color and [other].
     *
     * @param other The other color.
     * @return Contrast ratio (1.0 = no contrast, up to 21.0 = maximum contrast).
     */
    public fun contrastRatio(other: Color): Float {
        val lum1 = luminance() + 0.05f
        val lum2 = other.luminance() + 0.05f
        return if (lum1 > lum2) lum1 / lum2 else lum2 / lum1
    }

    /**
     * Returns true if this color is visually similar to [other] within [tolerance].
     *
     * @param other The other color.
     * @param tolerance The maximum per-channel difference (0-255).
     */
    public fun isSimilarTo(other: Color, tolerance: Int = 0): Boolean {
        return abs(red - other.red) <= tolerance &&
                abs(green - other.green) <= tolerance &&
                abs(blue - other.blue) <= tolerance &&
                abs(alpha - other.alpha) <= tolerance
    }

    /**
     * Computes Euclidean distance in RGB space to [other].
     */
    public fun distanceTo(other: Color): Float {
        val dr = red - other.red
        val dg = green - other.green
        val db = blue - other.blue
        return sqrt((dr * dr + dg * dg + db * db).toFloat())
    }

    /**
     * Blends this color with [other] at a 50/50 ratio.
     */
    public operator fun plus(other: Color): StaticColor {
        return mix(other, 0.5f)
    }

    /**
     * Performs per-channel multiplication of this color and [other].
     *
     * Equivalent to multiply blend mode (modulation).
     *
     * @param other The other color.
     * @return A new [StaticColor] representing the result.
     */
    public operator fun times(other: Color): StaticColor {
        val r = (this.red * other.red / 255f).toInt().coerceIn(0, 255)
        val g = (this.green * other.green / 255f).toInt().coerceIn(0, 255)
        val b = (this.blue * other.blue / 255f).toInt().coerceIn(0, 255)
        val a = (this.alpha * other.alpha / 255f).toInt().coerceIn(0, 255)
        return Kolor.rgba(r, g, b, a)
    }

    /**
     * Adjusts this color's brightness by multiplying its brightness component by [factor].
     */
    public operator fun times(factor: Float): StaticColor {
        return adjustBrightness(factor)
    }

    /**
     * Inverts this color (RGB channels only; alpha remains unchanged).
     */
    public operator fun unaryMinus(): StaticColor {
        return invert()
    }

    public operator fun component1(): Int {
        return red
    }

    public operator fun component2(): Int {
        return green
    }

    public operator fun component3(): Int {
        return blue
    }

    public operator fun component4(): Int {
        return alpha
    }

}
