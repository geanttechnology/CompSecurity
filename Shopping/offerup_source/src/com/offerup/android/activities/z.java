// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import com.b.a.a.g;
import com.braintreepayments.api.Braintree;

// Referenced classes of package com.offerup.android.activities:
//            y, ab

final class z
    implements com.braintreepayments.api.Braintree.BraintreeSetupFinishedListener
{

    private y a;

    z(y y1)
    {
        a = y1;
        super();
    }

    public final void onBraintreeSetupFinished(boolean flag, Braintree braintree, String s, Exception exception)
    {
        a.i();
        g.a("payments_debugger", (new StringBuilder("5. receivedBraintreeSetupFinished(setupSuccessful)  setupSuccessful = ")).append(flag).toString());
        if (flag && braintree.isAndroidPayEnabled())
        {
            a.b = braintree;
            braintree.addListener(new ab(a));
        }
        a.b(flag);
    }
}
