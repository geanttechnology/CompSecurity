// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

final class a
    implements ThreadFactory
{

    private final String a;
    private final GlideExecutor.UncaughtThrowableStrategy b;
    private int c;

    a()
    {
        this("fifo-pool");
    }

    a(String s)
    {
        this(s, GlideExecutor.UncaughtThrowableStrategy.LOG);
    }

    private a(String s, GlideExecutor.UncaughtThrowableStrategy uncaughtthrowablestrategy)
    {
        a = s;
        b = uncaughtthrowablestrategy;
    }

    static GlideExecutor.UncaughtThrowableStrategy a(a a1)
    {
        return a1.b;
    }

    public final Thread newThread(Runnable runnable)
    {
        this;
        JVM INSTR monitorenter ;
        runnable = new Thread(runnable, (new StringBuilder()).append(a).append("-thread-").append(c).toString()) {

            private a a;

            public final void run()
            {
                Process.setThreadPriority(10);
                try
                {
                    super.run();
                    return;
                }
                catch (Throwable throwable)
                {
                    a.a(a).handle(throwable);
                }
            }

            
            {
                a = a.this;
                super(runnable, s);
            }
        };
        c = c + 1;
        this;
        JVM INSTR monitorexit ;
        return runnable;
        runnable;
        throw runnable;
    }
}
