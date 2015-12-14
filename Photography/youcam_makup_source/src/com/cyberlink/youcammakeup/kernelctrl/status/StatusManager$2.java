// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, ag, ImageStateChangedEvent

class a
    implements Runnable
{

    final ImageStateChangedEvent a;
    final StatusManager b;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = b;
        statusmanager;
        JVM INSTR monitorenter ;
        ag aag[];
        int j;
        aag = (ag[])StatusManager.h(b).toArray(new ag[0]);
        j = aag.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aag[i].a(a);
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

    dEvent(StatusManager statusmanager, ImageStateChangedEvent imagestatechangedevent)
    {
        b = statusmanager;
        a = imagestatechangedevent;
        super();
    }
}
