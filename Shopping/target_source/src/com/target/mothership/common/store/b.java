// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.store;


public final class b extends Enum
{

    private static final b $VALUES[];
    public static final b CITY;
    public static final b EXPRESS;
    public static final b GENERAL_MERCHANDISE;
    public static final b GREATLAND;
    public static final b P_FRESH;
    public static final b SUPER_TARGET;
    public static final b UNKNOWN;
    private String mValue;

    private b(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static b a(String s)
    {
        b ab[] = values();
        int j = ab.length;
        for (int i = 0; i < j; i++)
        {
            b b1 = ab[i];
            if (b1.mValue.equals(s))
            {
                return b1;
            }
        }

        return UNKNOWN;
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/target/mothership/common/store/b, s);
    }

    public static b[] values()
    {
        return (b[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        GREATLAND = new b("GREATLAND", 0, "Greatland");
        GENERAL_MERCHANDISE = new b("GENERAL_MERCHANDISE", 1, "General Merchandise");
        SUPER_TARGET = new b("SUPER_TARGET", 2, "SuperTarget");
        P_FRESH = new b("P_FRESH", 3, "PFresh");
        CITY = new b("CITY", 4, "City");
        EXPRESS = new b("EXPRESS", 5, "Express");
        UNKNOWN = new b("UNKNOWN", 6, "Unknown");
        $VALUES = (new b[] {
            GREATLAND, GENERAL_MERCHANDISE, SUPER_TARGET, P_FRESH, CITY, EXPRESS, UNKNOWN
        });
    }
}
