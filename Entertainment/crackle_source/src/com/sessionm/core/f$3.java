// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.webkit.CookieSyncManager;
import com.sessionm.b.a;
import com.sessionm.c.c;
import com.sessionm.net.Request;
import com.sessionm.net.RequestQueue;
import java.util.List;

// Referenced classes of package com.sessionm.core:
//            f, e, StatsCollector

class >
    implements Runnable
{

    final f cM;

    public void run()
    {
        Object obj = cM.ak();
        synchronized (cM)
        {
            Object obj2 = cM.M();
            ((RequestQueue) (obj2)).start();
            Object obj1 = e.v();
            obj2 = ((e) (obj1)).a((c)((RequestQueue) (obj2)).bk().get(0), (c)((RequestQueue) (obj2)).bk().get(1));
            StatsCollector.reset();
            CookieSyncManager.createInstance(cM.getApplicationContext());
            ((e) (obj1)).x();
            obj1 = new Request(com.sessionm.net.est.Type.fj, new Object[] {
                cM.F()
            });
            ((a) (obj)).put("sessions", obj2);
            ((a) (obj)).put("stats", StatsCollector.j(f.g(cM)).aI());
            if (f.f(cM) == 0L)
            {
                com.sessionm.core.f.a(cM, System.currentTimeMillis());
            }
            ((a) (obj)).put("e", f.h(cM).aI());
            ((Request) (obj1)).d(((a) (obj)));
            obj = cM.M();
            ((RequestQueue) (obj)).a(cM);
            ((RequestQueue) (obj)).d(((Request) (obj1)));
            f.d(cM);
            if (((RequestQueue) (obj)).bi() > 0L)
            {
                cM.a(com.sessionm.api.ionM.State.STARTED_OFFLINE);
            }
        }
        return;
        exception;
        f1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    onM.State(f f1)
    {
        cM = f1;
        super();
    }
}
