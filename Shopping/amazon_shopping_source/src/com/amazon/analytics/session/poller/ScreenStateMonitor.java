// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session.poller;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScreenStateMonitor
    implements ScreenStateBroadcastReceiver.ScreenStateChangeListener
{

    private final int pollSeconds;
    private Future pollerTask;
    private final Runnable runner;
    private final ScheduledExecutorService scheduledService;

    public ScreenStateMonitor(ScheduledExecutorService scheduledexecutorservice, Runnable runnable, int i)
    {
        scheduledService = scheduledexecutorservice;
        runner = runnable;
        pollSeconds = i;
        pollerTask = scheduledexecutorservice.scheduleAtFixedRate(runnable, 0L, i, TimeUnit.SECONDS);
    }

    public void onScreenOff()
    {
        if (pollerTask != null)
        {
            pollerTask.cancel(false);
            scheduledService.execute(runner);
            pollerTask = null;
        }
    }

    public void onScreenOn()
    {
        if (pollerTask == null)
        {
            pollerTask = scheduledService.scheduleAtFixedRate(runner, pollSeconds, pollSeconds, TimeUnit.SECONDS);
        }
    }
}
