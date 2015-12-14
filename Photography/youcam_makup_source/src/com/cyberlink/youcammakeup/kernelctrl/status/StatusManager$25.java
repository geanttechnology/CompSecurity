// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, am

class c
    implements Runnable
{

    final String a;
    final boolean b;
    final Float c[];
    final StatusManager d;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = d;
        statusmanager;
        JVM INSTR monitorenter ;
        am aam[];
        int j;
        aam = (am[])StatusManager.x(d).toArray(new am[0]);
        j = aam.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aam[i].a(a, b, c);
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

    (StatusManager statusmanager, String s, boolean flag, Float afloat[])
    {
        d = statusmanager;
        a = s;
        b = flag;
        c = afloat;
        super();
    }
}
