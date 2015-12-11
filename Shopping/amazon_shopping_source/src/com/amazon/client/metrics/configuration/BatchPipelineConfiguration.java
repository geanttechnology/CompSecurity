// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;


// Referenced classes of package com.amazon.client.metrics.configuration:
//            BatchQueueType, BatchTransmitterType

public interface BatchPipelineConfiguration
{

    public abstract BatchQueueType getBatchQueueType();

    public abstract BatchTransmitterType getBatchTransmitterType();

    public abstract long getCheckBatchOpenTimeMillis();

    public abstract String getDirectoryPrefix();

    public abstract long getExpiryTimeMillis();

    public abstract long getMaxBatchOpenTimeMillis();

    public abstract long getMaxBatchQueueCapacityBytes();

    public abstract long getMaxBatchQueueEntries();

    public abstract long getMaxNumEntriesPerBatch();

    public abstract long getMaxSizePerBatchBytes();

    public abstract long getPurgePeriodMillis();

    public abstract long getTransmissionPeriodMillis();

    public abstract void setBatchQueueType(BatchQueueType batchqueuetype);

    public abstract void setDirectoryPrefix(String s);
}
