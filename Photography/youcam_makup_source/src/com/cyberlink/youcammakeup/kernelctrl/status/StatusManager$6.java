// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import com.cyberlink.youcammakeup.jniproxy.y;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, y

class b
    implements Runnable
{

    final y a;
    final boolean b;
    final StatusManager c;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = c;
        statusmanager;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.kernelctrl.status.y ay[];
        int j;
        ay = (com.cyberlink.youcammakeup.kernelctrl.status.y[])StatusManager.j(c).toArray(new com.cyberlink.youcammakeup.kernelctrl.status.y[0]);
        j = ay.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ay[i].a(a, b);
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

    (StatusManager statusmanager, y y1, boolean flag)
    {
        c = statusmanager;
        a = y1;
        b = flag;
        super();
    }
}
