// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.res.Resources;
import com.b.a.a.g;
import com.braintreepayments.api.Braintree;
import com.offerup.android.dto.BraintreeTokenResponse;
import com.offerup.android.utils.u;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.offerup.android.activities:
//            y, z

final class aa
    implements Callback
{

    private y a;

    aa(y y1)
    {
        a = y1;
        super();
    }

    public final void failure(RetrofitError retrofiterror)
    {
        g.a("payments_debugger", "2. BraintreeServerTokenCallback() failure");
        g.a(com/offerup/android/activities/y.getSimpleName(), retrofiterror);
        retrofiterror = u.a(retrofiterror, a.getResources().getString(0x7f09017b));
        a.a("Error", retrofiterror);
    }

    public final void success(Object obj, Response response)
    {
        response = (BraintreeTokenResponse)obj;
        g.a("payments_debugger", "2. BraintreeServerTokenCallback() success");
        obj = a;
        response = response.getPaymentToken();
        g.a("payments_debugger", "3. receivedBraintreeAuthToken(braintreeAuthToken)");
        g.a("payments_debugger", "4. setupBraintree(braintreeAuthToken);\t(add listener for nonce)");
        Braintree.setup(((android.content.Context) (obj)), response, new z(((y) (obj))));
    }
}
