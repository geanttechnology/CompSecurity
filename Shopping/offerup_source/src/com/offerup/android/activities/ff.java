// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            PaymentMethodCaptureActivity

final class ff
    implements com.braintreepayments.api.Braintree.PaymentMethodNonceListener
{

    private PaymentMethodCaptureActivity a;

    private ff(PaymentMethodCaptureActivity paymentmethodcaptureactivity)
    {
        a = paymentmethodcaptureactivity;
        super();
    }

    ff(PaymentMethodCaptureActivity paymentmethodcaptureactivity, byte byte0)
    {
        this(paymentmethodcaptureactivity);
    }

    public final void onPaymentMethodNonce(String s)
    {
        if (StringUtils.isNotEmpty(s))
        {
            PaymentMethodCaptureActivity.a(a, s);
            return;
        } else
        {
            g.c(getClass().getSimpleName(), "Got an empty token back from Braintree");
            a.i();
            a.a(null);
            return;
        }
    }
}
