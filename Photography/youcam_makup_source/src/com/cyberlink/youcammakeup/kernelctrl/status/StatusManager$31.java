// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, ap

class a
    implements Runnable
{

    final WarpState a;
    final StatusManager b;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = b;
        statusmanager;
        JVM INSTR monitorenter ;
        ap aap[];
        int j;
        aap = (ap[])StatusManager.C(b).toArray(new ap[0]);
        j = aap.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aap[i].a(a);
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

    WarpState(StatusManager statusmanager, WarpState warpstate)
    {
        b = statusmanager;
        a = warpstate;
        super();
    }
}
