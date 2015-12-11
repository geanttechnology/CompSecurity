// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.a.a:
//            m, p, t, g, 
//            j, u, o, b

public class h extends Thread
{

    private final BlockingQueue a;
    private final g b;
    private final b c;
    private final p d;
    private volatile boolean e;

    public h(BlockingQueue blockingqueue, g g1, b b1, p p1)
    {
        e = false;
        a = blockingqueue;
        b = g1;
        c = b1;
        d = p1;
    }

    private void a(m m1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            TrafficStats.setThreadStatsTag(m1.getTrafficStatsTag());
        }
    }

    private void a(m m1, t t1)
    {
        t1 = m1.parseNetworkError(t1);
        d.a(m1, t1);
    }

    public void a()
    {
        e = true;
        interrupt();
    }

    public void run()
    {
        Process.setThreadPriority(10);
_L2:
        Object obj;
        long l;
        l = SystemClock.elapsedRealtime();
        t t1;
        try
        {
            obj = (m)a.take();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (e)
            {
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        ((m) (obj)).addMarker("network-queue-take");
        if (((m) (obj)).isCanceled())
        {
            ((m) (obj)).finish("network-discard-cancelled");
            continue; /* Loop/switch isn't completed */
        }
        a(((m) (obj)));
        Object obj1 = b.a(((m) (obj)));
        ((m) (obj)).addMarker("network-http-complete");
        if (((j) (obj1)).notModified && ((m) (obj)).hasHadResponseDelivered())
        {
            ((m) (obj)).finish("not-modified");
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            obj1 = ((m) (obj)).parseNetworkResponse(((j) (obj1)));
            ((m) (obj)).addMarker("network-parse-complete");
            if (((m) (obj)).shouldCache() && ((o) (obj1)).b != null)
            {
                c.a(((m) (obj)).getCacheKey(), ((o) (obj1)).b);
                ((m) (obj)).addMarker("network-cache-written");
            }
            ((m) (obj)).markDelivered();
            d.a(((m) (obj)), ((o) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (t t1)
        {
            t1.a(SystemClock.elapsedRealtime() - l);
            a(((m) (obj)), t1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            u.a(((Throwable) (obj1)), "Unhandled exception %s", new Object[] {
                ((Exception) (obj1)).toString()
            });
            obj1 = new t(((Throwable) (obj1)));
            ((t) (obj1)).a(SystemClock.elapsedRealtime() - l);
            d.a(((m) (obj)), ((t) (obj1)));
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
