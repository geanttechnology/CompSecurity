// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, ai

class a
    implements Runnable
{

    final StatusManager a;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = a;
        statusmanager;
        JVM INSTR monitorenter ;
        ai aai[];
        int j;
        aai = (ai[])StatusManager.q(a).toArray(new ai[0]);
        j = aai.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aai[i].a();
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

    (StatusManager statusmanager)
    {
        a = statusmanager;
        super();
    }
}
