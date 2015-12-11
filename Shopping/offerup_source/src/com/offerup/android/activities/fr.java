// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.offerup.android.dto.PaymentMethod;
import com.offerup.android.dto.PaymentMethodResponse;
import com.offerup.android.utils.u;
import java.util.Collections;
import java.util.List;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            PaymentMethodsActivity

final class fr
    implements Callback
{

    private PaymentMethodsActivity a;

    private fr(PaymentMethodsActivity paymentmethodsactivity)
    {
        a = paymentmethodsactivity;
        super();
    }

    fr(PaymentMethodsActivity paymentmethodsactivity, byte byte0)
    {
        this(paymentmethodsactivity);
    }

    public final void failure(RetrofitError retrofiterror)
    {
        a.i();
        a.a("Error", u.a(retrofiterror, a.getString(0x7f090199)));
    }

    public final void success(Object obj, Response response)
    {
        obj = (PaymentMethodResponse)obj;
        a.i();
        response = ((PaymentMethodResponse) (obj)).getPaymentMethods();
        if (!((PaymentMethodResponse) (obj)).isSuccess() || response == null) goto _L2; else goto _L1
_L1:
        Collections.sort(response);
        a.o = response;
        if (a.d != null) goto _L4; else goto _L3
_L3:
        int i = 0;
_L8:
        if (i >= response.size())
        {
            break; /* Loop/switch isn't completed */
        }
        if (!((PaymentMethod)response.get(i)).isAndroidPay()) goto _L6; else goto _L5
_L5:
        a.m = true;
        a.a();
_L2:
        return;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L4:
        a.g();
_L7:
        PaymentMethodsActivity.c(a);
        return;
    }
}
