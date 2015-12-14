// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;


// Referenced classes of package com.aviary.android.feather.cds:
//            CdsUtils

public static final class value extends Enum
{

    private static final YEAR $VALUES[];
    public static final YEAR MONTH;
    public static final YEAR YEAR;
    int value;

    public static value fromInt(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return MONTH;

        case 2: // '\002'
            return YEAR;
        }
    }

    public static YEAR valueOf(String s)
    {
        return (YEAR)Enum.valueOf(com/aviary/android/feather/cds/CdsUtils$SubscriptionDurationTier, s);
    }

    public static YEAR[] values()
    {
        return (YEAR[])$VALUES.clone();
    }

    static 
    {
        MONTH = new <init>("MONTH", 0, 1);
        YEAR = new <init>("YEAR", 1, 2);
        $VALUES = (new .VALUES[] {
            MONTH, YEAR
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
