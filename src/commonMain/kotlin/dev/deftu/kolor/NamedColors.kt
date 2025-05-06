package dev.deftu.kolor

import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic
import kotlin.jvm.JvmSynthetic

/**
 * Contains all 147 named CSS colors and provides name-based lookup utilities.
 */
public object NamedColors {

    @JvmSynthetic
    private val colorsByName = mutableMapOf<Color, String>()

    private fun namedColor(name: String, color: Color): Color {
        colorsByName[color] = name.lowercase()
        return color
    }

    @JvmField public val ALICEBLUE: Color            = namedColor("aliceblue", Kolor.parseHex("#F0F8FF"))
    @JvmField public val ANTIQUEWHITE: Color         = namedColor("antiquewhite", Kolor.parseHex("#FAEBD7"))
    @JvmField public val AQUA: Color                 = namedColor("aqua", Kolor.parseHex("#00FFFF"))
    @JvmField public val AQUAMARINE: Color           = namedColor("aquamarine", Kolor.parseHex("#7FFFD4"))
    @JvmField public val AZURE: Color                = namedColor("azure", Kolor.parseHex("#F0FFFF"))
    @JvmField public val BEIGE: Color                = namedColor("beige", Kolor.parseHex("#F5F5DC"))
    @JvmField public val BISQUE: Color               = namedColor("bisque", Kolor.parseHex("#FFE4C4"))
    @JvmField public val BLACK: Color                = namedColor("black", Kolor.parseHex("#000000"))
    @JvmField public val BLANCHEDALMOND: Color       = namedColor("blanchedalmond", Kolor.parseHex("#FFEBCD"))
    @JvmField public val BLUE: Color                 = namedColor("blue", Kolor.parseHex("#0000FF"))
    @JvmField public val BLUEVIOLET: Color           = namedColor("blueviolet", Kolor.parseHex("#8A2BE2"))
    @JvmField public val BROWN: Color                = namedColor("brown", Kolor.parseHex("#A52A2A"))
    @JvmField public val BURLYWOOD: Color            = namedColor("burlywood", Kolor.parseHex("#DEB887"))
    @JvmField public val CADETBLUE: Color            = namedColor("cadetblue", Kolor.parseHex("#5F9EA0"))
    @JvmField public val CHARTREUSE: Color           = namedColor("chartreuse", Kolor.parseHex("#7FFF00"))
    @JvmField public val CHOCOLATE: Color            = namedColor("chocolate", Kolor.parseHex("#D2691E"))
    @JvmField public val CORAL: Color                = namedColor("coral", Kolor.parseHex("#FF7F50"))
    @JvmField public val CORNFLOWERBLUE: Color       = namedColor("cornflowerblue", Kolor.parseHex("#6495ED"))
    @JvmField public val CORNSILK: Color             = namedColor("cornsilk", Kolor.parseHex("#FFF8DC"))
    @JvmField public val CRIMSON: Color              = namedColor("crimson", Kolor.parseHex("#DC143C"))
    @JvmField public val CYAN: Color                 = namedColor("cyan", Kolor.parseHex("#00FFFF"))
    @JvmField public val DARKBLUE: Color             = namedColor("darkblue", Kolor.parseHex("#00008B"))
    @JvmField public val DARKCYAN: Color             = namedColor("darkcyan", Kolor.parseHex("#008B8B"))
    @JvmField public val DARKGOLDENROD: Color        = namedColor("darkgoldenrod", Kolor.parseHex("#B8860B"))
    @JvmField public val DARKGRAY: Color             = namedColor("darkgray", Kolor.parseHex("#A9A9A9"))
    @JvmField public val DARKGREEN: Color            = namedColor("darkgreen", Kolor.parseHex("#006400"))
    @JvmField public val DARKGREY: Color             = namedColor("darkgrey", Kolor.parseHex("#A9A9A9"))
    @JvmField public val DARKKHAKI: Color            = namedColor("darkkhaki", Kolor.parseHex("#BDB76B"))
    @JvmField public val DARKMAGENTA: Color          = namedColor("darkmagenta", Kolor.parseHex("#8B008B"))
    @JvmField public val DARKOLIVEGREEN: Color       = namedColor("darkolivegreen", Kolor.parseHex("#556B2F"))
    @JvmField public val DARKORANGE: Color           = namedColor("darkorange", Kolor.parseHex("#FF8C00"))
    @JvmField public val DARKORCHID: Color           = namedColor("darkorchid", Kolor.parseHex("#9932CC"))
    @JvmField public val DARKRED: Color              = namedColor("darkred", Kolor.parseHex("#8B0000"))
    @JvmField public val DARKSALMON: Color           = namedColor("darksalmon", Kolor.parseHex("#E9967A"))
    @JvmField public val DARKSEAGREEN: Color         = namedColor("darkseagreen", Kolor.parseHex("#8FBC8F"))
    @JvmField public val DARKSLATEBLUE: Color        = namedColor("darkslateblue", Kolor.parseHex("#483D8B"))
    @JvmField public val DARKSLATEGRAY: Color        = namedColor("darkslategray", Kolor.parseHex("#2F4F4F"))
    @JvmField public val DARKSLATEGREY: Color        = namedColor("darkslategrey", Kolor.parseHex("#2F4F4F"))
    @JvmField public val DARKTURQUOISE: Color        = namedColor("darkturquoise", Kolor.parseHex("#00CED1"))
    @JvmField public val DARKVIOLET: Color           = namedColor("darkviolet", Kolor.parseHex("#9400D3"))
    @JvmField public val DEEPPINK: Color             = namedColor("deeppink", Kolor.parseHex("#FF1493"))
    @JvmField public val DEEPSKYBLUE: Color          = namedColor("deepskyblue", Kolor.parseHex("#00BFFF"))
    @JvmField public val DIMGRAY: Color              = namedColor("dimgray", Kolor.parseHex("#696969"))
    @JvmField public val DIMGREY: Color              = namedColor("dimgrey", Kolor.parseHex("#696969"))
    @JvmField public val DODGERBLUE: Color           = namedColor("dodgerblue", Kolor.parseHex("#1E90FF"))
    @JvmField public val FIREBRICK: Color            = namedColor("firebrick", Kolor.parseHex("#B22222"))
    @JvmField public val FLORALWHITE: Color          = namedColor("floralwhite", Kolor.parseHex("#FFFAF0"))
    @JvmField public val FORESTGREEN: Color          = namedColor("forestgreen", Kolor.parseHex("#228B22"))
    @JvmField public val FUCHSIA: Color              = namedColor("fuchsia", Kolor.parseHex("#FF00FF"))
    @JvmField public val GAINSBORO: Color            = namedColor("gainsboro", Kolor.parseHex("#DCDCDC"))
    @JvmField public val GHOSTWHITE: Color           = namedColor("ghostwhite", Kolor.parseHex("#F8F8FF"))
    @JvmField public val GOLD: Color                 = namedColor("gold", Kolor.parseHex("#FFD700"))
    @JvmField public val GOLDENROD: Color            = namedColor("goldenrod", Kolor.parseHex("#DAA520"))
    @JvmField public val GRAY: Color                 = namedColor("gray", Kolor.parseHex("#808080"))
    @JvmField public val GREEN: Color                = namedColor("green", Kolor.parseHex("#008000"))
    @JvmField public val GREENYELLOW: Color          = namedColor("greenyellow", Kolor.parseHex("#ADFF2F"))
    @JvmField public val GREY: Color                 = namedColor("grey", Kolor.parseHex("#808080"))
    @JvmField public val HONEYDEW: Color             = namedColor("honeydew", Kolor.parseHex("#F0FFF0"))
    @JvmField public val HOTPINK: Color              = namedColor("hotpink", Kolor.parseHex("#FF69B4"))
    @JvmField public val INDIANRED: Color            = namedColor("indianred", Kolor.parseHex("#CD5C5C"))
    @JvmField public val INDIGO: Color               = namedColor("indigo", Kolor.parseHex("#4B0082"))
    @JvmField public val IVORY: Color                = namedColor("ivory", Kolor.parseHex("#FFFFF0"))
    @JvmField public val KHAKI: Color                = namedColor("khaki", Kolor.parseHex("#F0E68C"))
    @JvmField public val LAVENDER: Color             = namedColor("lavender", Kolor.parseHex("#E6E6FA"))
    @JvmField public val LAVENDERBLUSH: Color        = namedColor("lavenderblush", Kolor.parseHex("#FFF0F5"))
    @JvmField public val LAWNGREEN: Color            = namedColor("lawngreen", Kolor.parseHex("#7CFC00"))
    @JvmField public val LEMONCHIFFON: Color         = namedColor("lemonchiffon", Kolor.parseHex("#FFFACD"))
    @JvmField public val LIGHTBLUE: Color            = namedColor("lightblue", Kolor.parseHex("#ADD8E6"))
    @JvmField public val LIGHTCORAL: Color           = namedColor("lightcoral", Kolor.parseHex("#F08080"))
    @JvmField public val LIGHTCYAN: Color            = namedColor("lightcyan", Kolor.parseHex("#E0FFFF"))
    @JvmField public val LIGHTGOLDENRODYELLOW: Color = namedColor("lightgoldenrodyellow", Kolor.parseHex("#FAFAD2"))
    @JvmField public val LIGHTGRAY: Color            = namedColor("lightgray", Kolor.parseHex("#D3D3D3"))
    @JvmField public val LIGHTGREEN: Color           = namedColor("lightgreen", Kolor.parseHex("#90EE90"))
    @JvmField public val LIGHTGREY: Color            = namedColor("lightgrey", Kolor.parseHex("#D3D3D3"))
    @JvmField public val LIGHTPINK: Color            = namedColor("lightpink", Kolor.parseHex("#FFB6C1"))
    @JvmField public val LIGHTSALMON: Color          = namedColor("lightsalmon", Kolor.parseHex("#FFA07A"))
    @JvmField public val LIGHTSEAGREEN: Color        = namedColor("lightseagreen", Kolor.parseHex("#20B2AA"))
    @JvmField public val LIGHTSKYBLUE: Color         = namedColor("lightskyblue", Kolor.parseHex("#87CEFA"))
    @JvmField public val LIGHTSLATEGRAY: Color       = namedColor("lightslategray", Kolor.parseHex("#778899"))
    @JvmField public val LIGHTSLATEGREY: Color       = namedColor("lightslategrey", Kolor.parseHex("#778899"))
    @JvmField public val LIGHTSTEELBLUE: Color       = namedColor("lightsteelblue", Kolor.parseHex("#B0C4DE"))
    @JvmField public val LIGHTYELLOW: Color          = namedColor("lightyellow", Kolor.parseHex("#FFFFE0"))
    @JvmField public val LIME: Color                 = namedColor("lime", Kolor.parseHex("#00FF00"))
    @JvmField public val LIMEGREEN: Color            = namedColor("limegreen", Kolor.parseHex("#32CD32"))
    @JvmField public val LINEN: Color                = namedColor("linen", Kolor.parseHex("#FAF0E6"))
    @JvmField public val MAGENTA: Color              = namedColor("magenta", Kolor.parseHex("#FF00FF"))
    @JvmField public val MAROON: Color               = namedColor("maroon", Kolor.parseHex("#800000"))
    @JvmField public val MEDIUMAQUAMARINE: Color     = namedColor("mediumaquamarine", Kolor.parseHex("#66CDAA"))
    @JvmField public val MEDIUMBLUE: Color           = namedColor("mediumblue", Kolor.parseHex("#0000CD"))
    @JvmField public val MEDIUMORCHID: Color         = namedColor("mediumorchid", Kolor.parseHex("#BA55D3"))
    @JvmField public val MEDIUMPURPLE: Color         = namedColor("mediumpurple", Kolor.parseHex("#9370DB"))
    @JvmField public val MEDIUMSEAGREEN: Color       = namedColor("mediumseagreen", Kolor.parseHex("#3CB371"))
    @JvmField public val MEDIUMSLATEBLUE: Color      = namedColor("mediumslateblue", Kolor.parseHex("#7B68EE"))
    @JvmField public val MEDIUMSPRINGGREEN: Color    = namedColor("mediumspringgreen", Kolor.parseHex("#00FA9A"))
    @JvmField public val MEDIUMTURQUOISE: Color      = namedColor("mediumturquoise", Kolor.parseHex("#48D1CC"))
    @JvmField public val MEDIUMVIOLETRED: Color      = namedColor("mediumvioletred", Kolor.parseHex("#C71585"))
    @JvmField public val MIDNIGHTBLUE: Color         = namedColor("midnightblue", Kolor.parseHex("#191970"))
    @JvmField public val MINTCREAM: Color            = namedColor("mintcream", Kolor.parseHex("#F5FFFA"))
    @JvmField public val MISTYROSE: Color            = namedColor("mistyrose", Kolor.parseHex("#FFE4E1"))
    @JvmField public val MOCCASIN: Color             = namedColor("moccasin", Kolor.parseHex("#FFE4B5"))
    @JvmField public val NAVAJOWHITE: Color          = namedColor("navajowhite", Kolor.parseHex("#FFDEAD"))
    @JvmField public val NAVY: Color                 = namedColor("navy", Kolor.parseHex("#000080"))
    @JvmField public val OLDLACE: Color              = namedColor("oldlace", Kolor.parseHex("#FDF5E6"))
    @JvmField public val OLIVE: Color                = namedColor("olive", Kolor.parseHex("#808000"))
    @JvmField public val OLIVEDRAB: Color            = namedColor("olivedrab", Kolor.parseHex("#6B8E23"))
    @JvmField public val ORANGE: Color               = namedColor("orange", Kolor.parseHex("#FFA500"))
    @JvmField public val ORANGERED: Color            = namedColor("orangered", Kolor.parseHex("#FF4500"))
    @JvmField public val ORCHID: Color               = namedColor("orchid", Kolor.parseHex("#DA70D6"))
    @JvmField public val PALEGOLDENROD: Color        = namedColor("palegoldenrod", Kolor.parseHex("#EEE8AA"))
    @JvmField public val PALEGREEN: Color            = namedColor("palegreen", Kolor.parseHex("#98FB98"))
    @JvmField public val PALETURQUOISE: Color        = namedColor("paleturquoise", Kolor.parseHex("#AFEEEE"))
    @JvmField public val PALEVIOLETRED: Color        = namedColor("palevioletred", Kolor.parseHex("#DB7093"))
    @JvmField public val PAPAYAWHIP: Color           = namedColor("papayawhip", Kolor.parseHex("#FFEFD5"))
    @JvmField public val PEACHPUFF: Color            = namedColor("peachpuff", Kolor.parseHex("#FFDAB9"))
    @JvmField public val PERU: Color                 = namedColor("peru", Kolor.parseHex("#CD853F"))
    @JvmField public val PINK: Color                 = namedColor("pink", Kolor.parseHex("#FFC0CB"))
    @JvmField public val PLUM: Color                 = namedColor("plum", Kolor.parseHex("#DDA0DD"))
    @JvmField public val POWDERBLUE: Color           = namedColor("powderblue", Kolor.parseHex("#B0E0E6"))
    @JvmField public val PURPLE: Color               = namedColor("purple", Kolor.parseHex("#800080"))
    @JvmField public val REBECCAPURPLE: Color        = namedColor("rebeccapurple", Kolor.parseHex("#663399"))
    @JvmField public val RED: Color                  = namedColor("red", Kolor.parseHex("#FF0000"))
    @JvmField public val ROSYBROWN: Color            = namedColor("rosybrown", Kolor.parseHex("#BC8F8F"))
    @JvmField public val ROYALBLUE: Color            = namedColor("royalblue", Kolor.parseHex("#4169E1"))
    @JvmField public val SADDLEBROWN: Color          = namedColor("saddlebrown", Kolor.parseHex("#8B4513"))
    @JvmField public val SALMON: Color               = namedColor("salmon", Kolor.parseHex("#FA8072"))
    @JvmField public val SANDYBROWN: Color           = namedColor("sandybrown", Kolor.parseHex("#F4A460"))
    @JvmField public val SEAGREEN: Color             = namedColor("seagreen", Kolor.parseHex("#2E8B57"))
    @JvmField public val SEASHELL: Color             = namedColor("seashell", Kolor.parseHex("#FFF5EE"))
    @JvmField public val SIENNA: Color               = namedColor("sienna", Kolor.parseHex("#A0522D"))
    @JvmField public val SILVER: Color               = namedColor("silver", Kolor.parseHex("#C0C0C0"))
    @JvmField public val SKYBLUE: Color              = namedColor("skyblue", Kolor.parseHex("#87CEEB"))
    @JvmField public val SLATEBLUE: Color            = namedColor("slateblue", Kolor.parseHex("#6A5ACD"))
    @JvmField public val SLATEGRAY: Color            = namedColor("slategray", Kolor.parseHex("#708090"))
    @JvmField public val SLATEGREY: Color            = namedColor("slategrey", Kolor.parseHex("#708090"))
    @JvmField public val SNOW: Color                 = namedColor("snow", Kolor.parseHex("#FFFAFA"))
    @JvmField public val SPRINGGREEN: Color          = namedColor("springgreen", Kolor.parseHex("#00FF7F"))
    @JvmField public val STEELBLUE: Color            = namedColor("steelblue", Kolor.parseHex("#4682B4"))
    @JvmField public val TAN: Color                  = namedColor("tan", Kolor.parseHex("#D2B48C"))
    @JvmField public val TEAL: Color                 = namedColor("teal", Kolor.parseHex("#008080"))
    @JvmField public val THISTLE: Color              = namedColor("thistle", Kolor.parseHex("#D8BFD8"))
    @JvmField public val TOMATO: Color               = namedColor("tomato", Kolor.parseHex("#FF6347"))
    @JvmField public val TURQUOISE: Color            = namedColor("turquoise", Kolor.parseHex("#40E0D0"))
    @JvmField public val VIOLET: Color               = namedColor("violet", Kolor.parseHex("#EE82EE"))
    @JvmField public val WHEAT: Color                = namedColor("wheat", Kolor.parseHex("#F5DEB3"))
    @JvmField public val WHITE: Color                = namedColor("white", Kolor.parseHex("#FFFFFF"))
    @JvmField public val WHITESMOKE: Color           = namedColor("whitesmoke", Kolor.parseHex("#F5F5F5"))
    @JvmField public val YELLOW: Color               = namedColor("yellow", Kolor.parseHex("#FFFF00"))
    @JvmField public val YELLOWGREEN: Color          = namedColor("yellowgreen", Kolor.parseHex("#9ACD32"))

    /**
     * Returns the registered name for [color], or `null` if not found.
     */
    @JvmStatic
    public fun getColorName(color: Color): String? {
        return colorsByName[color]
    }

    /**
     * Looks up a named color by [name] (case-insensitive), or `null` if not registered.
     */
    @JvmStatic
    public fun getColorByName(name: String): Color? {
        return colorsByName.entries.firstOrNull { it.value.equals(name, ignoreCase = true) }?.key
    }

    /**
     * Returns true if [name] is a registered named color.
     */
    @JvmStatic
    public operator fun contains(name: String): Boolean {
        return colorsByName.values.any { it.equals(name, ignoreCase = true) }
    }

    /**
     * Returns true if [color] is a registered named color.
     */
    @JvmStatic
    public operator fun contains(color: Color): Boolean {
        return colorsByName.containsKey(color)
    }

    /**
     * Returns the named color closest to [target], based on Euclidean RGB distance.
     */
    @JvmStatic
    public fun findClosestNamedColor(target: Color): Color {
        return colorsByName.keys.minByOrNull { color ->
            val dr = color.red - target.red
            val dg = color.green - target.green
            val db = color.blue - target.blue
            dr * dr + dg * dg + db * db
        }!!
    }

}
