// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.impl.ads.protocol.v13;


public final class AdViewType extends Enum
{

    private static final AdViewType $VALUES[];
    public static final AdViewType BANNER;
    public static final AdViewType INTERSTITIAL;
    public static final AdViewType LEGACY;
    public static final AdViewType NATIVE;
    public static final AdViewType STREAM;

    private AdViewType(String s, int i)
    {
        super(s, i);
    }

    public static AdViewType valueOf(String s)
    {
        return (AdViewType)Enum.valueOf(com/flurry/android/impl/ads/protocol/v13/AdViewType, s);
    }

    public static AdViewType[] values()
    {
        return (AdViewType[])$VALUES.clone();
    }

    static 
    {
        LEGACY = new AdViewType("LEGACY", 0);
        BANNER = new AdViewType("BANNER", 1);
        INTERSTITIAL = new AdViewType("INTERSTITIAL", 2);
        STREAM = new AdViewType("STREAM", 3);
        NATIVE = new AdViewType("NATIVE", 4);
        $VALUES = (new AdViewType[] {
            LEGACY, BANNER, INTERSTITIAL, STREAM, NATIVE
        });
    }
}
