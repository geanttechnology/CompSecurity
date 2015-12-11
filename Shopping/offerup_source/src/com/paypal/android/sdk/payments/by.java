// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.content.Context;
import com.paypal.android.sdk.az;
import com.paypal.android.sdk.cz;

// Referenced classes of package com.paypal.android.sdk.payments:
//            PayPalService

class by
{

    by()
    {
    }

    static boolean a(Context context, PayPalService paypalservice)
    {
        if (az.e(paypalservice.f()))
        {
            (new StringBuilder("Is mock or sandbox:")).append(paypalservice.f());
        } else
        if (paypalservice.t())
        {
            return (new cz()).a(context, paypalservice.u());
        }
        return false;
    }

    static 
    {
        com/paypal/android/sdk/payments/by.getSimpleName();
    }
}
