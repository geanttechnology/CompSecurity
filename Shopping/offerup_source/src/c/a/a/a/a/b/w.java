// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.b;

import c.a.a.a.e;
import c.a.a.a.q;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package c.a.a.a.a.b:
//            k

final class w extends k
{

    private String a;
    private ExecutorService b;
    private long c;
    private TimeUnit d;

    w(String s, ExecutorService executorservice, long l, TimeUnit timeunit)
    {
        a = s;
        b = executorservice;
        c = l;
        d = timeunit;
        super();
    }

    public final void onRun()
    {
        try
        {
            e.d().a("Fabric", (new StringBuilder("Executing shutdown hook for ")).append(a).toString());
            b.shutdown();
            if (!b.awaitTermination(c, d))
            {
                e.d().a("Fabric", (new StringBuilder()).append(a).append(" did not shut down in the allocated time. Requesting immediate shutdown.").toString());
                b.shutdownNow();
            }
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            e.d().a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[] {
                a
            }));
        }
        b.shutdownNow();
    }
}
