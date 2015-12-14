// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, ac

class c
    implements Runnable
{

    final List a;
    final Object b;
    final UUID c;
    final StatusManager d;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = d;
        statusmanager;
        JVM INSTR monitorenter ;
        ac aac[];
        int j;
        aac = (ac[])StatusManager.d(d).toArray(new ac[0]);
        j = aac.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aac[i].a(a, b, c);
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

    (StatusManager statusmanager, List list, Object obj, UUID uuid)
    {
        d = statusmanager;
        a = list;
        b = obj;
        c = uuid;
        super();
    }
}
