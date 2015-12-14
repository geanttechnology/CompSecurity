// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;

// Referenced classes of package com.tencent.open.utils:
//            k

class l
    implements Executor
{

    final Queue a;
    Runnable b;

    private l()
    {
        a = new LinkedList();
    }

    l(k._cls1 _pcls1)
    {
        this();
    }

    protected void a()
    {
        this;
        JVM INSTR monitorenter ;
        Runnable runnable;
        runnable = (Runnable)a.poll();
        b = runnable;
        if (runnable == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        k.a.execute(b);
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
            final l b;

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
                b = l.this;
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
}
