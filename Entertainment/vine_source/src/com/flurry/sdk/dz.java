// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class dz
{
    final class a
        implements Thread.UncaughtExceptionHandler
    {

        final dz a;

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            dz.a(a, thread, throwable);
            dz.b(a, thread, throwable);
        }

        private a()
        {
            a = dz.this;
            super();
        }

    }


    private static dz a;
    private final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();
    private final Map c = new WeakHashMap();

    private dz()
    {
        Thread.setDefaultUncaughtExceptionHandler(new a());
    }

    public static dz a()
    {
        com/flurry/sdk/dz;
        JVM INSTR monitorenter ;
        dz dz1;
        if (a == null)
        {
            a = new dz();
        }
        dz1 = a;
        com/flurry/sdk/dz;
        JVM INSTR monitorexit ;
        return dz1;
        Exception exception;
        exception;
        throw exception;
    }

    static void a(dz dz1, Thread thread, Throwable throwable)
    {
        dz1.a(thread, throwable);
    }

    private void a(Thread thread, Throwable throwable)
    {
        for (Iterator iterator = b().iterator(); iterator.hasNext();)
        {
            Thread.UncaughtExceptionHandler uncaughtexceptionhandler = (Thread.UncaughtExceptionHandler)iterator.next();
            try
            {
                uncaughtexceptionhandler.uncaughtException(thread, throwable);
            }
            catch (Throwable throwable1) { }
        }

    }

    private Set b()
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

    static void b(dz dz1, Thread thread, Throwable throwable)
    {
        dz1.b(thread, throwable);
    }

    private void b(Thread thread, Throwable throwable)
    {
        if (b != null)
        {
            b.uncaughtException(thread, throwable);
        }
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
}
