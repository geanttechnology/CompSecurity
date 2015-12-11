// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package bolts;

import java.util.concurrent.ScheduledFuture;

// Referenced classes of package bolts:
//            Task

static final class ect
    implements Runnable
{

    final ScheduledFuture val$scheduled;
    final skCompletionSource val$tcs;

    public void run()
    {
        val$scheduled.cancel(true);
        val$tcs.trySetCancelled();
    }

    ource(ScheduledFuture scheduledfuture, skCompletionSource skcompletionsource)
    {
        val$scheduled = scheduledfuture;
        val$tcs = skcompletionsource;
        super();
    }
}
