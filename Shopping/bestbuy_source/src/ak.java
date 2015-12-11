// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

final class ak
    implements Runnable
{

    private ah a;

    private ak(ah ah1)
    {
        a = ah1;
        super();
    }

    ak(ah ah1, byte byte0)
    {
        this(ah1);
    }

    public final void run()
    {
        if (!ah.c(a))
        {
            bc.a("Agent persisting beacon queue state");
            ah.d(a).b();
            ah.b(a).schedule(this, 30000L, TimeUnit.MILLISECONDS);
        }
    }
}
