// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.status;

import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.status:
//            StatusManager, h

class b
    implements Runnable
{

    final d a;
    final BeautifierTaskInfo b;
    final StatusManager c;

    public void run()
    {
        int i = 0;
        StatusManager statusmanager = c;
        statusmanager;
        JVM INSTR monitorenter ;
        h ah[];
        int j;
        ah = (h[])StatusManager.i(c).toArray(new h[0]);
        j = ah.length;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ah[i].a(a, b);
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

    (StatusManager statusmanager, d d, BeautifierTaskInfo beautifiertaskinfo)
    {
        c = statusmanager;
        a = d;
        b = beautifiertaskinfo;
        super();
    }
}
