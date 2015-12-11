// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.g.a;

import com.google.a.a.g;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class e
{
    private static final class a
    {

        final Runnable a;
        final Executor b;
        a c;

        a(Runnable runnable, Executor executor, a a1)
        {
            a = runnable;
            b = executor;
            c = a1;
        }
    }


    static final Logger a = Logger.getLogger(com/google/a/g/a/e.getName());
    private a b;
    private boolean c;

    public e()
    {
    }

    private static void b(Runnable runnable, Executor executor)
    {
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

    public final void a()
    {
        a a1 = null;
        this;
        JVM INSTR monitorenter ;
        if (!c)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        a a2;
        c = true;
        a2 = b;
        b = null;
        this;
        JVM INSTR monitorexit ;
          goto _L1
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L1:
        Exception exception;
        a a3;
        do
        {
            a3 = a1;
            if (a2 == null)
            {
                break;
            }
            a3 = a2.c;
            a2.c = a1;
            a1 = a2;
            a2 = a3;
        } while (true);
        for (; a3 != null; a3 = a3.c)
        {
            b(a3.a, a3.b);
        }

        return;
    }

    public final void a(Runnable runnable, Executor executor)
    {
        g.a(runnable, "Runnable was null.");
        g.a(executor, "Executor was null.");
        this;
        JVM INSTR monitorenter ;
        if (c)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        b = new a(runnable, executor, b);
        this;
        JVM INSTR monitorexit ;
        return;
        this;
        JVM INSTR monitorexit ;
        b(runnable, executor);
        return;
        runnable;
        this;
        JVM INSTR monitorexit ;
        throw runnable;
    }

}
