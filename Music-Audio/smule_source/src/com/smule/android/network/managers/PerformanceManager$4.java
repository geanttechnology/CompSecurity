// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;


// Referenced classes of package com.smule.android.network.managers:
//            PerformanceManager

class b
    implements Runnable
{

    final rformancesResponseCallback a;
    final int b;
    final PerformanceManager c;

    public void run()
    {
        PerformanceManager.a(c, a, c.a(b));
    }

    rformancesResponseCallback(PerformanceManager performancemanager, rformancesResponseCallback rformancesresponsecallback, int i)
    {
        c = performancemanager;
        a = rformancesresponsecallback;
        b = i;
        super();
    }
}
