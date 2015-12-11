// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.utils;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package io.presage.utils:
//            j, k

public final class i
    implements Executor
{

    private static final int c;
    private static final int d;
    private static final int e;
    private static final BlockingQueue f;
    private static final ThreadFactory g;
    private static final Executor h;
    private static i i;
    final ArrayDeque a = new ArrayDeque();
    Runnable b;

    private i()
    {
    }

    public static i a()
    {
        if (i == null)
        {
            i = new i();
        }
        return i;
    }

    protected final void b()
    {
        this;
        JVM INSTR monitorenter ;
        Runnable runnable;
        runnable = (Runnable)a.poll();
        b = runnable;
        if (runnable == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        h.execute(b);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void execute(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        a.offer(new k(this, runnable));
        if (b == null)
        {
            b();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        runnable;
        throw runnable;
    }

    static 
    {
        int l = Runtime.getRuntime().availableProcessors();
        c = l;
        d = l + 1;
        e = c * 2 + 1;
        f = new LinkedBlockingQueue(128);
        g = new j();
        h = new ThreadPoolExecutor(d, e, 1L, TimeUnit.SECONDS, f, g);
    }
}
