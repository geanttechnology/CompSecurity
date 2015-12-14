// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.utils;


public final class Maturity extends Enum
{

    private static final Maturity $VALUES[];
    public static final Maturity ADULT;
    public static final Maturity FREETIME;
    public static final Maturity TEENTIME;
    private final String stickerMask;

    private Maturity(String s, int i, String s1)
    {
        super(s, i);
        stickerMask = s1;
    }

    public static Maturity valueOf(String s)
    {
        return (Maturity)Enum.valueOf(com/aviary/android/feather/sdk/utils/Maturity, s);
    }

    public static Maturity[] values()
    {
        return (Maturity[])$VALUES.clone();
    }

    public String getStickerMask()
    {
        return stickerMask;
    }

    public boolean isKidsFriendly()
    {
        return this == FREETIME;
    }

    static 
    {
        ADULT = new Maturity("ADULT", 0, "'%\\_a\\_%'");
        TEENTIME = new Maturity("TEENTIME", 1, "'%\\_t\\_%'");
        FREETIME = new Maturity("FREETIME", 2, "'%\\_k\\_%'");
        $VALUES = (new Maturity[] {
            ADULT, TEENTIME, FREETIME
        });
    }
}
