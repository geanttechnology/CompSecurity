// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupon_wallets.interfaces;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a ACTIVE;
    public static final a APPLIED;
    public static final a EXPIRED;
    public static final a INACTIVE;
    public static final a NONE;
    public static final a REDEEMED;
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
        return NONE;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/mothership/model/coupon_wallets/interfaces/a, s);
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
        ACTIVE = new a("ACTIVE", 0, "active");
        APPLIED = new a("APPLIED", 1, "applied");
        INACTIVE = new a("INACTIVE", 2, "inactive");
        EXPIRED = new a("EXPIRED", 3, "expired");
        REDEEMED = new a("REDEEMED", 4, "redeemed");
        NONE = new a("NONE", 5, "");
        $VALUES = (new a[] {
            ACTIVE, APPLIED, INACTIVE, EXPIRED, REDEEMED, NONE
        });
    }
}
