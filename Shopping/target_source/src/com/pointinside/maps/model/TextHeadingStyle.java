// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps.model;

import android.graphics.Color;

public class TextHeadingStyle
{

    public static final String DEFAULT_FONT_NAME = "SourceSansPro-Semibold.otf";
    static final float DEFAULT_FONT_SIZE = 35F;
    static final float DEFAULT_OUTLINE_WIDTH = 0.039F;
    private String mFontName;
    private int mOutlineColor;
    private float mOutlineWidth;
    private float mSize;
    private int mTextColor;

    public TextHeadingStyle()
    {
        mSize = 35F;
        mFontName = "SourceSansPro-Semibold.otf";
        mTextColor = 0xff000000;
        mOutlineColor = Color.argb(127, 255, 255, 255);
        mOutlineWidth = 0.039F;
    }

    public TextHeadingStyle(TextHeadingStyle textheadingstyle)
    {
        mFontName = textheadingstyle.mFontName;
        mSize = textheadingstyle.getSize();
        mTextColor = textheadingstyle.mTextColor;
        mOutlineWidth = textheadingstyle.mOutlineWidth;
        mOutlineColor = textheadingstyle.mOutlineColor;
    }

    public String getFontName()
    {
        return mFontName;
    }

    public int getOutlineColor()
    {
        return mOutlineColor;
    }

    public float getOutlineWidth()
    {
        return mOutlineWidth;
    }

    public float getSize()
    {
        return mSize;
    }

    public int getTextColor()
    {
        return mTextColor;
    }

    public TextHeadingStyle setFontName(String s)
    {
        mFontName = s;
        return this;
    }

    public TextHeadingStyle setOutlineColor(int i)
    {
        mOutlineColor = i;
        return this;
    }

    public TextHeadingStyle setOutlineWidth(float f)
    {
        mOutlineWidth = f;
        return this;
    }

    public TextHeadingStyle setSize(float f)
    {
        mSize = f;
        return this;
    }

    public TextHeadingStyle setTextColor(int i)
    {
        mTextColor = i;
        return this;
    }
}
