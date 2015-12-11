// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;


final class MraidOrientation extends Enum
{

    private static final MraidOrientation $VALUES[];
    public static final MraidOrientation LANDSCAPE;
    public static final MraidOrientation NONE;
    public static final MraidOrientation PORTRAIT;
    private final int mActivityInfoOrientation;

    private MraidOrientation(String s, int i, int j)
    {
        super(s, i);
        mActivityInfoOrientation = j;
    }

    public static MraidOrientation valueOf(String s)
    {
        return (MraidOrientation)Enum.valueOf(com/mopub/mraid/MraidOrientation, s);
    }

    public static MraidOrientation[] values()
    {
        return (MraidOrientation[])$VALUES.clone();
    }

    int getActivityInfoOrientation()
    {
        return mActivityInfoOrientation;
    }

    static 
    {
        PORTRAIT = new MraidOrientation("PORTRAIT", 0, 1);
        LANDSCAPE = new MraidOrientation("LANDSCAPE", 1, 0);
        NONE = new MraidOrientation("NONE", 2, -1);
        $VALUES = (new MraidOrientation[] {
            PORTRAIT, LANDSCAPE, NONE
        });
    }
}
