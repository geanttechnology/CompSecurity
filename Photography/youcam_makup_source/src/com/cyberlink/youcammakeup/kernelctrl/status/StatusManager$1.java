// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, i

class a
    implements Runnable
{

    final StatusManager a;

    public void run()
    {
        int j = 0;
        StatusManager statusmanager = a;
        statusmanager;
        JVM INSTR monitorenter ;
        i ai[];
        int k;
        ai = (i[])StatusManager.a(a).toArray(new i[0]);
        k = ai.length;
_L2:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        ai[j].a(StatusManager.b(a));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        statusmanager;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        statusmanager;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (StatusManager statusmanager)
    {
        a = statusmanager;
        super();
    }
}
