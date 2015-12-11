// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import com.paypal.android.sdk.cq;
import com.paypal.android.sdk.dy;
import com.paypal.android.sdk.eb;

// Referenced classes of package com.paypal.android.sdk.payments:
//            bf, PayPalService, PayPalConfiguration, bh

final class bc
    implements bf
{

    private PayPalService a;

    bc(PayPalService paypalservice)
    {
        a = paypalservice;
        super();
    }

    public final void a()
    {
        if (!PayPalService.a(a).i() && a.b != null)
        {
            a.a(a.d().b.a(), a.b.e());
            a.b = null;
            a.q();
        }
    }

    public final void a(bh bh)
    {
    }
}
