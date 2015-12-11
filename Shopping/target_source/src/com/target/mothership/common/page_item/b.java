// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.page_item;


public final class b extends Enum
{

    private static final b $VALUES[];
    public static final b CARTWHEEL;
    public static final b MOBILE_COUPONS;
    public static final b UNKNOWN;
    public static final b WEEKLY_AD;
    private String mValue;

    private b(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static b a(String s)
    {
        if (s != null)
        {
            b ab[] = values();
            int j = ab.length;
            for (int i = 0; i < j; i++)
            {
                b b1 = ab[i];
                if (s.equalsIgnoreCase(b1.mValue))
                {
                    return b1;
                }
            }

        }
        return UNKNOWN;
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/target/mothership/common/page_item/b, s);
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
        CARTWHEEL = new b("CARTWHEEL", 0, "CARTWHEEL");
        MOBILE_COUPONS = new b("MOBILE_COUPONS", 1, "MOBILE_COUPONS");
        WEEKLY_AD = new b("WEEKLY_AD", 2, "WEEKLY_AD");
        UNKNOWN = new b("UNKNOWN", 3, "");
        $VALUES = (new b[] {
            CARTWHEEL, MOBILE_COUPONS, WEEKLY_AD, UNKNOWN
        });
    }
}
