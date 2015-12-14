// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.creator;

import com.amazon.client.metrics.DeviceInfoManager;
import com.amazon.client.metrics.MetricBatch;
import com.amazon.client.metrics.MetricEntry;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsDeviceInfo;
import com.amazon.client.metrics.PeriodicMetricReporter;
import com.amazon.client.metrics.batch.queue.ByteArrayQueue;
import com.amazon.client.metrics.codec.EncodedMetricEntry;
import com.amazon.client.metrics.codec.MetricBatchCodec;
import com.amazon.client.metrics.codec.MetricEntryCodec;
import com.amazon.client.metrics.configuration.BatchPipelineConfiguration;
import com.amazon.device.utils.BackgroundThreadFactory;
import com.amazon.dp.logger.DPLogger;
import com.dp.framework.CodecException;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class BatchCreator
{
    private class BatchOpenTimeWatcher
        implements Callable
    {

        final BatchCreator this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public Void call()
            throws Exception
        {
            checkBatchOpenTimeAndEnqueueIfReady();
            scheduleBatchOpenTimeWatcher();
            return null;
        }

        private BatchOpenTimeWatcher()
        {
            this$0 = BatchCreator.this;
            super();
        }

    }


    private static final DPLogger log = new DPLogger("Metrics:BatchCreator");
    private final BatchOpenTimeWatcher mBatchOpenTimeWatcher = new BatchOpenTimeWatcher();
    private final BatchPipelineConfiguration mBatchPipelineConfiguration;
    private final ByteArrayQueue mBatchQueue;
    private final DeviceInfoManager mDeviceInfoManager;
    private final MetricBatchCodec mMetricBatchCodec;
    private final MetricEntryCodec mMetricEntryCodec;
    private final PeriodicMetricReporter mPeriodicMetricReporter;
    private MetricBatch mRunningBatch;
    protected final ScheduledExecutorService mThreadPool = Executors.newSingleThreadScheduledExecutor(new BackgroundThreadFactory());
    private final AtomicLong mTimeSinceLastPublish = new AtomicLong();

    public BatchCreator(ByteArrayQueue bytearrayqueue, MetricBatchCodec metricbatchcodec, MetricEntryCodec metricentrycodec, BatchPipelineConfiguration batchpipelineconfiguration, PeriodicMetricReporter periodicmetricreporter, DeviceInfoManager deviceinfomanager)
        throws CodecException
    {
        mBatchQueue = bytearrayqueue;
        mMetricBatchCodec = metricbatchcodec;
        mMetricEntryCodec = metricentrycodec;
        mBatchPipelineConfiguration = batchpipelineconfiguration;
        mTimeSinceLastPublish.set(System.currentTimeMillis());
        mDeviceInfoManager = deviceinfomanager;
        mRunningBatch = new MetricBatch();
        mPeriodicMetricReporter = periodicmetricreporter;
        scheduleBatchOpenTimeWatcher();
    }

    private void checkBatchOpenTimeAndEnqueueIfReady()
    {
        this;
        JVM INSTR monitorenter ;
        if (maxBatchOpenTimeReached() && mRunningBatch.containsUserMetrics())
        {
            enqueueBatchForTransmission();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean maxBatchCountReached()
    {
        return (long)mRunningBatch.getMetricEntryCount() >= mBatchPipelineConfiguration.getMaxNumEntriesPerBatch();
    }

    private boolean maxBatchOpenTimeReached()
    {
        return System.currentTimeMillis() - mTimeSinceLastPublish.get() >= mBatchPipelineConfiguration.getMaxBatchOpenTimeMillis();
    }

    private void scheduleBatchOpenTimeWatcher()
    {
        try
        {
            mThreadPool.schedule(mBatchOpenTimeWatcher, mBatchPipelineConfiguration.getCheckBatchOpenTimeMillis(), TimeUnit.MILLISECONDS);
            return;
        }
        catch (RejectedExecutionException rejectedexecutionexception)
        {
            log.error("scheduleLastPublishTimeWatcher", "Unexpected rejected execution exception while scheduling LastPublishTimeWatcher", new Object[] {
                rejectedexecutionexception
            });
            throw rejectedexecutionexception;
        }
    }

    public void addMetricEntry(MetricEntry metricentry)
    {
        this;
        JVM INSTR monitorenter ;
        if (metricentry != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("Cannot add null metric entry");
        metricentry;
        this;
        JVM INSTR monitorexit ;
        throw metricentry;
        EncodedMetricEntry encodedmetricentry = mMetricEntryCodec.encode(metricentry);
        if (encodedmetricentry == null) goto _L2; else goto _L1
_L1:
        if (encodedmetricentry.getEncodedSize() != 0) goto _L3; else goto _L2
_L2:
        throw new IllegalArgumentException("Metric entry serialized to null or nothing.");
        metricentry;
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("addEntry.CodecException", 1.0D);
        log.error("add", "Codec Exception while trying to add metric to batch.", new Object[] {
            metricentry
        });
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        log.debug("addMetricEntry", "Adding metric entry", new Object[] {
            "metricEntry", metricentry.toString()
        });
        mRunningBatch.addEntry(encodedmetricentry);
        if (!"MetricsService".equals(metricentry.getProgram()) || !"RecordMetric".equals(metricentry.getSource()))
        {
            mRunningBatch.setContainsUserMetrics(true);
        }
        if (maxBatchCountReached() || maxBatchSizeReached())
        {
            enqueueBatchForTransmission();
        }
          goto _L4
        metricentry;
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("addEntry.UnexpectedException", 1.0D);
        log.error("add", "Unexpected exception while trying to add metric to batch.", new Object[] {
            metricentry
        });
          goto _L4
    }

    public void enqueueBatchForTransmission()
    {
        this;
        JVM INSTR monitorenter ;
        if (mRunningBatch.getBatchSizeInBytes() != 0L) goto _L2; else goto _L1
_L1:
        log.debug("enqueueBatchForTransmission", "Metrics Batch is empty. Aborting enqueue operation.", new Object[0]);
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!maxBatchCountReached()) goto _L4; else goto _L3
_L3:
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("enqueueReason.batchCount", 1.0D);
_L6:
        MetricsDeviceInfo metricsdeviceinfo = mDeviceInfoManager.getDeviceInfo();
        mRunningBatch.putMetricsDeviceInfo(metricsdeviceinfo.getDeviceInfo());
        log.debug("enqueueBatchForTransmission", "Metrics Batch created. Adding to queue", new Object[0]);
        byte abyte0[] = mMetricBatchCodec.encode(mRunningBatch);
        mBatchQueue.add(abyte0, true);
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("BATCH_COUNT", mRunningBatch.getMetricEntryCount());
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("BATCH_SIZE", mRunningBatch.getBatchSizeInBytes());
        mPeriodicMetricReporter.getMetricEvent().addTimer("BATCH_OPEN_TIME", System.currentTimeMillis() - mTimeSinceLastPublish.get());
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("BATCH_ENQUEUED", 1.0D);
_L7:
        mRunningBatch = new MetricBatch();
        mTimeSinceLastPublish.set(System.currentTimeMillis());
          goto _L5
        Object obj;
        obj;
        throw obj;
_L4:
label0:
        {
            if (!maxBatchSizeReached())
            {
                break label0;
            }
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("enqueueReason.batchSize", 1.0D);
        }
          goto _L6
label1:
        {
            if (!maxBatchOpenTimeReached())
            {
                break label1;
            }
            mPeriodicMetricReporter.getMetricEvent().incrementCounter("enqueueReason.batchOpenTime", 1.0D);
        }
          goto _L6
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("enqueueReason.forceEnqueue", 1.0D);
          goto _L6
        obj;
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("enqueBatch.CodecException", 1.0D);
        log.error("enqueueBatchForTransmission", "Exception trying to serialize metrics batch", new Object[] {
            obj
        });
          goto _L7
        obj;
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("enqueBatch.IOException", 1.0D);
        log.error("enqueueBatchForTransmission", "IOException while trying to add metrics batch to queue.", new Object[] {
            obj
        });
          goto _L7
        obj;
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("enqueBatch.IllegalArgumentException", 1.0D);
        log.error("enqueueBatchForTransmission", "IllegalArguementException while trying to add metrics batch to queue", new Object[] {
            obj
        });
          goto _L7
        obj;
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("enqueBatch.UnknownException", 1.0D);
        log.error("enqueueBatchForTransmission", "Unexpected Exception while trying to add metrics batch to queue", new Object[] {
            obj
        });
          goto _L7
    }

    protected boolean maxBatchSizeReached()
    {
        return mRunningBatch.getBatchSizeInBytes() >= mBatchPipelineConfiguration.getMaxSizePerBatchBytes();
    }



}
