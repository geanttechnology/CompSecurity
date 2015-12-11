// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.weeklyad;


public final class b extends Enum
{

    private static final b $VALUES[];
    public static final b ADD_TO_CART;
    public static final b BUY_ONLINE;
    public static final b NOT_SOLD_ONLINE;
    public static final b PICKUP_IN_STORE;
    public static final b UNKNOWN;
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
        return (b)Enum.valueOf(com/target/mothership/common/weeklyad/b, s);
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
        ADD_TO_CART = new b("ADD_TO_CART", 0, "add to cart");
        PICKUP_IN_STORE = new b("PICKUP_IN_STORE", 1, "pick up in store");
        BUY_ONLINE = new b("BUY_ONLINE", 2, "buy online");
        NOT_SOLD_ONLINE = new b("NOT_SOLD_ONLINE", 3, "not sold online");
        UNKNOWN = new b("UNKNOWN", 4, "");
        $VALUES = (new b[] {
            ADD_TO_CART, PICKUP_IN_STORE, BUY_ONLINE, NOT_SOLD_ONLINE, UNKNOWN
        });
    }
}
