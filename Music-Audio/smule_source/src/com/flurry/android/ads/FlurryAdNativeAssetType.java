// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.ads;


public final class FlurryAdNativeAssetType extends Enum
{

    public static final FlurryAdNativeAssetType IMAGE;
    public static final FlurryAdNativeAssetType TEXT;
    private static final FlurryAdNativeAssetType b[];
    private int a;

    private FlurryAdNativeAssetType(String s, int i, int j)
    {
        super(s, i);
        a = j;
    }

    public static FlurryAdNativeAssetType valueOf(String s)
    {
        return (FlurryAdNativeAssetType)Enum.valueOf(com/flurry/android/ads/FlurryAdNativeAssetType, s);
    }

    public static FlurryAdNativeAssetType[] values()
    {
        return (FlurryAdNativeAssetType[])b.clone();
    }

    public int getValue()
    {
        return a;
    }

    static 
    {
        TEXT = new FlurryAdNativeAssetType("TEXT", 0, 1);
        IMAGE = new FlurryAdNativeAssetType("IMAGE", 1, 2);
        b = (new FlurryAdNativeAssetType[] {
            TEXT, IMAGE
        });
    }
}
