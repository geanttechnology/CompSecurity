// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.b.e.a;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class a
{

    private String a;
    private Boolean b;
    private Integer c;
    private Thread.UncaughtExceptionHandler d;
    private ThreadFactory e;

    public a()
    {
        a = null;
        b = null;
        c = null;
        d = null;
        e = null;
    }

    public final a a()
    {
        b = Boolean.valueOf(true);
        return this;
    }

    public final a a(String s)
    {
        String.format(s, new Object[] {
            Integer.valueOf(0)
        });
        a = s;
        return this;
    }

    public final ThreadFactory b()
    {
        String s = a;
        Boolean boolean1 = b;
        Integer integer = c;
        Thread.UncaughtExceptionHandler uncaughtexceptionhandler = d;
        ThreadFactory threadfactory;
        AtomicLong atomiclong;
        if (e != null)
        {
            threadfactory = e;
        } else
        {
            threadfactory = Executors.defaultThreadFactory();
        }
        if (s != null)
        {
            atomiclong = new AtomicLong(0L);
        } else
        {
            atomiclong = null;
        }
        return new ThreadFactory(threadfactory, s, atomiclong, boolean1, integer, uncaughtexceptionhandler) {

            final ThreadFactory a;
            final String b;
            final AtomicLong c;
            final Boolean d;
            final Integer e;
            final Thread.UncaughtExceptionHandler f;

            public final Thread newThread(Runnable runnable)
            {
                runnable = a.newThread(runnable);
                if (b != null)
                {
                    runnable.setName(String.format(b, new Object[] {
                        Long.valueOf(c.getAndIncrement())
                    }));
                }
                if (d != null)
                {
                    runnable.setDaemon(d.booleanValue());
                }
                if (e != null)
                {
                    runnable.setPriority(e.intValue());
                }
                if (f != null)
                {
                    runnable.setUncaughtExceptionHandler(f);
                }
                return runnable;
            }

            
            {
                a = threadfactory;
                b = s;
                c = atomiclong;
                d = boolean1;
                e = integer;
                f = uncaughtexceptionhandler;
                super();
            }
        };
    }
}
