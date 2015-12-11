// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.a;


public final class d extends Enum
{

    private static final d $VALUES[];
    public static final d BUNDLE;
    public static final d CLEARANCE;
    public static final d NONE;
    public static final d PRICE_CUT;
    public static final d SALE;
    public static final d TEMPORARY_PRICE_CUT;
    private String mValue;

    private d(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static d a(String s)
    {
        if (s != null)
        {
            d ad[] = values();
            int j = ad.length;
            for (int i = 0; i < j; i++)
            {
                d d1 = ad[i];
                if (s.equalsIgnoreCase(d1.mValue))
                {
                    return d1;
                }
            }

        }
        return NONE;
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/target/mothership/common/a/d, s);
    }

    public static d[] values()
    {
        return (d[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        SALE = new d("SALE", 0, "sale");
        PRICE_CUT = new d("PRICE_CUT", 1, "price cut");
        TEMPORARY_PRICE_CUT = new d("TEMPORARY_PRICE_CUT", 2, "temporary price cut");
        CLEARANCE = new d("CLEARANCE", 3, "clearance");
        BUNDLE = new d("BUNDLE", 4, "Bundle");
        NONE = new d("NONE", 5, "");
        $VALUES = (new d[] {
            SALE, PRICE_CUT, TEMPORARY_PRICE_CUT, CLEARANCE, BUNDLE, NONE
        });
    }
}
