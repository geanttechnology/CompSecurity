// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


public final class FlurryAdSize extends Enum
{

    public static final FlurryAdSize BANNER_BOTTOM;
    public static final FlurryAdSize BANNER_TOP;
    public static final FlurryAdSize FULLSCREEN;
    private static final FlurryAdSize b[];
    private int a;

    private FlurryAdSize(String s, int i, int j)
    {
        super(s, i);
        a = j;
    }

    public static FlurryAdSize valueOf(String s)
    {
        return (FlurryAdSize)Enum.valueOf(com/flurry/android/FlurryAdSize, s);
    }

    public static FlurryAdSize[] values()
    {
        return (FlurryAdSize[])b.clone();
    }

    public int getValue()
    {
        return a;
    }

    static 
    {
        BANNER_TOP = new FlurryAdSize("BANNER_TOP", 0, 1);
        BANNER_BOTTOM = new FlurryAdSize("BANNER_BOTTOM", 1, 2);
        FULLSCREEN = new FlurryAdSize("FULLSCREEN", 2, 3);
        b = (new FlurryAdSize[] {
            BANNER_TOP, BANNER_BOTTOM, FULLSCREEN
        });
    }
}
