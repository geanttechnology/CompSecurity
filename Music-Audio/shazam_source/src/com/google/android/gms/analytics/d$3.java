// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.g;

// Referenced classes of package com.google.android.gms.analytics:
//            d

final class b
    implements Runnable
{

    final int a;
    final g b;
    final d c;

    public final void run()
    {
        boolean flag = c.stopSelfResult(a);
        if (flag)
        {
            b.a("Install campaign broadcast processed", Boolean.valueOf(flag));
        }
    }

    rnal.g(d d1, int i, g g1)
    {
        c = d1;
        a = i;
        b = g1;
        super();
    }
}
