// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

final class qx
    implements Executor
{

    private final Executor a;
    private final ArrayDeque b = new ArrayDeque();
    private Runnable c;

    public qx(Executor executor)
    {
        a = (Executor)b.a(executor);
    }

    private void a()
    {
        this;
        JVM INSTR monitorenter ;
        Runnable runnable;
        runnable = (Runnable)b.poll();
        c = runnable;
        if (runnable == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        a.execute(c);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void a(qx qx1)
    {
        qx1.a();
    }

    public final void execute(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        b.offer(new qy(this, runnable));
        if (c == null)
        {
            a();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        runnable;
        throw runnable;
    }
}
