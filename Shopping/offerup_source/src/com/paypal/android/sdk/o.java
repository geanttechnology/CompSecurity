// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Collection;

// Referenced classes of package com.paypal.android.sdk:
//            p, q

public final class o extends Enum
{

    public static final o a;
    public static final o b;
    public static final o c;
    public static final o d;
    public static final o e;
    public static final o f;
    public static final o g;
    public static final Collection h = new p();
    public static final Collection i = new q();
    private static final o l[];
    private String j;
    private boolean k;

    private o(String s, int i1, String s1, boolean flag)
    {
        super(s, i1);
        j = s1;
        k = flag;
    }

    static boolean a(o o1)
    {
        return o1.k;
    }

    public static o valueOf(String s)
    {
        return (o)Enum.valueOf(com/paypal/android/sdk/o, s);
    }

    public static o[] values()
    {
        return (o[])l.clone();
    }

    public final String a()
    {
        return j;
    }

    static 
    {
        a = new o("FUTURE_PAYMENTS", 0, "https://uri.paypal.com/services/payments/futurepayments", false);
        b = new o("PROFILE", 1, "profile", true);
        c = new o("PAYPAL_ATTRIBUTES", 2, "https://uri.paypal.com/services/paypalattributes", true);
        d = new o("OPENID", 3, "openid", true);
        e = new o("EMAIL", 4, "email", true);
        f = new o("ADDRESS", 5, "address", true);
        g = new o("PHONE", 6, "phone", true);
        l = (new o[] {
            a, b, c, d, e, f, g
        });
    }
}
