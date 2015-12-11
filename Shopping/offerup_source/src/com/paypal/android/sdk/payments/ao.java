// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

// Referenced classes of package com.paypal.android.sdk.payments:
//            c, be, ap, PayPalService

final class ao
    implements ServiceConnection
{

    final c a;

    ao(c c1)
    {
        a = c1;
        super();
    }

    public final void onServiceConnected(ComponentName componentname, IBinder ibinder)
    {
        (new StringBuilder()).append(c.a()).append(".onServiceConnected");
        if (a.isFinishing())
        {
            (new StringBuilder()).append(c.a()).append(".onServiceConnected exit - isFinishing");
        } else
        {
            c.a(a, ((be)ibinder).a);
            if (c.b(a).a(new ap(this)))
            {
                c.c(a);
                return;
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentname)
    {
        c.a(a, null);
        c.a();
    }
}
