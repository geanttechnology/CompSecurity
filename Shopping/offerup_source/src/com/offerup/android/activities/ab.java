// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            y

final class ab
    implements com.braintreepayments.api.Braintree.PaymentMethodNonceListener
{

    private y a;

    ab(y y1)
    {
        a = y1;
        super();
    }

    public final void onPaymentMethodNonce(String s)
    {
        g.a("payments_debugger", (new StringBuilder("12. receivedWalletNonce() nonce=")).append(s).toString());
        if (StringUtils.isNotEmpty(s))
        {
            a.a(s);
            return;
        } else
        {
            g.c(getClass().getSimpleName(), "Got an empty token back from Braintree");
            a.i();
            a.a("Error", a.getString(0x7f090197));
            return;
        }
    }
}
