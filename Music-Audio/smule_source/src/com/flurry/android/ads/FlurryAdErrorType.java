// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.ads;


public final class FlurryAdErrorType extends Enum
{

    public static final FlurryAdErrorType CLICK;
    public static final FlurryAdErrorType FETCH;
    public static final FlurryAdErrorType RENDER;
    private static final FlurryAdErrorType a[];

    private FlurryAdErrorType(String s, int i)
    {
        super(s, i);
    }

    public static FlurryAdErrorType valueOf(String s)
    {
        return (FlurryAdErrorType)Enum.valueOf(com/flurry/android/ads/FlurryAdErrorType, s);
    }

    public static FlurryAdErrorType[] values()
    {
        return (FlurryAdErrorType[])a.clone();
    }

    static 
    {
        FETCH = new FlurryAdErrorType("FETCH", 0);
        RENDER = new FlurryAdErrorType("RENDER", 1);
        CLICK = new FlurryAdErrorType("CLICK", 2);
        a = (new FlurryAdErrorType[] {
            FETCH, RENDER, CLICK
        });
    }
}
