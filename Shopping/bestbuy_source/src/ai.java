// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class ai
    implements Runnable
{

    private long a;
    private int b;
    private ah c;

    private ai(ah ah1)
    {
        c = ah1;
        super();
        a = 30000L;
        b = 0;
    }

    ai(ah ah1, byte byte0)
    {
        this(ah1);
    }

    public final void run()
    {
        bc.a("BeaconFlusher task is about to run...");
        if (!ah.c(c))
        {
            return;
        }
        ah.d(c).c();
        try
        {
            if (ah.d(c).d())
            {
                b = 0;
                a = 30000L;
                c.b();
                return;
            }
        }
        catch (ar ar1)
        {
            bc.a((new StringBuilder("Agent disabled by collector until ")).append(ar1.a).toString());
            l l1 = l.c;
            if (l1 != null)
            {
                l1.a();
            }
            l.a(ar1.a);
            return;
        }
        ah.a(c, false);
        b = b + 1;
        if (b <= 3)
        {
            bc.a((new StringBuilder("Agent detected network error sending message to collector; trying again in ")).append(a).toString());
            ah.b(c).schedule(new aj(c, (byte)0), a, TimeUnit.MILLISECONDS);
            a = (long)Math.pow(a, 1.2D);
            return;
        }
        bc.a((new StringBuilder("Agent detected ")).append(b).append(" failures in a row; queuing messages until next start up").toString());
        return;
    }
}
