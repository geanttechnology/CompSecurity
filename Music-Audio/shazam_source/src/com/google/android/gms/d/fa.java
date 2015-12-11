// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.google.android.gms.d:
//            kq, hx, iu, dz, 
//            gs, lf, is, z

public final class fa extends Thread
{

    volatile boolean a;
    private final BlockingQueue b;
    private final dz c;
    private final z d;
    private final iu e;

    public fa(BlockingQueue blockingqueue, dz dz1, z z1, iu iu1)
    {
        a = false;
        b = blockingqueue;
        c = dz1;
        d = z1;
        e = iu1;
    }

    public final void run()
    {
        Process.setThreadPriority(10);
_L2:
        Object obj;
        long l;
        l = SystemClock.elapsedRealtime();
        kq kq1;
        kq kq2;
        try
        {
            obj = (hx)b.take();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (a)
            {
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        ((hx) (obj)).a("network-queue-take");
        if (((hx) (obj)).j)
        {
            ((hx) (obj)).b("network-discard-cancelled");
            continue; /* Loop/switch isn't completed */
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            TrafficStats.setThreadStatsTag(((hx) (obj)).e);
        }
        Object obj1 = c.a(((hx) (obj)));
        ((hx) (obj)).a("network-http-complete");
        if (((gs) (obj1)).d && ((hx) (obj)).k)
        {
            ((hx) (obj)).b("not-modified");
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            obj1 = ((hx) (obj)).a(((gs) (obj1)));
            ((hx) (obj)).a("network-parse-complete");
            if (((hx) (obj)).i && ((is) (obj1)).b != null)
            {
                d.a(((hx) (obj)).d, ((is) (obj1)).b);
                ((hx) (obj)).a("network-cache-written");
            }
            obj.k = true;
            e.a(((hx) (obj)), ((is) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (kq kq1)
        {
            kq1.b = SystemClock.elapsedRealtime() - l;
            kq2 = hx.a(kq1);
            e.a(((hx) (obj)), kq2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            lf.a(((Throwable) (obj1)), "Unhandled exception %s", new Object[] {
                ((Exception) (obj1)).toString()
            });
            obj1 = new kq(((Throwable) (obj1)));
            obj1.b = SystemClock.elapsedRealtime() - l;
            e.a(((hx) (obj)), ((kq) (obj1)));
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
