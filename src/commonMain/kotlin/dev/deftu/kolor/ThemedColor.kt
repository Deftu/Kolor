package dev.deftu.kolor

import kotlin.jvm.JvmStatic

public class ThemedColor<T>(
    private val key: T,
    private val resolver: (T) -> Color,
    alpha: Int = 255
) : Color(alpha) {

    public companion object {

        @JvmStatic
        public fun named(key: String, resolver: (String) -> Color): ThemedColor<String> {
            return ThemedColor(key, resolver)
        }

    }

    public constructor(
        key: T,
        resolver: (T) -> Color,
        useResolvedAlpha: Boolean
    ) : this(key, resolver, if (useResolvedAlpha) resolver(key).alpha else 255)

    public val backedColor: Color
        get() = resolver(key)

    override val hue: Float
        get() = backedColor.hue

    override val saturation: Float
        get() = backedColor.saturation

    override val brightness: Float
        get() = backedColor.brightness

}
