// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, o

class a
    implements Runnable
{

    final Object a;
    final StatusManager b;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = b;
        statusmanager;
        JVM INSTR monitorenter ;
        o ao[];
        int j;
        ao = (o[])StatusManager.e(b).toArray(new o[0]);
        j = ao.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ao[i].a(a);
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

    (StatusManager statusmanager, Object obj)
    {
        b = statusmanager;
        a = obj;
        super();
    }
}
