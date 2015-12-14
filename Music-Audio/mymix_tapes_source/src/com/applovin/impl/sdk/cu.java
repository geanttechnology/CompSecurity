// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.impl.sdk:
//            bv, n, cq, AppLovinSdkImpl, 
//            dg, db, q, cb, 
//            cr

class cu
    implements Runnable
{

    final cq a;
    private final String b;
    private final bv c;
    private final cr d;

    cu(cq cq1, bv bv1, cr cr)
    {
        a = cq1;
        super();
        b = bv1.a();
        c = bv1;
        d = cr;
    }

    public void run()
    {
        long l = System.currentTimeMillis();
        n.a();
        if (cq.a(a).e())
        {
            break MISSING_BLOCK_LABEL_320;
        }
        if (cq.a(a).isEnabled())
        {
            cq.b(a).i(b, "Task started execution...");
            c.run();
            long l1 = System.currentTimeMillis() - l;
            if (c instanceof dg)
            {
                dg dg1 = (dg)c;
                db.a().a(dg1.e(), l1, q.a(cq.a(a)), dg1.f());
            }
            cq.b(a).i(b, (new StringBuilder()).append("Task executed successfully in ").append(l1).append("ms.").toString());
            cb cb1 = cq.a(a).b();
            cb1.a((new StringBuilder()).append(b).append("_count").toString());
            cb1.a((new StringBuilder()).append(b).append("_time").toString(), l1);
            return;
        }
        if (!cq.a(a).f())
        {
            break MISSING_BLOCK_LABEL_299;
        }
        cq.a(a).a(null);
_L1:
        Throwable throwable;
        c.b();
        return;
        try
        {
            cq.b(a).w(b, "Task not executed, SDK is disabled");
        }
        // Misplaced declaration of an exception variable
        catch (Throwable throwable)
        {
            cq.b(a).e(b, (new StringBuilder()).append("Task failed execution in ").append(System.currentTimeMillis() - l).append("ms.").toString(), throwable);
            return;
        }
          goto _L1
        cq.b(a).i(b, "Task re-scheduled...");
        a.a(c, d, 2000L);
        return;
    }
}
