// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.Date;

public final class s extends Thread
{

    private volatile boolean a;
    private volatile int b;
    private volatile int c;
    private volatile ao d;
    private final Handler e;
    private final Thread f;
    private final long g;
    private ag h;
    private final ab i;
    private final Runnable j;

    public s(long l, ab ab1)
    {
        this(2000L, new Handler(Looper.getMainLooper()), ab1);
    }

    private s(long l, Handler handler, ab ab1)
    {
        a = false;
        b = 0;
        j = new Runnable() {

            private s a;

            public final void run()
            {
                s.a(a);
            }

            
            {
                a = s.this;
                super();
            }
        };
        if (l < 100L)
        {
            throw new IllegalArgumentException("Detection period cannot be less than 100 ms.");
        } else
        {
            e = handler;
            g = l;
            f = Thread.currentThread();
            i = ab1;
            return;
        }
    }

    static int a(s s1)
    {
        int k = s1.b + 1;
        s1.b = k;
        return k;
    }

    public final void a()
    {
        bc.a((new StringBuilder("Terminate flag set to true. Interrupting :")).append(this).append(" to stop immediately.").toString());
        a = true;
        interrupt();
    }

    public final void a(ag ag1)
    {
        h = ag1;
    }

    public final void a(ao ao1)
    {
        d = ao1;
    }

    public final void b()
    {
        c = c - 1;
    }

    public final void c()
    {
        int k = c;
        c = k + 1;
        if (k != 0)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        this;
        JVM INSTR monitorenter ;
        notify();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void run()
    {
        int k;
        setName("ADEum-ANRDetector");
        bc.a("Starting ANRDetector");
        Process.setThreadPriority(10);
        k = -1;
_L12:
        if (a)
        {
            break MISSING_BLOCK_LABEL_317;
        }
_L8:
        int l = k;
        if (c != 0) goto _L2; else goto _L1
_L1:
        l = k;
        this;
        JVM INSTR monitorenter ;
        if (c <= 0) goto _L4; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
_L2:
        l = k;
        long l1 = System.currentTimeMillis();
        l = k;
        int i1 = b;
        l = k;
        e.post(j);
        l = k;
        Thread.sleep(g);
        l = k;
        if (i1 != b)
        {
            continue; /* Loop/switch isn't completed */
        }
        l = k;
        if (b == k)
        {
            continue; /* Loop/switch isn't completed */
        }
        l = k;
        bc.a((new StringBuilder("Reporting ANR, before = ")).append(k).append(", counter = ").append(b).toString());
        l = k;
        k = b;
        l = k;
        bc.a((new StringBuilder("Application is not responsive since: ")).append(new Date(l1)).append(". Creating ANR report.").toString());
        l = k;
        if (d == null) goto _L6; else goto _L5
_L5:
        l = k;
        if (h == null) goto _L6; else goto _L7
_L7:
        l = k;
        org.json.JSONObject jsonobject = h.a(l1, System.currentTimeMillis(), f.getStackTrace());
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        l = k;
        d.b(jsonobject);
        l = k;
        bc.a("ANR json object has been added to the MetricQueue...");
        l = k;
        try
        {
            i.a(ad.b);
        }
        catch (Throwable throwable)
        {
            p.a("Error running ANRDetector", throwable);
            bc.a("Error encountered running ANRDetector. Shutting it down...");
            a = true;
            k = l;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        wait();
_L10:
        this;
        JVM INSTR monitorexit ;
          goto _L8
        Object obj;
        obj;
        this;
        JVM INSTR monitorexit ;
        l = k;
        throw obj;
        obj;
        if (!a) goto _L10; else goto _L9
_L9:
        this;
        JVM INSTR monitorexit ;
          goto _L2
_L6:
        l = k;
        bc.a("Unable to report ANR because instrumentation has not initialized yet.");
        continue; /* Loop/switch isn't completed */
        return;
        obj;
        if (true) goto _L12; else goto _L11
_L11:
    }
}
