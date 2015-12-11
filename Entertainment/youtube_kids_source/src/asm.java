// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.PriorityQueue;

public final class asm
{

    public static final asm a = new asm();
    private final Object b = new Object();
    private final PriorityQueue c = new PriorityQueue();
    private int d;

    private asm()
    {
        d = 0x7fffffff;
    }

    public final void a(int i)
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        if (d < i)
        {
            throw new arv(i, d);
        }
        break MISSING_BLOCK_LABEL_33;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
    }

    public final void b(int i)
    {
        synchronized (b)
        {
            c.add(Integer.valueOf(0));
            d = Math.min(d, 0);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void c(int i)
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        c.remove(Integer.valueOf(0));
        if (!c.isEmpty()) goto _L2; else goto _L1
_L1:
        i = 0x7fffffff;
_L4:
        d = i;
        b.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
_L2:
        i = ((Integer)c.peek()).intValue();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
