// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.common.util.concurrent:
//            AbstractScheduledService, AbstractService

public static abstract class <init>
{

    public static <init> newFixedDelaySchedule(long l, long l1, TimeUnit timeunit)
    {
        Preconditions.checkNotNull(timeunit);
        boolean flag;
        if (l1 > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "delay must be > 0, found %s", new Object[] {
            Long.valueOf(l1)
        });
        return new AbstractScheduledService.Scheduler(l, l1, timeunit) {

            final long val$delay;
            final long val$initialDelay;
            final TimeUnit val$unit;

            public Future schedule(AbstractService abstractservice, ScheduledExecutorService scheduledexecutorservice, Runnable runnable)
            {
                return scheduledexecutorservice.scheduleWithFixedDelay(runnable, initialDelay, delay, unit);
            }

            
            {
                initialDelay = l;
                delay = l1;
                unit = timeunit;
                super(null);
            }
        };
    }

    public static _cls1.val.unit newFixedRateSchedule(long l, long l1, TimeUnit timeunit)
    {
        Preconditions.checkNotNull(timeunit);
        boolean flag;
        if (l1 > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "period must be > 0, found %s", new Object[] {
            Long.valueOf(l1)
        });
        return new AbstractScheduledService.Scheduler(l, l1, timeunit) {

            final long val$initialDelay;
            final long val$period;
            final TimeUnit val$unit;

            public Future schedule(AbstractService abstractservice, ScheduledExecutorService scheduledexecutorservice, Runnable runnable)
            {
                return scheduledexecutorservice.scheduleAtFixedRate(runnable, initialDelay, period, unit);
            }

            
            {
                initialDelay = l;
                period = l1;
                unit = timeunit;
                super(null);
            }
        };
    }

    abstract Future schedule(AbstractService abstractservice, ScheduledExecutorService scheduledexecutorservice, Runnable runnable);

    private <init>()
    {
    }

    <init>(<init> <init>1)
    {
        this();
    }
}
