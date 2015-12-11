// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.internal:
//            dl, do

private class <init>
    implements Runnable
{

    final dl mr;

    public void run()
    {
        boolean flag;
        flag = false;
        dl.a(mr, false);
        long l = SystemClock.elapsedRealtime();
        dl.a(mr).d(l, 3);
        dl.b(mr).d(l, 3);
        dl.c(mr).d(l, 3);
        dl.d(mr).d(l, 3);
        dl.e(mr).d(l, 3);
        Object obj = do.mw;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        if (dl.a(mr).bf() || dl.b(mr).bf() || dl.c(mr).bf() || dl.d(mr).bf() || dl.e(mr).bf())
        {
            flag = true;
        }
        obj;
        JVM INSTR monitorexit ;
        dl.b(mr, flag);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private (dl dl1)
    {
        mr = dl1;
        super();
    }

    mr(dl dl1, mr mr1)
    {
        this(dl1);
    }
}
