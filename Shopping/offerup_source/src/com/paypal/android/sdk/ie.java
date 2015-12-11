// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            lh, id, kq, ih, 
//            hr, lk

final class ie
    implements lh
{

    private static boolean d;
    private final kq a = new kq();
    private boolean b;
    private boolean c;
    private id e;

    ie(id id1)
    {
        e = id1;
        super();
    }

    private void a(boolean flag)
    {
        Object obj = e;
        obj;
        JVM INSTR monitorenter ;
        id.g(e).c();
        for (; e.b <= 0L && !c && !b && id.d(e) == null; id.e(e)) { }
        break MISSING_BLOCK_LABEL_81;
        Exception exception1;
        exception1;
        id.g(e).b();
        throw exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        long l;
        id.g(e).b();
        id.h(e);
        l = Math.min(e.b, a.b);
        id id1 = e;
        id1.b = id1.b - l;
        obj;
        JVM INSTR monitorexit ;
        id.g(e).c();
        int i;
        obj = id.a(e);
        i = id.b(e);
        if (!flag) goto _L2; else goto _L1
_L1:
        if (l != a.b) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        ((hr) (obj)).a(i, flag, a, l);
        id.g(e).b();
        return;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        id.g(e).b();
        throw exception;
    }

    static boolean a(ie ie1)
    {
        return ie1.c;
    }

    static boolean a(ie ie1, boolean flag)
    {
        ie1.c = flag;
        return flag;
    }

    static boolean b(ie ie1)
    {
        return ie1.b;
    }

    public final lk a()
    {
        return id.g(e);
    }

    public final void a_(kq kq1, long l)
    {
        if (!d && Thread.holdsLock(e))
        {
            throw new AssertionError();
        }
        a.a_(kq1, l);
        while (a.b >= 16384L) 
        {
            a(false);
        }
    }

    public final void close()
    {
label0:
        {
            if (!d && Thread.holdsLock(e))
            {
                throw new AssertionError();
            }
            synchronized (e)
            {
                if (!b)
                {
                    break label0;
                }
            }
            return;
        }
        id1;
        JVM INSTR monitorexit ;
        if (!e.c.c)
        {
            if (a.b > 0L)
            {
                while (a.b > 0L) 
                {
                    a(true);
                }
            } else
            {
                id.a(e).a(id.b(e), true, null, 0L);
            }
        }
        break MISSING_BLOCK_LABEL_113;
        exception;
        id1;
        JVM INSTR monitorexit ;
        throw exception;
        synchronized (e)
        {
            b = true;
        }
        id.a(e).c();
        id.f(e);
        return;
        exception1;
        id2;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public final void flush()
    {
        if (!d && Thread.holdsLock(e))
        {
            throw new AssertionError();
        }
        synchronized (e)
        {
            id.h(e);
        }
        while (a.b > 0L) 
        {
            a(false);
            id.a(e).c();
        }
        break MISSING_BLOCK_LABEL_75;
        exception;
        id1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        boolean flag;
        if (!com/paypal/android/sdk/id.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d = flag;
    }
}
