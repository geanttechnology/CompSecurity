// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.graphics.Typeface;

public class CaptionStyle
{

    public static final int EDGE_TYPE_DEPRESSED = 3;
    public static final int EDGE_TYPE_DROP_SHADOW = 1;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_RAISED = 2;
    public static final int EDGE_TYPE_UNIFORM = 4;
    public static final int TEXT_SIZE_LARGE = 150;
    public static final int TEXT_SIZE_NORMAL = 100;
    public static final int TEXT_SIZE_SMALL = 75;
    public static final int TEXT_SIZE_XLARGE = 200;
    public static final int TEXT_SIZE_XSMALL = 50;
    protected int _backgroundColor;
    protected int _edgeType;
    protected int _textColor;
    protected int _textSize;
    protected Typeface _typeface;
    protected int _windowColor;

    public CaptionStyle()
    {
        _textSize = 100;
        _textColor = -1;
        _backgroundColor = 0xff000000;
        _typeface = Typeface.MONOSPACE;
        _edgeType = 0;
        _windowColor = 0;
    }

    public int getBackgroundColor()
    {
        return _backgroundColor;
    }

    public int getEdgeType()
    {
        return _edgeType;
    }

    public int getTextColor()
    {
        return _textColor;
    }

    public int getTextSize()
    {
        return _textSize;
    }

    public Typeface getTypeface()
    {
        return _typeface;
    }

    public int getWindowColor()
    {
        return _windowColor;
    }

    public void setBackgroundColor(int i)
    {
        _backgroundColor = i;
    }

    public void setEdgeType(int i)
    {
        _edgeType = i;
    }

    public void setTextColor(int i)
    {
        _textColor = i;
    }

    public void setTextSize(int i)
    {
        if (i < 50 || i > 200)
        {
            return;
        } else
        {
            _textSize = i;
            return;
        }
    }

    public void setTypeface(Typeface typeface)
    {
        _typeface = typeface;
    }

    public void setWindowColor(int i)
    {
        _windowColor = i;
    }
}
