// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package android.support.v7:
//            ve, vy, xs, qs, 
//            tv, yd, vw, mo

public class rt extends Thread
{

    private final BlockingQueue a;
    private final qs b;
    private final mo c;
    private final vy d;
    private volatile boolean e;

    public rt(BlockingQueue blockingqueue, qs qs1, mo mo1, vy vy1)
    {
        e = false;
        a = blockingqueue;
        b = qs1;
        c = mo1;
        d = vy1;
    }

    private void a(ve ve1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            TrafficStats.setThreadStatsTag(ve1.c());
        }
    }

    private void a(ve ve1, xs xs1)
    {
        xs1 = ve1.a(xs1);
        d.a(ve1, xs1);
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
        xs xs1;
        try
        {
            obj = (ve)a.take();
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
        ((ve) (obj)).b("network-queue-take");
        if (((ve) (obj)).g())
        {
            ((ve) (obj)).c("network-discard-cancelled");
            continue; /* Loop/switch isn't completed */
        }
        a(((ve) (obj)));
        Object obj1 = b.a(((ve) (obj)));
        ((ve) (obj)).b("network-http-complete");
        if (((tv) (obj1)).d && ((ve) (obj)).u())
        {
            ((ve) (obj)).c("not-modified");
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            obj1 = ((ve) (obj)).a(((tv) (obj1)));
            ((ve) (obj)).b("network-parse-complete");
            if (((ve) (obj)).p() && ((vw) (obj1)).b != null)
            {
                c.a(((ve) (obj)).e(), ((vw) (obj1)).b);
                ((ve) (obj)).b("network-cache-written");
            }
            ((ve) (obj)).t();
            d.a(((ve) (obj)), ((vw) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (xs xs1)
        {
            xs1.a(SystemClock.elapsedRealtime() - l);
            a(((ve) (obj)), xs1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            yd.a(((Throwable) (obj1)), "Unhandled exception %s", new Object[] {
                ((Exception) (obj1)).toString()
            });
            obj1 = new xs(((Throwable) (obj1)));
            ((xs) (obj1)).a(SystemClock.elapsedRealtime() - l);
            d.a(((ve) (obj)), ((xs) (obj1)));
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
