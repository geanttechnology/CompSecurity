// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.mopub.d:
//            s, l, o, f, 
//            i, t, n, b

public final class g extends Thread
{

    volatile boolean a;
    private final BlockingQueue b;
    private final f c;
    private final b d;
    private final o e;

    public g(BlockingQueue blockingqueue, f f1, b b1, o o1)
    {
        a = false;
        b = blockingqueue;
        c = f1;
        d = b1;
        e = o1;
    }

    public final void run()
    {
        Process.setThreadPriority(10);
_L2:
        Object obj;
        long l1;
        l1 = SystemClock.elapsedRealtime();
        s s1;
        s s2;
        try
        {
            obj = (l)b.take();
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
        ((l) (obj)).a("network-queue-take");
        if (((l) (obj)).h)
        {
            ((l) (obj)).b("network-discard-cancelled");
            continue; /* Loop/switch isn't completed */
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            TrafficStats.setThreadStatsTag(((l) (obj)).c);
        }
        Object obj1 = c.a(((l) (obj)));
        ((l) (obj)).a("network-http-complete");
        if (((i) (obj1)).d && ((l) (obj)).i)
        {
            ((l) (obj)).b("not-modified");
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            obj1 = ((l) (obj)).a(((i) (obj1)));
            ((l) (obj)).a("network-parse-complete");
            if (((l) (obj)).g && ((n) (obj1)).b != null)
            {
                d.a(((l) (obj)).b, ((n) (obj1)).b);
                ((l) (obj)).a("network-cache-written");
            }
            obj.i = true;
            e.a(((l) (obj)), ((n) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (s s1)
        {
            s1.d = SystemClock.elapsedRealtime() - l1;
            s2 = l.a(s1);
            e.a(((l) (obj)), s2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            t.a(((Throwable) (obj1)), "Unhandled exception %s", new Object[] {
                ((Exception) (obj1)).toString()
            });
            obj1 = new s(((Throwable) (obj1)));
            obj1.d = SystemClock.elapsedRealtime() - l1;
            e.a(((l) (obj)), ((s) (obj1)));
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
