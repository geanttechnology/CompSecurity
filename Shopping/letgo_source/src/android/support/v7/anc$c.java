// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.LinkedList;
import java.util.concurrent.Executor;

// Referenced classes of package android.support.v7:
//            anc

private static class <init>
    implements Executor
{

    final LinkedList a;
    Runnable b;

    protected void a()
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
        anc.b.execute(b);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void execute(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        a.offer(new Runnable(runnable) {

            final Runnable a;
            final anc.c b;

            public void run()
            {
                a.run();
                b.a();
                return;
                Exception exception;
                exception;
                b.a();
                throw exception;
            }

            
            {
                b = anc.c.this;
                a = runnable;
                super();
            }
        });
        if (b == null)
        {
            a();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        runnable;
        throw runnable;
    }

    private _cls1.a()
    {
        a = new LinkedList();
    }

    t>(t> t>)
    {
        this();
    }
}
