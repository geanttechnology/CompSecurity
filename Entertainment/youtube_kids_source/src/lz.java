// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.TrafficStats;
import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class lz extends Thread
{

    volatile boolean a;
    private final BlockingQueue b;
    private final ly c;
    private final lr d;
    private final ml e;

    public lz(BlockingQueue blockingqueue, ly ly1, lr lr1, ml ml1)
    {
        a = false;
        b = blockingqueue;
        c = ly1;
        d = lr1;
        e = ml1;
    }

    public final void run()
    {
        Process.setThreadPriority(10);
_L2:
        Object obj;
        mp mp1;
        mp mp2;
        try
        {
            obj = (me)b.take();
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
        ((me) (obj)).a("network-queue-take");
        if (((me) (obj)).f)
        {
            ((me) (obj)).b("network-discard-cancelled");
            continue; /* Loop/switch isn't completed */
        }
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            TrafficStats.setThreadStatsTag(((me) (obj)).b);
        }
        Object obj1 = c.a(((me) (obj)));
        ((me) (obj)).a("network-http-complete");
        if (((mb) (obj1)).d && ((me) (obj)).g)
        {
            ((me) (obj)).b("not-modified");
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            obj1 = ((me) (obj)).a(((mb) (obj1)));
            ((me) (obj)).a("network-parse-complete");
            if (((me) (obj)).e && ((mi) (obj1)).b != null)
            {
                d.a(((me) (obj)).b(), ((mi) (obj1)).b);
                ((me) (obj)).a("network-cache-written");
            }
            obj.g = true;
            e.a(((me) (obj)), ((mi) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (mp mp1)
        {
            mp2 = me.a(mp1);
            e.a(((me) (obj)), mp2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            mq.a(((Throwable) (obj1)), "Unhandled exception %s", new Object[] {
                ((Exception) (obj1)).toString()
            });
            e.a(((me) (obj)), new mp(((Throwable) (obj1))));
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
