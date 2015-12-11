// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.graphics.Typeface;

public class VPCaptionStyle
{
    public static final class EdgeType extends Enum
    {

        private static final EdgeType $VALUES[];
        public static final EdgeType EDGE_TYPE_DROP_SHADOW;
        public static final EdgeType EDGE_TYPE_NONE;

        public static EdgeType valueOf(String s)
        {
            return (EdgeType)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType, s);
        }

        public static EdgeType[] values()
        {
            return (EdgeType[])$VALUES.clone();
        }

        static 
        {
            EDGE_TYPE_NONE = new EdgeType("EDGE_TYPE_NONE", 0);
            EDGE_TYPE_DROP_SHADOW = new EdgeType("EDGE_TYPE_DROP_SHADOW", 1);
            $VALUES = (new EdgeType[] {
                EDGE_TYPE_NONE, EDGE_TYPE_DROP_SHADOW
            });
        }

        private EdgeType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class FontSize extends Enum
    {

        private static final FontSize $VALUES[];
        public static final FontSize TEXT_SIZE_LARGE;
        public static final FontSize TEXT_SIZE_NORMAL;
        public static final FontSize TEXT_SIZE_SMALL;
        public static final FontSize TEXT_SIZE_XLARGE;
        public static final FontSize TEXT_SIZE_XSMALL;
        private int size;

        public static FontSize valueOf(String s)
        {
            return (FontSize)Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize, s);
        }

        public static FontSize[] values()
        {
            return (FontSize[])$VALUES.clone();
        }

        static 
        {
            TEXT_SIZE_XSMALL = new FontSize("TEXT_SIZE_XSMALL", 0, 50);
            TEXT_SIZE_SMALL = new FontSize("TEXT_SIZE_SMALL", 1, 75);
            TEXT_SIZE_NORMAL = new FontSize("TEXT_SIZE_NORMAL", 2, 100);
            TEXT_SIZE_LARGE = new FontSize("TEXT_SIZE_LARGE", 3, 150);
            TEXT_SIZE_XLARGE = new FontSize("TEXT_SIZE_XLARGE", 4, 200);
            $VALUES = (new FontSize[] {
                TEXT_SIZE_XSMALL, TEXT_SIZE_SMALL, TEXT_SIZE_NORMAL, TEXT_SIZE_LARGE, TEXT_SIZE_XLARGE
            });
        }

        private FontSize(String s, int i, int j)
        {
            super(s, i);
            size = j;
        }
    }


    private int backgroundColor;
    private int edgeType;
    private int textColor;
    private int textSize;
    private Typeface typeFace;

    public VPCaptionStyle()
    {
        setTextSize(100);
        setBackgroundColor(0xff000000);
        setTextColor(-1);
        setTypeFace(Typeface.MONOSPACE);
        setEdgeType(EdgeType.EDGE_TYPE_NONE.ordinal());
    }

    public int getBackgroundColor()
    {
        return backgroundColor;
    }

    public int getEdgeType()
    {
        return edgeType;
    }

    public int getTextColor()
    {
        return textColor;
    }

    public int getTextSize()
    {
        return textSize;
    }

    public Typeface getTypeFace()
    {
        return typeFace;
    }

    public void setBackgroundColor(int i)
    {
        backgroundColor = i;
    }

    public void setEdgeType(int i)
    {
        edgeType = i;
    }

    public void setTextColor(int i)
    {
        textColor = i;
    }

    public void setTextSize(int i)
    {
        if (i < 50 || i > 200)
        {
            return;
        } else
        {
            textSize = i;
            return;
        }
    }

    public void setTypeFace(Typeface typeface)
    {
        typeFace = typeface;
    }
}
