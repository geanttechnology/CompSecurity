// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk;


public final class TSGender extends Enum
{

    private static final TSGender $VALUES[];
    public static final TSGender TSGenderFemale;
    public static final TSGender TSGenderMale;
    public static final TSGender TSGenderUnknown;
    private final int gender;

    private TSGender(String s, int i, int j)
    {
        super(s, i);
        gender = j;
    }

    public static TSGender valueOf(int i)
    {
        if (i == 1)
        {
            return TSGenderMale;
        }
        if (i == 2)
        {
            return TSGenderFemale;
        } else
        {
            return TSGenderUnknown;
        }
    }

    public static TSGender valueOf(String s)
    {
        return (TSGender)Enum.valueOf(com/targetspot/android/sdk/TSGender, s);
    }

    public static TSGender[] values()
    {
        return (TSGender[])$VALUES.clone();
    }

    public int getGender()
    {
        return gender;
    }

    static 
    {
        TSGenderUnknown = new TSGender("TSGenderUnknown", 0, 0);
        TSGenderMale = new TSGender("TSGenderMale", 1, 1);
        TSGenderFemale = new TSGender("TSGenderFemale", 2, 2);
        $VALUES = (new TSGender[] {
            TSGenderUnknown, TSGenderMale, TSGenderFemale
        });
    }
}
