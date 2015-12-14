// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;


public class a
{

    private Runnable a;

    public a(Runnable runnable)
    {
        a = runnable;
        runnable = Thread.currentThread();
        runnable.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(runnable.getUncaughtExceptionHandler()) {

            final Thread.UncaughtExceptionHandler a;
            final a b;

            public void uncaughtException(Thread thread, Throwable throwable)
            {
                Runnable runnable1 = a.a(b);
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
                b = a.this;
                a = uncaughtexceptionhandler;
                super();
            }
        });
    }

    static Runnable a(a a1)
    {
        return a1.a;
    }

    public void a()
    {
        a = null;
    }
}
