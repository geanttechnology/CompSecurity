// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.a;


public final class c extends Enum
{

    private static final c $VALUES[];
    public static final c EXPRESS_CHECKOUT_ELIGIBLE;
    public static final c ITEM_RESTRICTION_EXISTS;
    public static final c NO_DEFAULT_ADDRESS;
    public static final c NO_DEFAULT_PAYMENT;
    public static final c NO_PICKUP_DETAILS;
    public static final c SHIPPING_RESTRICTION_EXISTS;
    public static final c UNKNOWN;
    private String mValues[];

    private transient c(String s, int i, String as[])
    {
        super(s, i);
        mValues = as;
    }

    public static c a(String s)
    {
        if (s != null)
        {
            c ac[] = values();
            int k = ac.length;
            for (int i = 0; i < k; i++)
            {
                c c1 = ac[i];
                String as[] = c1.mValues;
                int l = as.length;
                for (int j = 0; j < l; j++)
                {
                    if (s.equalsIgnoreCase(as[j]))
                    {
                        return c1;
                    }
                }

            }

        }
        return UNKNOWN;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/target/mothership/common/a/c, s);
    }

    public static c[] values()
    {
        return (c[])$VALUES.clone();
    }

    static 
    {
        EXPRESS_CHECKOUT_ELIGIBLE = new c("EXPRESS_CHECKOUT_ELIGIBLE", 0, new String[] {
            "EXPRESS_CHECKOUT_ELIGIBLE", "TWO_TAP_CHECKOUT_ELIGIBLE"
        });
        NO_PICKUP_DETAILS = new c("NO_PICKUP_DETAILS", 1, new String[] {
            "NO_PICKUP_DETAILS"
        });
        NO_DEFAULT_ADDRESS = new c("NO_DEFAULT_ADDRESS", 2, new String[] {
            "NO_DEFAULT_ADDR"
        });
        SHIPPING_RESTRICTION_EXISTS = new c("SHIPPING_RESTRICTION_EXISTS", 3, new String[] {
            "SHIPPING_RESTRICTION_EXISTS"
        });
        ITEM_RESTRICTION_EXISTS = new c("ITEM_RESTRICTION_EXISTS", 4, new String[] {
            "ITEM_RESTRICTION_EXISTS"
        });
        NO_DEFAULT_PAYMENT = new c("NO_DEFAULT_PAYMENT", 5, new String[] {
            "NO_DEFAULT_PAYMENT"
        });
        UNKNOWN = new c("UNKNOWN", 6, new String[] {
            ""
        });
        $VALUES = (new c[] {
            EXPRESS_CHECKOUT_ELIGIBLE, NO_PICKUP_DETAILS, NO_DEFAULT_ADDRESS, SHIPPING_RESTRICTION_EXISTS, ITEM_RESTRICTION_EXISTS, NO_DEFAULT_PAYMENT, UNKNOWN
        });
    }
}
