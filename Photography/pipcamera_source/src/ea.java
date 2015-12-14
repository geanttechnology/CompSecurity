// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.example.android.bitmapfun.util.AsyncTask;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class ea
    implements Executor
{

    final ArrayDeque a;
    Runnable b;

    private ea()
    {
        a = new ArrayDeque();
    }

    public ea(com.example.android.bitmapfun.util.AsyncTask._cls1 _pcls1)
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
        AsyncTask.a.execute(b);
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
            final ea b;

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
                b = ea.this;
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
