// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.braintreepayments.api.models.CardBuilder;
import com.offerup.android.dto.BraintreeTokenResponse;
import com.offerup.android.utils.u;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            PaymentMethodCaptureActivity

public final class fg
    implements Callback
{

    private CardBuilder a;
    private PaymentMethodCaptureActivity b;

    private fg(PaymentMethodCaptureActivity paymentmethodcaptureactivity, CardBuilder cardbuilder)
    {
        b = paymentmethodcaptureactivity;
        super();
        a = cardbuilder;
    }

    fg(PaymentMethodCaptureActivity paymentmethodcaptureactivity, CardBuilder cardbuilder, byte byte0)
    {
        this(paymentmethodcaptureactivity, cardbuilder);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        b.i();
        b.a(u.a(retrofiterror, null));
    }

    public final void success(Object obj, Response response)
    {
        obj = ((BraintreeTokenResponse)obj).getPaymentToken();
        b.a(((String) (obj)), a);
    }
}
