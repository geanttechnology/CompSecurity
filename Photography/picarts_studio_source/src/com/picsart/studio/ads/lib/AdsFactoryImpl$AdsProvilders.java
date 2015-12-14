// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads.lib;


public final class  extends Enum
{

    private static final FBAD $VALUES[];
    public static final FBAD ADMOB;
    public static final FBAD AMAZON;
    public static final FBAD FBAD;
    public static final FBAD INMOBI;
    public static final FBAD MMEDIA3;
    public static final FBAD MOPUB2;
    public static final FBAD NONE;
    public static final FBAD SOCIALIN;
    public static final FBAD TEST;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/picsart/studio/ads/lib/AdsFactoryImpl$AdsProvilders, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        SOCIALIN = new <init>("SOCIALIN", 1);
        ADMOB = new <init>("ADMOB", 2);
        MMEDIA3 = new <init>("MMEDIA3", 3);
        AMAZON = new <init>("AMAZON", 4);
        INMOBI = new <init>("INMOBI", 5);
        MOPUB2 = new <init>("MOPUB2", 6);
        TEST = new <init>("TEST", 7);
        FBAD = new <init>("FBAD", 8);
        $VALUES = (new .VALUES[] {
            NONE, SOCIALIN, ADMOB, MMEDIA3, AMAZON, INMOBI, MOPUB2, TEST, FBAD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
