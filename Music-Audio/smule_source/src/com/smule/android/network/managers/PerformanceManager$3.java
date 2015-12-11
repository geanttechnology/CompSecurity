// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.a.k;
import com.smule.android.network.core.NetworkResponseCallback;

// Referenced classes of package com.smule.android.network.managers:
//            PerformanceManager

class b
    implements Runnable
{

    final String a;
    final NetworkResponseCallback b;
    final PerformanceManager c;

    public void run()
    {
        com.smule.android.network.core.o o = k.a(a);
        if (b != null)
        {
            PerformanceManager.a(c, b, o);
        }
    }

    (PerformanceManager performancemanager, String s, NetworkResponseCallback networkresponsecallback)
    {
        c = performancemanager;
        a = s;
        b = networkresponsecallback;
        super();
    }
}
