// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;


public class b
{

    private Runnable a;

    public b(Runnable runnable)
    {
        a = runnable;
        runnable = Thread.currentThread();
        runnable.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(runnable.getUncaughtExceptionHandler()) {

            final Thread.UncaughtExceptionHandler a;
            final b b;

            public void uncaughtException(Thread thread, Throwable throwable)
            {
                Runnable runnable1 = b.a(b);
                b.a();
                if (runnable1 != null)
                {
                    try
                    {
                        runnable1.run();
                    }
                    catch (Exception exception) { }
                }
                if (a != null)
                {
                    a.uncaughtException(thread, throwable);
                }
            }

            
            {
                b = b.this;
                a = uncaughtexceptionhandler;
                super();
            }
        });
    }

    static Runnable a(b b1)
    {
        return b1.a;
    }

    public void a()
    {
        a = null;
    }
}
