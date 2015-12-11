// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.internal:
//            dv, dy

private class <init>
    implements Runnable
{

    final dv yy;

    public void run()
    {
        boolean flag;
        flag = false;
        dv.a(yy, false);
        long l = SystemClock.elapsedRealtime();
        dv.a(yy).d(l, 3);
        dv.b(yy).d(l, 3);
        dv.c(yy).d(l, 3);
        dv.d(yy).d(l, 3);
        dv.e(yy).d(l, 3);
        dv.f(yy).d(l, 3);
        dv.g(yy).d(l, 3);
        dv.h(yy).d(l, 3);
        Object obj = dy.yD;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        if (dv.a(yy).dl() || dv.e(yy).dl() || dv.f(yy).dl() || dv.g(yy).dl() || dv.h(yy).dl())
        {
            flag = true;
        }
        obj;
        JVM INSTR monitorexit ;
        dv.b(yy, flag);
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private (dv dv1)
    {
        yy = dv1;
        super();
    }

    yy(dv dv1, yy yy1)
    {
        this(dv1);
    }
}
