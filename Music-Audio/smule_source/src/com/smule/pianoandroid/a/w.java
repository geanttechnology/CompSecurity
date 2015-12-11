// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import android.os.Handler;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class w
{

    private static ScheduledThreadPoolExecutor a = new ScheduledThreadPoolExecutor(1);
    private static Handler b;

    public static void a()
    {
        b = new Handler();
    }

    public static void a(Runnable runnable)
    {
        a.execute(runnable);
    }

    public static void a(Runnable runnable, Runnable runnable1)
    {
        a(new Runnable(runnable, runnable1) {

            final Runnable a;
            final Runnable b;

            public void run()
            {
                a.run();
                if (b != null)
                {
                    w.b().post(b);
                }
            }

            
            {
                a = runnable;
                b = runnable1;
                super();
            }
        });
    }

    static Handler b()
    {
        return b;
    }

}
