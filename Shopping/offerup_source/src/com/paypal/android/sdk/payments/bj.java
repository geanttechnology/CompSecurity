// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.bb;
import com.paypal.android.sdk.bf;
import com.paypal.android.sdk.cq;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

// Referenced classes of package com.paypal.android.sdk.payments:
//            PayPalService

final class bj
{

    private PayPalService a;
    private String b;

    public bj(PayPalService paypalservice)
    {
        a = paypalservice;
        b = Integer.toString((new GregorianCalendar()).getTimeZone().getRawOffset() / 1000 / 60);
    }

    public final cq a()
    {
        return a.d();
    }

    public final void a(bf bf)
    {
        a.a(bf);
    }

    public final String b()
    {
        return a.g();
    }

    public final bb c()
    {
        return a.c();
    }

    public final String d()
    {
        return a.f();
    }

    public final String e()
    {
        return b;
    }

    public final String f()
    {
        return a.s();
    }
}
