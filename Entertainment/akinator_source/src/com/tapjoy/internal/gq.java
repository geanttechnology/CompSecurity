// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.tapjoy.internal:
//            aa

public final class gq
{

    public static final ScheduledExecutorService a = Executors.newScheduledThreadPool(1);
    public static final CountDownLatch b = new CountDownLatch(1);
    public static final CountDownLatch c = new CountDownLatch(1);
    private static final Runnable d = new Runnable() {

        public final void run()
        {
            if (aa.c())
            {
                gq.b.countDown();
                return;
            }
            if (aa.a())
            {
                gq.b.countDown();
                return;
            } else
            {
                gq.a.schedule(this, 300L, TimeUnit.SECONDS);
                return;
            }
        }

    };
    private static String e;
    private static boolean f;

    public static void a()
    {
        a.execute(d);
    }

    public static void a(String s, boolean flag)
    {
        e = s;
        f = flag;
        c.countDown();
    }

    public static String b()
    {
        return e;
    }

    public static boolean c()
    {
        return f;
    }

}
