// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Collection;

// Referenced classes of package com.paypal.android.sdk:
//            cu

public final class ct extends Enum
{

    public static final ct a;
    public static final ct b;
    public static final ct c;
    public static final ct d;
    public static final ct e;
    public static final ct f;
    public static final ct g;
    public static final ct h;
    public static final Collection i = new cu();
    private static final ct k[];
    private String j;

    private ct(String s, int l, String s1)
    {
        super(s, l);
        j = s1;
    }

    public static ct valueOf(String s)
    {
        return (ct)Enum.valueOf(com/paypal/android/sdk/ct, s);
    }

    public static ct[] values()
    {
        return (ct[])k.clone();
    }

    public final String a()
    {
        return j;
    }

    static 
    {
        a = new ct("GET_FUNDING_OPTIONS", 0, "https://uri.paypal.com/services/payments/funding-options");
        b = new ct("PAYMENT_CODE", 1, "https://uri.paypal.com/services/pos/payments");
        c = new ct("MIS_CUSTOMER", 2, "https://uri.paypal.com/services/mis/customer");
        d = new ct("FINANCIAL_INSTRUMENTS", 3, "https://uri.paypal.com/services/wallet/financial-instruments/view");
        e = new ct("SEND_MONEY", 4, "https://uri.paypal.com/services/wallet/sendmoney");
        f = new ct("REQUEST_MONEY", 5, "https://uri.paypal.com/services/wallet/money-request/requests");
        g = new ct("LOYALTY", 6, "https://uri.paypal.com/services/loyalty/memberships/update");
        h = new ct("EXPRESS_CHECKOUT", 7, "https://uri.paypal.com/services/expresscheckout");
        k = (new ct[] {
            a, b, c, d, e, f, g, h
        });
    }
}
