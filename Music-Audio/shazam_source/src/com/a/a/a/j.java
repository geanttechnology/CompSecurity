// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import com.a.a.m;
import com.a.a.t;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class j
    implements com.a.a.o.a, com.a.a.o.b, Future
{

    private m a;
    private boolean b;
    private Object c;
    private t d;

    private j()
    {
        b = false;
    }

    public static j a()
    {
        return new j();
    }

    private Object a(Long long1)
    {
        this;
        JVM INSTR monitorenter ;
        if (d != null)
        {
            throw new ExecutionException(d);
        }
        break MISSING_BLOCK_LABEL_26;
        long1;
        this;
        JVM INSTR monitorexit ;
        throw long1;
        if (!b) goto _L2; else goto _L1
_L1:
        long1 = ((Long) (c));
_L7:
        this;
        JVM INSTR monitorexit ;
        return long1;
_L2:
        if (long1 != null) goto _L4; else goto _L3
_L3:
        wait(0L);
_L6:
        if (d != null)
        {
            throw new ExecutionException(d);
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (long1.longValue() > 0L)
        {
            wait(long1.longValue());
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (!b)
        {
            throw new TimeoutException();
        }
        long1 = ((Long) (c));
          goto _L7
    }

    public final boolean cancel(boolean flag)
    {
        flag = false;
        this;
        JVM INSTR monitorenter ;
        m m1 = a;
        if (m1 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (isDone())
        {
            continue; /* Loop/switch isn't completed */
        }
        a.cancel();
        flag = true;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final Object get()
    {
        Object obj;
        try
        {
            obj = a(null);
        }
        catch (TimeoutException timeoutexception)
        {
            throw new AssertionError(timeoutexception);
        }
        return obj;
    }

    public final Object get(long l, TimeUnit timeunit)
    {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(l, timeunit)));
    }

    public final boolean isCancelled()
    {
        if (a == null)
        {
            return false;
        } else
        {
            return a.isCanceled();
        }
    }

    public final boolean isDone()
    {
        this;
        JVM INSTR monitorenter ;
        if (b || d != null) goto _L2; else goto _L1
_L1:
        boolean flag = isCancelled();
        if (!flag) goto _L3; else goto _L2
_L2:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public final void onErrorResponse(t t)
    {
        this;
        JVM INSTR monitorenter ;
        d = t;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        t;
        throw t;
    }

    public final void onResponse(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        b = true;
        c = obj;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }
}
