// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, cs, bv, cu, 
//            cr, cp

class cq
{

    private final AppLovinSdkImpl a;
    private final AppLovinLogger b;
    private final ScheduledExecutorService c = a("main");
    private final ScheduledExecutorService d = a("back");
    private final ScheduledExecutorService e = a("postbacks");

    cq(AppLovinSdkImpl applovinsdkimpl)
    {
        a = applovinsdkimpl;
        b = applovinsdkimpl.getLogger();
    }

    static AppLovinSdkImpl a(cq cq1)
    {
        return cq1.a;
    }

    private static void a(Runnable runnable, long l, ScheduledExecutorService scheduledexecutorservice)
    {
        if (l > 0L)
        {
            scheduledexecutorservice.schedule(runnable, l, TimeUnit.MILLISECONDS);
            return;
        } else
        {
            scheduledexecutorservice.submit(runnable);
            return;
        }
    }

    static AppLovinLogger b(cq cq1)
    {
        return cq1.b;
    }

    ScheduledExecutorService a(String s)
    {
        return Executors.newScheduledThreadPool(1, new cs(this, s));
    }

    void a(bv bv1, cr cr1)
    {
        a(bv1, cr1, 0L);
    }

    void a(bv bv1, cr cr1, long l)
    {
        if (bv1 == null)
        {
            throw new IllegalArgumentException("No task specified");
        }
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid delay specified: ").append(l).toString());
        }
        b.d(bv1.e, (new StringBuilder()).append("Scheduling ").append(bv1.e).append(" on ").append(cr1).append(" queue in ").append(l).append("ms.").toString());
        bv1 = new cu(this, bv1, cr1);
        if (cr1 == cr.a)
        {
            a(((Runnable) (bv1)), l, c);
        } else
        {
            if (cr1 == cr.b)
            {
                a(((Runnable) (bv1)), l, d);
                return;
            }
            if (cr1 == cr.c)
            {
                a(((Runnable) (bv1)), l, e);
                return;
            }
        }
    }

    void a(cp cp, long l)
    {
        if (cp == null)
        {
            throw new IllegalArgumentException("No task specified");
        } else
        {
            a(((Runnable) (cp)), l, c);
            return;
        }
    }
}
