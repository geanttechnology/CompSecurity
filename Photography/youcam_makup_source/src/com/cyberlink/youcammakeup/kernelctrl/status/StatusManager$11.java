// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ae;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, x

class b
    implements Runnable
{

    final ae a;
    final int b;
    final StatusManager c;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = c;
        statusmanager;
        JVM INSTR monitorenter ;
        x ax[];
        int j;
        ax = (x[])StatusManager.n(c).toArray(new x[0]);
        j = ax.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ax[i].a(a, b);
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

    (StatusManager statusmanager, ae ae, int i)
    {
        c = statusmanager;
        a = ae;
        b = i;
        super();
    }
}
