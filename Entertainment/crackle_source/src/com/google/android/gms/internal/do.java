// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.SystemClock;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            dk, dn

public final class do
{

    private static final dk lA = new dk("RequestTracker");
    public static final Object mw = new Object();
    private long ms;
    private long mt;
    private long mu;
    private dn mv;

    public do(long l)
    {
        ms = l;
        mt = -1L;
        mu = 0L;
    }

    private void be()
    {
        mt = -1L;
        mv = null;
        mu = 0L;
    }

    public void a(long l, dn dn1)
    {
        dn dn2;
        long l1;
        synchronized (mw)
        {
            dn2 = mv;
            l1 = mt;
            mt = l;
            mv = dn1;
            mu = SystemClock.elapsedRealtime();
        }
        if (dn2 != null)
        {
            dn2.g(l1);
        }
        return;
        dn1;
        obj;
        JVM INSTR monitorexit ;
        throw dn1;
    }

    public boolean b(long l, int j, JSONObject jsonobject)
    {
        dn dn1;
        boolean flag;
        flag = true;
        dn1 = null;
        Object obj = mw;
        obj;
        JVM INSTR monitorenter ;
        if (mt == -1L || mt != l)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        lA.b("request %d completed", new Object[] {
            Long.valueOf(mt)
        });
        dn1 = mv;
        be();
_L2:
        if (dn1 != null)
        {
            dn1.a(l, j, jsonobject);
        }
        return flag;
        jsonobject;
        obj;
        JVM INSTR monitorexit ;
        throw jsonobject;
        flag = false;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean bf()
    {
        Object obj = mw;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (mt != -1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean c(long l, int j)
    {
        return b(l, j, null);
    }

    public void clear()
    {
        synchronized (mw)
        {
            if (mt != -1L)
            {
                be();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean d(long l, int j)
    {
        long l1;
        boolean flag;
        flag = true;
        l1 = 0L;
        Object obj1 = mw;
        obj1;
        JVM INSTR monitorenter ;
        Object obj;
        if (mt == -1L || l - mu < ms)
        {
            break MISSING_BLOCK_LABEL_105;
        }
        lA.b("request %d timed out", new Object[] {
            Long.valueOf(mt)
        });
        l = mt;
        obj = mv;
        be();
_L2:
        if (obj != null)
        {
            ((dn) (obj)).a(l, j, null);
        }
        return flag;
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        flag = false;
        obj = null;
        l = l1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public boolean i(long l)
    {
        Object obj = mw;
        obj;
        JVM INSTR monitorenter ;
        Exception exception;
        boolean flag;
        if (mt != -1L && mt == l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj;
        JVM INSTR monitorexit ;
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
