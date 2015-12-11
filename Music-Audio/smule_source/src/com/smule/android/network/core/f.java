// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;

import java.util.concurrent.TimeUnit;

// Referenced classes of package com.smule.android.network.core:
//            h

class f extends Thread
{

    private static f d = null;
    private final h a;
    private final int b;
    private final int c;

    public f(h h1, int i, int j)
    {
        a = h1;
        b = i;
        c = j * 1000;
    }

    public static void a(h h1, int i, int j)
    {
        com/smule/android/network/core/f;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            d = new f(h1, i, j);
            d.start();
        }
        com/smule/android/network/core/f;
        JVM INSTR monitorexit ;
        return;
        h1;
        throw h1;
    }

    public void run()
    {
_L2:
        this;
        JVM INSTR monitorenter ;
        wait(c);
        this;
        JVM INSTR monitorexit ;
        a.closeExpiredConnections();
        a.closeIdleConnections(b, TimeUnit.SECONDS);
        com/smule/android/network/core/f;
        JVM INSTR monitorenter ;
        if (a.getConnectionsInPool() != 0)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        d = null;
        com/smule/android/network/core/f;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        try
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            d = null;
        }
        return;
        com/smule/android/network/core/f;
        JVM INSTR monitorexit ;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        com/smule/android/network/core/f;
        JVM INSTR monitorexit ;
        throw obj;
    }

}
