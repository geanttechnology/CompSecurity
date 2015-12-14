// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class mc
{

    private static mc a;
    private final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
    private final Map c = new WeakHashMap();

    private mc()
    {
        Thread.setDefaultUncaughtExceptionHandler(new a());
    }

    public static mc a()
    {
        com/flurry/sdk/mc;
        JVM INSTR monitorenter ;
        mc mc1;
        if (a == null)
        {
            a = new mc();
        }
        mc1 = a;
        com/flurry/sdk/mc;
        JVM INSTR monitorexit ;
        return mc1;
        Exception exception;
        exception;
        throw exception;
    }

    static void a(mc mc1, Thread thread, Throwable throwable)
    {
        mc1.a(thread, throwable);
    }

    private void a(Thread thread, Throwable throwable)
    {
        for (Iterator iterator = c().iterator(); iterator.hasNext();)
        {
            Thread.UncaughtExceptionHandler uncaughtexceptionhandler = (Thread.UncaughtExceptionHandler)iterator.next();
            try
            {
                uncaughtexceptionhandler.uncaughtException(thread, throwable);
            }
            catch (Throwable throwable1) { }
        }

    }

    public static void b()
    {
        com/flurry/sdk/mc;
        JVM INSTR monitorenter ;
        if (a != null)
        {
            a.d();
        }
        a = null;
        com/flurry/sdk/mc;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static void b(mc mc1, Thread thread, Throwable throwable)
    {
        mc1.b(thread, throwable);
    }

    private void b(Thread thread, Throwable throwable)
    {
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_18;
        }
        b.uncaughtException(thread, throwable);
        return;
        thread;
    }

    private Set c()
    {
        Set set;
        synchronized (c)
        {
            set = c.keySet();
        }
        return set;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void d()
    {
        Thread.setDefaultUncaughtExceptionHandler(b);
    }

    public void a(Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        synchronized (c)
        {
            c.put(uncaughtexceptionhandler, null);
        }
        return;
        uncaughtexceptionhandler;
        map;
        JVM INSTR monitorexit ;
        throw uncaughtexceptionhandler;
    }

    private class a
        implements Thread.UncaughtExceptionHandler
    {

        final mc a;

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            mc.a(a, thread, throwable);
            mc.b(a, thread, throwable);
        }

        private a()
        {
            a = mc.this;
            super();
        }

    }

}
