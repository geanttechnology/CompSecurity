// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

final class buc extends bts
{

    final String a;
    final ExecutorService b;
    final long c;
    final TimeUnit d;

    buc(String s, ExecutorService executorservice, long l, TimeUnit timeunit)
    {
        a = s;
        b = executorservice;
        c = l;
        d = timeunit;
        super();
    }

    public void onRun()
    {
        try
        {
            bso.h().a("Fabric", (new StringBuilder()).append("Executing shutdown hook for ").append(a).toString());
            b.shutdown();
            if (!b.awaitTermination(c, d))
            {
                bso.h().a("Fabric", (new StringBuilder()).append(a).append(" did not shut down in the").append(" allocated time. Requesting immediate shutdown.").toString());
                b.shutdownNow();
            }
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            bso.h().a("Fabric", String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", new Object[] {
                a
            }));
        }
        b.shutdownNow();
    }
}
