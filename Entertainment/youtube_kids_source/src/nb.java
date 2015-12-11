// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class nb
    implements Future, mj, mk
{

    private boolean a;
    private Object b;
    private mp c;

    public nb()
    {
        a = false;
    }

    private Object a(Long long1)
    {
        this;
        JVM INSTR monitorenter ;
        if (c != null)
        {
            throw new ExecutionException(c);
        }
        break MISSING_BLOCK_LABEL_26;
        long1;
        this;
        JVM INSTR monitorexit ;
        throw long1;
        if (!a) goto _L2; else goto _L1
_L1:
        long1 = ((Long) (b));
_L7:
        this;
        JVM INSTR monitorexit ;
        return long1;
_L2:
        if (long1 != null) goto _L4; else goto _L3
_L3:
        wait(0L);
_L6:
        if (c != null)
        {
            throw new ExecutionException(c);
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (long1.longValue() > 0L)
        {
            wait(long1.longValue());
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (!a)
        {
            throw new TimeoutException();
        }
        long1 = ((Long) (b));
          goto _L7
    }

    public final void a(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        a = true;
        b = obj;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public final void a(mp mp)
    {
        this;
        JVM INSTR monitorenter ;
        c = mp;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        mp;
        throw mp;
    }

    public final boolean cancel(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        return false;
    }

    public final Object get()
    {
        Object obj;
        try
        {
            obj = a(((Long) (null)));
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
        return false;
    }

    public final boolean isDone()
    {
        this;
        JVM INSTR monitorenter ;
        if (a || c != null) goto _L2; else goto _L1
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
}
