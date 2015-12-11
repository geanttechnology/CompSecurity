// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import java.util.TimerTask;

// Referenced classes of package com.paypal.android.sdk.payments:
//            aq, c

final class ar extends TimerTask
{

    private aq a;

    ar(aq aq1)
    {
        a = aq1;
        super();
    }

    public final void run()
    {
        c.e(a.a);
    }
}
