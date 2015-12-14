// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, ak

class b
    implements Runnable
{

    final com.cyberlink.youcammakeup.widgetpool.common.er.MotionName a;
    final boolean b;
    final StatusManager c;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = c;
        statusmanager;
        JVM INSTR monitorenter ;
        ak aak[];
        int j;
        aak = (ak[])StatusManager.B(c).toArray(new ak[0]);
        j = aak.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aak[i].a(a, b);
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

    er.MotionName(StatusManager statusmanager, com.cyberlink.youcammakeup.widgetpool.common.er.MotionName motionname, boolean flag)
    {
        c = statusmanager;
        a = motionname;
        b = flag;
        super();
    }
}
