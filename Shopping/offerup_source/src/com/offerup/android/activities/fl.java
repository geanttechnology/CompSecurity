// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.Intent;
import com.b.a.a.j;
import com.offerup.android.dto.AddCardResponse;
import com.offerup.android.utils.u;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            PaymentMethodCaptureActivity

final class fl
    implements Callback
{

    private PaymentMethodCaptureActivity a;

    private fl(PaymentMethodCaptureActivity paymentmethodcaptureactivity)
    {
        a = paymentmethodcaptureactivity;
        super();
    }

    fl(PaymentMethodCaptureActivity paymentmethodcaptureactivity, byte byte0)
    {
        this(paymentmethodcaptureactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        a.a(u.a(retrofiterror, null));
    }

    public final void success(Object obj, Response response)
    {
        response = (AddCardResponse)obj;
        a.i();
        obj = j.a();
        ((j) (obj)).d(true);
        ((j) (obj)).e(true);
        obj = a;
        response = response.getPaymentMethod();
        Intent intent = new Intent();
        intent.putExtra("paymentMethod", response);
        ((PaymentMethodCaptureActivity) (obj)).setResult(-1, intent);
        ((PaymentMethodCaptureActivity) (obj)).finish();
    }
}
