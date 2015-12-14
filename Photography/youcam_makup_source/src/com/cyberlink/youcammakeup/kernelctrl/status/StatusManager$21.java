// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import com.cyberlink.youcammakeup.utility.MakeupMode;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, aj

class a
    implements Runnable
{

    final MakeupMode a;
    final StatusManager b;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = b;
        statusmanager;
        JVM INSTR monitorenter ;
        aj aaj[];
        int j;
        aaj = (aj[])StatusManager.t(b).toArray(new aj[0]);
        j = aaj.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aaj[i].b(a);
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

    (StatusManager statusmanager, MakeupMode makeupmode)
    {
        b = statusmanager;
        a = makeupmode;
        super();
    }
}
