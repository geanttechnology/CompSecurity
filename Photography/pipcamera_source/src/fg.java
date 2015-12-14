// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.fotoable.comlib.util.AsyncTask;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class fg
    implements Executor
{

    final ArrayDeque a;
    Runnable b;

    private fg()
    {
        a = new ArrayDeque();
    }

    public fg(com.fotoable.comlib.util.AsyncTask._cls1 _pcls1)
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
            break MISSING_BLOCK_LABEL_34;
        }
        AsyncTask.THREAD_POOL_EXECUTOR.execute(b);
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
            final fg b;

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
                b = fg.this;
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
