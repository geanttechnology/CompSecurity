// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.paypal.android.sdk:
//            z, ax

final class aa extends TimerTask
{

    private z a;

    aa(z z1)
    {
        a = z1;
        super();
    }

    public final void run()
    {
        z.a(a);
        z.g();
        (new StringBuilder("****** LogRiskMetadataTask #")).append(z.b(a));
        ax.b();
        if (z.c(a))
        {
            z.g();
            (new StringBuilder("No host activity in the last ")).append(z.d(a) / 1000L).append(" seconds. Stopping update interval.");
            ax.b();
            z.e(a).cancel();
            return;
        }
        try
        {
            z.f(a);
            return;
        }
        catch (Exception exception)
        {
            z.g();
        }
        ax.a();
    }
}
