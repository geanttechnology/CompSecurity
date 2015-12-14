// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.client.metrics:
//            PeriodicMetricReporter, MetricEventType, Priority, MetricsFactory, 
//            MetricEvent

public class PeriodicMetricReporterImpl
    implements PeriodicMetricReporter
{
    protected final class PeriodicCommand
        implements Runnable
    {

        private final AtomicBoolean mIsActive = new AtomicBoolean(true);
        final PeriodicMetricReporterImpl this$0;

        public void run()
        {
            if (!mIsActive.get())
            {
                break MISSING_BLOCK_LABEL_17;
            }
            recordMetricEvent();
            return;
            Throwable throwable;
            throwable;
        }

        public PeriodicCommand()
        {
            this$0 = PeriodicMetricReporterImpl.this;
            super();
        }
    }


    protected final Collection mAdditionalMetricEvents;
    protected final PeriodicCommand mCommand;
    protected final MetricEvent mMetricEvent;
    protected final MetricsFactory mMetricsFactory;
    protected final Priority mPriority;
    protected final ScheduledExecutorService mThreadPool;

    public PeriodicMetricReporterImpl(MetricsFactory metricsfactory, String s, String s1)
    {
        this(metricsfactory, s, s1, MetricEventType.getDefault());
    }

    public PeriodicMetricReporterImpl(MetricsFactory metricsfactory, String s, String s1, MetricEventType metriceventtype)
    {
        this(metricsfactory, s, s1, metriceventtype, Priority.NORMAL);
    }

    public PeriodicMetricReporterImpl(MetricsFactory metricsfactory, String s, String s1, MetricEventType metriceventtype, Priority priority)
    {
        if (metricsfactory == null)
        {
            throw new IllegalArgumentException("Argument: factory cannot be null.");
        }
        if (s == null || s.trim().length() == 0)
        {
            throw new IllegalArgumentException("Argument: program cannot be null or empty.");
        }
        if (s1 == null || s1.trim().length() == 0)
        {
            throw new IllegalArgumentException("Argument: source cannot be null or empty.");
        } else
        {
            mMetricsFactory = metricsfactory;
            mCommand = new PeriodicCommand();
            mThreadPool = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {

                final PeriodicMetricReporterImpl this$0;

                public Thread newThread(Runnable runnable)
                {
                    runnable = new Thread(runnable, "PeriodicMetricReporterThread");
                    runnable.setPriority(4);
                    return runnable;
                }

            
            {
                this$0 = PeriodicMetricReporterImpl.this;
                super();
            }
            });
            mAdditionalMetricEvents = new HashSet();
            mMetricEvent = mMetricsFactory.createConcurrentMetricEvent(s, s1, metriceventtype, true);
            mPriority = priority;
            return;
        }
    }

    private void recordMetricEvent()
    {
        if (!mMetricEvent.getAsDataPoints().isEmpty())
        {
            mMetricsFactory.record(mMetricEvent, mPriority);
        }
        HashSet hashset;
        synchronized (mAdditionalMetricEvents)
        {
            hashset = new HashSet(mAdditionalMetricEvents);
        }
        obj = hashset.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            MetricEvent metricevent = (MetricEvent)((Iterator) (obj)).next();
            if (!metricevent.getAsDataPoints().isEmpty())
            {
                mMetricsFactory.record(metricevent, mPriority);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_117;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public MetricEvent getMetricEvent()
    {
        return mMetricEvent;
    }

    public void startRecordingPeriodically(long l, TimeUnit timeunit)
    {
        mThreadPool.scheduleAtFixedRate(mCommand, l, l, timeunit);
    }

}
