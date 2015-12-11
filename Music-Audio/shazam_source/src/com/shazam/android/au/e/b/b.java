// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.au.e.b;

import java.io.PrintStream;
import java.nio.BufferUnderflowException;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.shazam.android.au.e.b:
//            a

public final class b
{

    public final int a;
    public final AtomicLong b = new AtomicLong(0L);
    public boolean c;
    public long d;
    private final Object e[];

    public b(a a1, int i)
    {
        c = true;
        d = 0L;
        a = i;
        e = new Object[a];
        a(a1);
    }

    private void a(a a1)
    {
        for (int i = 0; i < a; i++)
        {
            e[i] = a1.a();
        }

    }

    private void c()
    {
        if (!c)
        {
            throw new InterruptedException();
        } else
        {
            return;
        }
    }

    public final Object a(long l)
    {
        this;
        JVM INSTR monitorenter ;
        c();
        if (l < b.get() - (long)a)
        {
            System.out.println((new StringBuilder("Underflow ")).append(this).append(" sequence:").append(l).toString());
            throw new BufferUnderflowException();
        }
        break MISSING_BLOCK_LABEL_68;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        if (l <= b.get() - 1L)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        this;
        JVM INSTR monitorenter ;
        wait();
        c();
        this;
        JVM INSTR monitorexit ;
        if (true) goto _L2; else goto _L1
_L1:
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj;
        c();
        long l1 = a;
        obj = e[(int)(l % l1)];
        this;
        JVM INSTR monitorexit ;
        return obj;
    }

    public final void a()
    {
        this;
        JVM INSTR monitorenter ;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void b()
    {
        c = false;
        this;
        JVM INSTR monitorenter ;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final String toString()
    {
        this;
        JVM INSTR monitorenter ;
        String s = (new StringBuilder("RingBuffer{, write_head=")).append(b.get()).append(", bufferSize=").append(a).append('}').toString();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }
}
