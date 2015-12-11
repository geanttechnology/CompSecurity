// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import com.google.a.a.g;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.a.g.a:
//            j, i

private static abstract class <init>
    implements j
{

    private static final Logger a = Logger.getLogger(com/google/a/g/a/i$c.getName());

    public final void a(Runnable runnable, Executor executor)
    {
        g.a(runnable, "Runnable was null.");
        g.a(executor, "Executor was null.");
        try
        {
            executor.execute(runnable);
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            Logger logger = a;
            Level level = Level.SEVERE;
            runnable = String.valueOf(String.valueOf(runnable));
            executor = String.valueOf(String.valueOf(executor));
            logger.log(level, (new StringBuilder(runnable.length() + 57 + executor.length())).append("RuntimeException while executing runnable ").append(runnable).append(" with executor ").append(executor).toString(), runtimeexception);
            return;
        }
    }

    public boolean cancel(boolean flag)
    {
        return false;
    }

    public abstract Object get();

    public Object get(long l, TimeUnit timeunit)
    {
        g.a(timeunit);
        return get();
    }

    public boolean isCancelled()
    {
        return false;
    }

    public boolean isDone()
    {
        return true;
    }


    private TimeUnit()
    {
    }

    TimeUnit(byte byte0)
    {
        this();
    }
}
