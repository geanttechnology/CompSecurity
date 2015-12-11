// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.impl.ads.protocol.v13;


public final class ScreenOrientationType extends Enum
{

    private static final ScreenOrientationType $VALUES[];
    public static final ScreenOrientationType LANDSCAPE;
    public static final ScreenOrientationType PORTRAIT;
    public static final ScreenOrientationType UNKNOWN;

    private ScreenOrientationType(String s, int i)
    {
        super(s, i);
    }

    public static ScreenOrientationType valueOf(String s)
    {
        return (ScreenOrientationType)Enum.valueOf(com/flurry/android/impl/ads/protocol/v13/ScreenOrientationType, s);
    }

    public static ScreenOrientationType[] values()
    {
        return (ScreenOrientationType[])$VALUES.clone();
    }

    static 
    {
        PORTRAIT = new ScreenOrientationType("PORTRAIT", 0);
        LANDSCAPE = new ScreenOrientationType("LANDSCAPE", 1);
        UNKNOWN = new ScreenOrientationType("UNKNOWN", 2);
        $VALUES = (new ScreenOrientationType[] {
            PORTRAIT, LANDSCAPE, UNKNOWN
        });
    }
}
