// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.content.Intent;
import android.util.Log;

// Referenced classes of package com.paypal.android.sdk.payments:
//            PayPalConfiguration

abstract class co
{

    private Intent a;
    private PayPalConfiguration b;

    co(Intent intent, PayPalConfiguration paypalconfiguration)
    {
        a = intent;
        b = paypalconfiguration;
        if (!a.hasExtra("com.paypal.android.sdk.paypalConfiguration"))
        {
            Log.w(b(), "Please add PayPalService.EXTRA_PAYPAL_CONFIGURATION to this activity for restart resiliency.");
        }
    }

    protected final void a(boolean flag, String s)
    {
        if (!flag)
        {
            Log.e(b(), (new StringBuilder()).append(s).append(" is invalid.  Please see the docs.").toString());
        }
    }

    abstract boolean a();

    abstract String b();

    final Intent c()
    {
        return a;
    }

    final PayPalConfiguration d()
    {
        return b;
    }

    protected final boolean e()
    {
        if (!b.n())
        {
            Log.e(b(), "Service extra invalid.");
            return false;
        } else
        {
            return true;
        }
    }
}
