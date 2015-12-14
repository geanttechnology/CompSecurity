// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, an

class b
    implements Runnable
{

    final List a;
    final boolean b;
    final StatusManager c;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = c;
        statusmanager;
        JVM INSTR monitorenter ;
        an aan[];
        int j;
        aan = (an[])StatusManager.y(c).toArray(new an[0]);
        j = aan.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aan[i].a(a, b);
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

    (StatusManager statusmanager, List list, boolean flag)
    {
        c = statusmanager;
        a = list;
        b = flag;
        super();
    }
}
