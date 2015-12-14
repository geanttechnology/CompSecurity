// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.ads;


public final class AdProviders extends Enum
{

    private static final AdProviders $VALUES[];
    public static final AdProviders ADMOB;
    public static final AdProviders AMAZON;
    public static final AdProviders FBAD;
    public static final AdProviders INMOBI;
    public static final AdProviders MMEDIA3;
    public static final AdProviders MOPUB2;
    public static final AdProviders NONE;
    public static final AdProviders SOCIALIN;
    public static final AdProviders TEST;

    private AdProviders(String s, int i)
    {
        super(s, i);
    }

    public static AdProviders valueOf(String s)
    {
        return (AdProviders)Enum.valueOf(com/socialin/android/ads/AdProviders, s);
    }

    public static AdProviders[] values()
    {
        return (AdProviders[])$VALUES.clone();
    }

    static 
    {
        NONE = new AdProviders("NONE", 0);
        SOCIALIN = new AdProviders("SOCIALIN", 1);
        ADMOB = new AdProviders("ADMOB", 2);
        MMEDIA3 = new AdProviders("MMEDIA3", 3);
        AMAZON = new AdProviders("AMAZON", 4);
        INMOBI = new AdProviders("INMOBI", 5);
        MOPUB2 = new AdProviders("MOPUB2", 6);
        TEST = new AdProviders("TEST", 7);
        FBAD = new AdProviders("FBAD", 8);
        $VALUES = (new AdProviders[] {
            NONE, SOCIALIN, ADMOB, MMEDIA3, AMAZON, INMOBI, MOPUB2, TEST, FBAD
        });
    }
}
