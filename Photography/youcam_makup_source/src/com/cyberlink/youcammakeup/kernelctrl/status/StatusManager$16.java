// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, u

class a
    implements Runnable
{

    final boolean a;
    final StatusManager b;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = b;
        statusmanager;
        JVM INSTR monitorenter ;
        u au[];
        int j;
        au = (u[])StatusManager.r(b).toArray(new u[0]);
        j = au.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        au[i].g(a);
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

    (StatusManager statusmanager, boolean flag)
    {
        b = statusmanager;
        a = flag;
        super();
    }
}
