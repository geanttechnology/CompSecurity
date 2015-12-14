// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, ah

class b
    implements Runnable
{

    final boolean a;
    final com.cyberlink.youcammakeup.utility.IntroDialogType b;
    final StatusManager c;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = c;
        statusmanager;
        JVM INSTR monitorenter ;
        ah aah[];
        int j;
        aah = (ah[])StatusManager.s(c).toArray(new ah[0]);
        j = aah.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        aah[i].a(a, b);
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

    gType(StatusManager statusmanager, boolean flag, com.cyberlink.youcammakeup.utility.IntroDialogType introdialogtype)
    {
        c = statusmanager;
        a = flag;
        b = introdialogtype;
        super();
    }
}
