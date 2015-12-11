// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.a.a:
//            t, m, p, g, 
//            j, u, o, b

public final class h extends Thread
{

    volatile boolean a;
    private final BlockingQueue b;
    private final g c;
    private final b d;
    private final p e;

    public h(BlockingQueue blockingqueue, g g1, b b1, p p1)
    {
        a = false;
        b = blockingqueue;
        c = g1;
        d = b1;
        e = p1;
    }

    public final void run()
    {
        Process.setThreadPriority(10);
_L2:
        Object obj;
        long l;
        l = SystemClock.elapsedRealtime();
        t t1;
        t t2;
        try
        {
            obj = (m)b.take();
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
        ((m) (obj)).addMarker("network-queue-take");
        if (((m) (obj)).isCanceled())
        {
            ((m) (obj)).finish("network-discard-cancelled");
            continue; /* Loop/switch isn't completed */
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            TrafficStats.setThreadStatsTag(((m) (obj)).getTrafficStatsTag());
        }
        Object obj1 = c.a(((m) (obj)));
        ((m) (obj)).addMarker("network-http-complete");
        if (((j) (obj1)).d && ((m) (obj)).hasHadResponseDelivered())
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
                d.a(((m) (obj)).getCacheKey(), ((o) (obj1)).b);
                ((m) (obj)).addMarker("network-cache-written");
            }
            ((m) (obj)).markDelivered();
            e.a(((m) (obj)), ((o) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (t t1)
        {
            t1.b = SystemClock.elapsedRealtime() - l;
            t2 = ((m) (obj)).parseNetworkError(t1);
            e.a(((m) (obj)), t2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            u.a(((Throwable) (obj1)), "Unhandled exception %s", new Object[] {
                ((Exception) (obj1)).toString()
            });
            obj1 = new t(((Throwable) (obj1)));
            obj1.b = SystemClock.elapsedRealtime() - l;
            e.a(((m) (obj)), ((t) (obj1)));
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
