// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.network.core.NetworkResponseCallback;

// Referenced classes of package com.smule.android.network.managers:
//            PerformanceManager

class d
    implements Runnable
{

    final NetworkResponseCallback a;
    final String b;
    final float c;
    final float d;
    final PerformanceManager e;

    public void run()
    {
        PerformanceManager.a(e, a, e.b(b, c, d));
    }

    (PerformanceManager performancemanager, NetworkResponseCallback networkresponsecallback, String s, float f, float f1)
    {
        e = performancemanager;
        a = networkresponsecallback;
        b = s;
        c = f;
        d = f1;
        super();
    }
}
