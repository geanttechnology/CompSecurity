// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import com.offerup.android.utils.u;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            PaymentMethodsActivity

final class fs
    implements Callback
{

    private String a;
    private PaymentMethodsActivity b;

    public fs(PaymentMethodsActivity paymentmethodsactivity, String s)
    {
        b = paymentmethodsactivity;
        super();
        a = s;
    }

    public final void failure(RetrofitError retrofiterror)
    {
        b.i();
        g.a(b, retrofiterror);
        b.a("Error", u.a(retrofiterror, a));
    }

    public final void success(Object obj, Response response)
    {
        b.i();
        PaymentMethodsActivity.b(b);
    }
}
