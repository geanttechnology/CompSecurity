// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;


// Referenced classes of package com.amazon.client.metrics.configuration:
//            BatchPipelineConfiguration, BoundedNumberEvaluator, BatchQueueType, BatchTransmitterType

public class MetricsBatchPipelineConfiguration
    implements BatchPipelineConfiguration
{

    private BatchQueueType mBatchQueueType;
    private final BatchTransmitterType mBatchTransmitterType;
    private final BoundedNumberEvaluator mBoundedCheckBatchOpenTimeMillis;
    private final BoundedNumberEvaluator mBoundedExpiryTimeMillis;
    private final BoundedNumberEvaluator mBoundedMaxBatchOpenTimeMillis;
    private final BoundedNumberEvaluator mBoundedMaxBatchQueueCapacityBytes;
    private final BoundedNumberEvaluator mBoundedMaxBatchQueueEntries;
    private final BoundedNumberEvaluator mBoundedMaxNumEntriesPerBatch;
    private final BoundedNumberEvaluator mBoundedMaxSizePerBatchBytes;
    private final BoundedNumberEvaluator mBoundedPurgePeriodMillis;
    private final BoundedNumberEvaluator mBoundedTransmissionPeriodMillis;
    private String mDirectoryPrefix;

    public MetricsBatchPipelineConfiguration(BatchQueueType batchqueuetype, String s, long l, long l1, int i, 
            int j, int k, int i1, long l2, long l3, 
            long l4, BatchTransmitterType batchtransmittertype)
    {
        mBatchQueueType = batchqueuetype;
        mDirectoryPrefix = s;
        mBoundedMaxBatchOpenTimeMillis = new BoundedNumberEvaluator("MaxBatchOpenTimeMillis", 500L, 0x240c8400L, l);
        mBoundedCheckBatchOpenTimeMillis = new BoundedNumberEvaluator("CheckBatchOpenTimeMillis", 500L, 0x5265c00L, l1);
        mBoundedMaxBatchQueueCapacityBytes = new BoundedNumberEvaluator("MaxBatchQueueCapacityBytes", 1024L, 0xa00000L, k);
        mBoundedMaxNumEntriesPerBatch = new BoundedNumberEvaluator("MaxBatchEntries", 1L, 0xf4240L, i);
        mBoundedMaxSizePerBatchBytes = new BoundedNumberEvaluator("MaxBatchSizeBytes", 1024L, 0x100000L, j);
        mBoundedMaxBatchQueueEntries = new BoundedNumberEvaluator("MaxBatchQueueEntries", 1L, 10000L, i1);
        mBoundedExpiryTimeMillis = new BoundedNumberEvaluator("ExpiryTimeMillis", 0x5265c00L, 0xe7be2c00L, l2);
        mBoundedPurgePeriodMillis = new BoundedNumberEvaluator("PurgePeriodMillis", 0x36ee80L, 0xf731400L, l3);
        mBoundedTransmissionPeriodMillis = new BoundedNumberEvaluator("TransmissionPeriodMillis", 10000L, 0x5265c00L, l4);
        mBatchTransmitterType = batchtransmittertype;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (MetricsBatchPipelineConfiguration)obj;
            if (((MetricsBatchPipelineConfiguration) (obj)).getBatchQueueType() != getBatchQueueType() || !((MetricsBatchPipelineConfiguration) (obj)).getDirectoryPrefix().equals(getDirectoryPrefix()) || ((MetricsBatchPipelineConfiguration) (obj)).getCheckBatchOpenTimeMillis() != getCheckBatchOpenTimeMillis() || ((MetricsBatchPipelineConfiguration) (obj)).getMaxBatchOpenTimeMillis() != getMaxBatchOpenTimeMillis() || ((MetricsBatchPipelineConfiguration) (obj)).getMaxBatchQueueEntries() != getMaxBatchQueueEntries() || ((MetricsBatchPipelineConfiguration) (obj)).getMaxBatchQueueCapacityBytes() != getMaxBatchQueueCapacityBytes() || ((MetricsBatchPipelineConfiguration) (obj)).getMaxNumEntriesPerBatch() != getMaxNumEntriesPerBatch() || ((MetricsBatchPipelineConfiguration) (obj)).getMaxSizePerBatchBytes() != getMaxSizePerBatchBytes() || ((MetricsBatchPipelineConfiguration) (obj)).getExpiryTimeMillis() != getExpiryTimeMillis() || ((MetricsBatchPipelineConfiguration) (obj)).getPurgePeriodMillis() != getPurgePeriodMillis() || ((MetricsBatchPipelineConfiguration) (obj)).getTransmissionPeriodMillis() != getTransmissionPeriodMillis() || ((MetricsBatchPipelineConfiguration) (obj)).getBatchTransmitterType() != getBatchTransmitterType())
            {
                return false;
            }
        }
        return true;
    }

    public BatchQueueType getBatchQueueType()
    {
        return mBatchQueueType;
    }

    public BatchTransmitterType getBatchTransmitterType()
    {
        return mBatchTransmitterType;
    }

    public long getCheckBatchOpenTimeMillis()
    {
        return mBoundedCheckBatchOpenTimeMillis.getValue();
    }

    public String getDirectoryPrefix()
    {
        return mDirectoryPrefix;
    }

    public long getExpiryTimeMillis()
    {
        return mBoundedExpiryTimeMillis.getValue();
    }

    public long getMaxBatchOpenTimeMillis()
    {
        return mBoundedMaxBatchOpenTimeMillis.getValue();
    }

    public long getMaxBatchQueueCapacityBytes()
    {
        return mBoundedMaxBatchQueueCapacityBytes.getValue();
    }

    public long getMaxBatchQueueEntries()
    {
        return mBoundedMaxBatchQueueEntries.getValue();
    }

    public long getMaxNumEntriesPerBatch()
    {
        return mBoundedMaxNumEntriesPerBatch.getValue();
    }

    public long getMaxSizePerBatchBytes()
    {
        return mBoundedMaxSizePerBatchBytes.getValue();
    }

    public long getPurgePeriodMillis()
    {
        return mBoundedPurgePeriodMillis.getValue();
    }

    public long getTransmissionPeriodMillis()
    {
        return mBoundedTransmissionPeriodMillis.getValue();
    }

    public int hashCode()
    {
        return getBatchQueueType().hashCode() + getDirectoryPrefix().hashCode() + (new Long(getCheckBatchOpenTimeMillis())).hashCode() + (new Long(getMaxBatchOpenTimeMillis())).hashCode() + (new Long(getMaxBatchQueueEntries())).hashCode() + (new Long(getMaxBatchQueueCapacityBytes())).hashCode() + (new Long(getMaxNumEntriesPerBatch())).hashCode() + (new Long(getMaxSizePerBatchBytes())).hashCode() + (new Long(getExpiryTimeMillis())).hashCode() + (new Long(getPurgePeriodMillis())).hashCode() + (new Long(getTransmissionPeriodMillis())).hashCode() + getBatchTransmitterType().hashCode();
    }

    public void setBatchQueueType(BatchQueueType batchqueuetype)
    {
        if (mBatchQueueType == null)
        {
            mBatchQueueType = batchqueuetype;
        }
    }

    public void setDirectoryPrefix(String s)
    {
        if (mDirectoryPrefix == null)
        {
            mDirectoryPrefix = s;
        }
    }
}
