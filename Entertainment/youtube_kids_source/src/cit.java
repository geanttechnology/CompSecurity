// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;

public final class cit
{

    public long a;
    private long b;
    private long c;

    public cit(cis cis)
    {
        b = -1L;
        c = -1L;
        a = 0L;
    }

    private long e()
    {
        long l;
        if (c == -1L)
        {
            l = SystemClock.elapsedRealtime();
        } else
        {
            l = c;
        }
        return l - b;
    }

    final void a()
    {
        this;
        JVM INSTR monitorenter ;
        b = SystemClock.elapsedRealtime();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void a(long l)
    {
        this;
        JVM INSTR monitorenter ;
        a = a + l;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final void b()
    {
        this;
        JVM INSTR monitorenter ;
        c = SystemClock.elapsedRealtime();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final int c()
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        l = e();
        l1 = b;
        if (l1 != -1L && l > 0L) goto _L2; else goto _L1
_L1:
        int i = -1;
_L4:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        l = (a * 1000L) / l;
        i = (int)l;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final long[] d()
    {
        this;
        JVM INSTR monitorenter ;
        long l = e();
        if (b != -1L && l > 0L) goto _L2; else goto _L1
_L1:
        long al[] = new long[2];
        al;
        al[0] = -1L;
        al[1] = -1L;
_L4:
        this;
        JVM INSTR monitorexit ;
        return al;
_L2:
        al = new long[2];
        al[0] = a;
        al[1] = l;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }
}
