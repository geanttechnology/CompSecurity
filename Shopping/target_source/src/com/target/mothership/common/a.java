// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a ORIGINAL_PRICE;
    public static final a PRICE_FOR_EACH;
    public static final a SALE_PRICE;
    public static final a UNKNOWN;
    private String mValue;

    private a(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static a a(String s)
    {
        if (s != null)
        {
            a aa[] = values();
            int j = aa.length;
            for (int i = 0; i < j; i++)
            {
                a a1 = aa[i];
                if (s.equalsIgnoreCase(a1.mValue))
                {
                    return a1;
                }
            }

        }
        return UNKNOWN;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/mothership/common/a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        SALE_PRICE = new a("SALE_PRICE", 0, "Sale Price");
        PRICE_FOR_EACH = new a("PRICE_FOR_EACH", 1, "Price For each");
        ORIGINAL_PRICE = new a("ORIGINAL_PRICE", 2, "Original Price");
        UNKNOWN = new a("UNKNOWN", 3, "");
        $VALUES = (new a[] {
            SALE_PRICE, PRICE_FOR_EACH, ORIGINAL_PRICE, UNKNOWN
        });
    }
}
