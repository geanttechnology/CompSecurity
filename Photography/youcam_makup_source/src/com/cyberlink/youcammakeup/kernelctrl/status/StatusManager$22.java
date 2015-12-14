// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import com.cyberlink.youcammakeup.utility.BeautyMode;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, j

class a
    implements Runnable
{

    final BeautyMode a;
    final StatusManager b;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = b;
        statusmanager;
        JVM INSTR monitorenter ;
        j aj[];
        int k;
        aj = (j[])StatusManager.u(b).toArray(new j[0]);
        k = aj.length;
_L2:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        aj[i].a(a);
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

    (StatusManager statusmanager, BeautyMode beautymode)
    {
        b = statusmanager;
        a = beautymode;
        super();
    }
}
