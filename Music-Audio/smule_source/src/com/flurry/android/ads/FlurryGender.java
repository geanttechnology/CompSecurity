// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android.ads;


public final class FlurryGender extends Enum
{

    public static final FlurryGender FEMALE;
    public static final FlurryGender MALE;
    public static final FlurryGender UNKNOWN;
    private static final FlurryGender a[];

    private FlurryGender(String s, int i)
    {
        super(s, i);
    }

    public static FlurryGender valueOf(String s)
    {
        return (FlurryGender)Enum.valueOf(com/flurry/android/ads/FlurryGender, s);
    }

    public static FlurryGender[] values()
    {
        return (FlurryGender[])a.clone();
    }

    static 
    {
        UNKNOWN = new FlurryGender("UNKNOWN", 0);
        MALE = new FlurryGender("MALE", 1);
        FEMALE = new FlurryGender("FEMALE", 2);
        a = (new FlurryGender[] {
            UNKNOWN, MALE, FEMALE
        });
    }
}
