// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.core;

import android.app.Activity;

// Referenced classes of package com.sessionm.core:
//            f, StatsCollector

class >
    implements Runnable
{

    final f cM;
    final Activity cN;

    public void run()
    {
        synchronized (cM)
        {
            if (f.f(cM) != 0L)
            {
                StatsCollector.a(sCollector.Stat.dn, System.currentTimeMillis() - f.f(cM));
            }
            StatsCollector.i(cN);
            if (f.E().getSessionState() == com.sessionm.api.ionM.State.STARTED_ONLINE)
            {
                f.a(cM, false);
            }
        }
        return;
        exception;
        f1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    onM.State(f f1, Activity activity)
    {
        cM = f1;
        cN = activity;
        super();
    }
}
