// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.util;


public class ClosedCaptionsFormat
{
    public static final class Color extends Enum
    {

        private static final Color $VALUES[];
        public static final Color BLACK;
        public static final Color BLUE;
        public static final Color BRIGHT_BLUE;
        public static final Color BRIGHT_CYAN;
        public static final Color BRIGHT_GREEN;
        public static final Color BRIGHT_MAGENTA;
        public static final Color BRIGHT_RED;
        public static final Color BRIGHT_WHITE;
        public static final Color BRIGHT_YELLOW;
        public static final Color CYAN;
        public static final Color DARK_BLUE;
        public static final Color DARK_CYAN;
        public static final Color DARK_GREEN;
        public static final Color DARK_MAGENTA;
        public static final Color DARK_RED;
        public static final Color DARK_YELLOW;
        public static final Color DEFAULT;
        public static final Color GRAY;
        public static final Color GREEN;
        public static final Color MAGENTA;
        public static final Color RED;
        public static final Color WHITE;
        public static final Color YELLOW;

        public static Color valueOf(String s)
        {
            return (Color)Enum.valueOf(com/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Color, s);
        }

        public static Color valueOfOrdinal(int i)
        {
            return values()[i];
        }

        public static Color[] values()
        {
            return (Color[])$VALUES.clone();
        }

        com.adobe.mediacore.TextFormat.Color textFormatValue()
        {
            return com.adobe.mediacore.TextFormat.Color.valueOf(name());
        }

        static 
        {
            DEFAULT = new Color("DEFAULT", 0);
            BLACK = new Color("BLACK", 1);
            GRAY = new Color("GRAY", 2);
            WHITE = new Color("WHITE", 3);
            BRIGHT_WHITE = new Color("BRIGHT_WHITE", 4);
            DARK_RED = new Color("DARK_RED", 5);
            RED = new Color("RED", 6);
            BRIGHT_RED = new Color("BRIGHT_RED", 7);
            DARK_GREEN = new Color("DARK_GREEN", 8);
            GREEN = new Color("GREEN", 9);
            BRIGHT_GREEN = new Color("BRIGHT_GREEN", 10);
            DARK_BLUE = new Color("DARK_BLUE", 11);
            BLUE = new Color("BLUE", 12);
            BRIGHT_BLUE = new Color("BRIGHT_BLUE", 13);
            DARK_YELLOW = new Color("DARK_YELLOW", 14);
            YELLOW = new Color("YELLOW", 15);
            BRIGHT_YELLOW = new Color("BRIGHT_YELLOW", 16);
            DARK_MAGENTA = new Color("DARK_MAGENTA", 17);
            MAGENTA = new Color("MAGENTA", 18);
            BRIGHT_MAGENTA = new Color("BRIGHT_MAGENTA", 19);
            DARK_CYAN = new Color("DARK_CYAN", 20);
            CYAN = new Color("CYAN", 21);
            BRIGHT_CYAN = new Color("BRIGHT_CYAN", 22);
            $VALUES = (new Color[] {
                DEFAULT, BLACK, GRAY, WHITE, BRIGHT_WHITE, DARK_RED, RED, BRIGHT_RED, DARK_GREEN, GREEN, 
                BRIGHT_GREEN, DARK_BLUE, BLUE, BRIGHT_BLUE, DARK_YELLOW, YELLOW, BRIGHT_YELLOW, DARK_MAGENTA, MAGENTA, BRIGHT_MAGENTA, 
                DARK_CYAN, CYAN, BRIGHT_CYAN
            });
        }

        private Color(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Font extends Enum
    {

        private static final Font $VALUES[];
        public static final Font CASUAL;
        public static final Font CURSIVE;
        public static final Font DEFAULT;
        public static final Font MONOSPACED_WITH_SERIFS;
        public static final Font MONSPACED_WITHOUT_SERIFS;
        public static final Font PROPORTIONAL_WITHOUT_SERIFS;
        public static final Font PROPORTIONAL_WITH_SERIFS;
        public static final Font SMALL_CAPITALS;

        public static Font valueOf(String s)
        {
            return (Font)Enum.valueOf(com/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Font, s);
        }

        public static Font valueOfOrdinal(int i)
        {
            return values()[i];
        }

        public static Font[] values()
        {
            return (Font[])$VALUES.clone();
        }

        com.adobe.mediacore.TextFormat.Font textFormatValue()
        {
            return com.adobe.mediacore.TextFormat.Font.valueOf(name());
        }

        static 
        {
            DEFAULT = new Font("DEFAULT", 0);
            MONOSPACED_WITH_SERIFS = new Font("MONOSPACED_WITH_SERIFS", 1);
            PROPORTIONAL_WITH_SERIFS = new Font("PROPORTIONAL_WITH_SERIFS", 2);
            MONSPACED_WITHOUT_SERIFS = new Font("MONSPACED_WITHOUT_SERIFS", 3);
            PROPORTIONAL_WITHOUT_SERIFS = new Font("PROPORTIONAL_WITHOUT_SERIFS", 4);
            CASUAL = new Font("CASUAL", 5);
            CURSIVE = new Font("CURSIVE", 6);
            SMALL_CAPITALS = new Font("SMALL_CAPITALS", 7);
            $VALUES = (new Font[] {
                DEFAULT, MONOSPACED_WITH_SERIFS, PROPORTIONAL_WITH_SERIFS, MONSPACED_WITHOUT_SERIFS, PROPORTIONAL_WITHOUT_SERIFS, CASUAL, CURSIVE, SMALL_CAPITALS
            });
        }

        private Font(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class FontEdge extends Enum
    {

        private static final FontEdge $VALUES[];
        public static final FontEdge DEFAULT;
        public static final FontEdge DEPRESSED;
        public static final FontEdge DROP_SHADOW_LEFT;
        public static final FontEdge DROP_SHADOW_RIGHT;
        public static final FontEdge NONE;
        public static final FontEdge RAISED;
        public static final FontEdge UNIFORM;

        public static FontEdge valueOf(String s)
        {
            return (FontEdge)Enum.valueOf(com/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge, s);
        }

        public static FontEdge valueOfOrdinal(int i)
        {
            return values()[i];
        }

        public static FontEdge[] values()
        {
            return (FontEdge[])$VALUES.clone();
        }

        com.adobe.mediacore.TextFormat.FontEdge textFormatValue()
        {
            return com.adobe.mediacore.TextFormat.FontEdge.valueOf(name());
        }

        static 
        {
            DEFAULT = new FontEdge("DEFAULT", 0);
            NONE = new FontEdge("NONE", 1);
            RAISED = new FontEdge("RAISED", 2);
            DEPRESSED = new FontEdge("DEPRESSED", 3);
            UNIFORM = new FontEdge("UNIFORM", 4);
            DROP_SHADOW_LEFT = new FontEdge("DROP_SHADOW_LEFT", 5);
            DROP_SHADOW_RIGHT = new FontEdge("DROP_SHADOW_RIGHT", 6);
            $VALUES = (new FontEdge[] {
                DEFAULT, NONE, RAISED, DEPRESSED, UNIFORM, DROP_SHADOW_LEFT, DROP_SHADOW_RIGHT
            });
        }

        private FontEdge(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class Size extends Enum
    {

        private static final Size $VALUES[];
        public static final Size DEFAULT;
        public static final Size LARGE;
        public static final Size MEDIUM;
        public static final Size SMALL;

        public static Size valueOf(String s)
        {
            return (Size)Enum.valueOf(com/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$Size, s);
        }

        public static Size valueOfOrdinal(int i)
        {
            return values()[i];
        }

        public static Size[] values()
        {
            return (Size[])$VALUES.clone();
        }

        com.adobe.mediacore.TextFormat.Size textFormatValue()
        {
            return com.adobe.mediacore.TextFormat.Size.valueOf(name());
        }

        static 
        {
            DEFAULT = new Size("DEFAULT", 0);
            SMALL = new Size("SMALL", 1);
            MEDIUM = new Size("MEDIUM", 2);
            LARGE = new Size("LARGE", 3);
            $VALUES = (new Size[] {
                DEFAULT, SMALL, MEDIUM, LARGE
            });
        }

        private Size(String s, int i)
        {
            super(s, i);
        }
    }


    private Color backgroundColor;
    private int backgroundOpacity;
    private Color edgeColor;
    private Color fillColor;
    private int fillOpacity;
    private Font font;
    private Color fontColor;
    private FontEdge fontEdge;
    private int fontOpacity;
    private Size fontSize;

    public ClosedCaptionsFormat()
    {
        fontColor = Color.DEFAULT;
        backgroundColor = Color.DEFAULT;
        fillColor = Color.DEFAULT;
        edgeColor = Color.DEFAULT;
        fontSize = Size.DEFAULT;
        fontEdge = FontEdge.DEFAULT;
        font = Font.DEFAULT;
        fontOpacity = -1;
        backgroundOpacity = -1;
        fillOpacity = -1;
    }

    public Color getBackgroundColor()
    {
        return backgroundColor;
    }

    public int getBackgroundOpacity()
    {
        return backgroundOpacity;
    }

    public Color getEdgeColor()
    {
        return edgeColor;
    }

    public Color getFillColor()
    {
        return fillColor;
    }

    public int getFillOpacity()
    {
        return fillOpacity;
    }

    public Font getFont()
    {
        return font;
    }

    public Color getFontColor()
    {
        return fontColor;
    }

    public FontEdge getFontEdge()
    {
        return fontEdge;
    }

    public int getFontOpacity()
    {
        return fontOpacity;
    }

    public Size getFontSize()
    {
        return fontSize;
    }

    public void setBackgroundColor(Color color)
    {
        backgroundColor = color;
    }

    public void setBackgroundOpacity(int i)
    {
        backgroundOpacity = i;
    }

    public void setEdgeColor(Color color)
    {
        edgeColor = color;
    }

    public void setFillColor(Color color)
    {
        fillColor = color;
    }

    public void setFillOpacity(int i)
    {
        fillOpacity = i;
    }

    public void setFont(Font font1)
    {
        font = font1;
    }

    public void setFontColor(Color color)
    {
        fontColor = color;
    }

    public void setFontEdge(FontEdge fontedge)
    {
        fontEdge = fontedge;
    }

    public void setFontOpacity(int i)
    {
        fontOpacity = i;
    }

    public void setFontSize(Size size)
    {
        fontSize = size;
    }
}
