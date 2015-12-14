// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, m

class b
    implements Runnable
{

    final com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.erName a;
    final Long b;
    final StatusManager c;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = c;
        statusmanager;
        JVM INSTR monitorenter ;
        m am[];
        int j;
        am = (m[])StatusManager.k(c).toArray(new m[0]);
        j = am.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        am[i].a(a, b);
        i++;
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

    er.BufferName(StatusManager statusmanager, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.erName ername, Long long1)
    {
        c = statusmanager;
        a = ername;
        b = long1;
        super();
    }
}
