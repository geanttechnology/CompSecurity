// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;


final class k extends Enum
{

    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    private static final k e[];

    private k(String s, int i)
    {
        super(s, i);
    }

    public static k valueOf(String s)
    {
        return (k)Enum.valueOf(com/paypal/android/sdk/payments/k, s);
    }

    public static k[] values()
    {
        return (k[])e.clone();
    }

    static 
    {
        a = new k("FUTURE_PAYMENTS", 0);
        b = new k("FINANCIAL_INSTRUMENTS", 1);
        c = new k("SEND_MONEY", 2);
        d = new k("REQUEST_MONEY", 3);
        e = (new k[] {
            a, b, c, d
        });
    }
}
