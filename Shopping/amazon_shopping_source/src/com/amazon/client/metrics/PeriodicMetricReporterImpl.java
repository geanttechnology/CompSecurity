// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.client.metrics:
//            PeriodicMetricReporter, MetricEventType, MetricsFactory, MetricEvent

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

        public void shutdown()
        {
            mIsActive.set(false);
        }

        public PeriodicCommand()
        {
            this$0 = PeriodicMetricReporterImpl.this;
            super();
        }
    }


    private static final long SHUTDOWN_TIMEOUT_MS = 2000L;
    protected final List mAdditionalMetricEvents;
    protected final PeriodicCommand mCommand;
    protected final MetricEvent mMetricEvent;
    protected final MetricsFactory mMetricsFactory;
    protected final ScheduledExecutorService mThreadPool;

    public PeriodicMetricReporterImpl(MetricsFactory metricsfactory, String s, String s1)
    {
        this(metricsfactory, s, s1, MetricEventType.getDefault());
    }

    public PeriodicMetricReporterImpl(MetricsFactory metricsfactory, String s, String s1, MetricEventType metriceventtype)
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
                    return new Thread(runnable, "PeriodicMetricReporterThread");
                }

            
            {
                this$0 = PeriodicMetricReporterImpl.this;
                super();
            }
            });
            mAdditionalMetricEvents = new ArrayList();
            mMetricEvent = mMetricsFactory.createConcurrentMetricEvent(s, s1, metriceventtype, true);
            return;
        }
    }

    private void recordMetricEvent()
    {
        mMetricsFactory.record(mMetricEvent);
        List list = mAdditionalMetricEvents;
        list;
        JVM INSTR monitorenter ;
        MetricEvent metricevent;
        for (Iterator iterator = mAdditionalMetricEvents.iterator(); iterator.hasNext(); mMetricsFactory.record(metricevent))
        {
            metricevent = (MetricEvent)iterator.next();
        }

        break MISSING_BLOCK_LABEL_67;
        Exception exception;
        exception;
        list;
        JVM INSTR monitorexit ;
        throw exception;
        list;
        JVM INSTR monitorexit ;
    }

    public MetricEvent createTrackedMetricEvent(String s, String s1)
    {
        return createTrackedMetricEvent(s, s1, MetricEventType.getDefault());
    }

    public MetricEvent createTrackedMetricEvent(String s, String s1, MetricEventType metriceventtype)
    {
        synchronized (mAdditionalMetricEvents)
        {
            s = mMetricsFactory.createConcurrentMetricEvent(s, s1, metriceventtype);
            mAdditionalMetricEvents.add(s);
        }
        return s;
        s;
        list;
        JVM INSTR monitorexit ;
        throw s;
    }

    public MetricEvent getMetricEvent()
    {
        return mMetricEvent;
    }

    public void shutdown()
    {
label0:
        {
            mCommand.shutdown();
            mThreadPool.shutdown();
            boolean flag;
            try
            {
                if (mThreadPool.awaitTermination(2000L, TimeUnit.MILLISECONDS))
                {
                    break label0;
                }
                mThreadPool.shutdownNow();
                flag = mThreadPool.awaitTermination(2000L, TimeUnit.MILLISECONDS);
            }
            catch (InterruptedException interruptedexception)
            {
                Thread.currentThread().interrupt();
                return;
            }
            if (flag);
        }
    }

    public void startRecordingPeriodically(long l, TimeUnit timeunit)
    {
        mThreadPool.scheduleAtFixedRate(mCommand, l, l, timeunit);
    }

    public void stopTrackingMetricEvent(MetricEvent metricevent)
    {
label0:
        {
            synchronized (mAdditionalMetricEvents)
            {
                if (mAdditionalMetricEvents.remove(metricevent))
                {
                    break label0;
                }
            }
            return;
        }
        list;
        JVM INSTR monitorexit ;
        mMetricsFactory.record(metricevent);
        return;
        metricevent;
        list;
        JVM INSTR monitorexit ;
        throw metricevent;
    }

}
