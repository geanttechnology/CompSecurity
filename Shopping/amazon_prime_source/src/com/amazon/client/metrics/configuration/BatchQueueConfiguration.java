// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;


// Referenced classes of package com.amazon.client.metrics.configuration:
//            MetricsConfigurationException, BatchQueueType

public class BatchQueueConfiguration
{

    private BatchQueueType mBatchQueueType;
    private String mDirectoryPrefix;

    public BatchQueueConfiguration(BatchQueueType batchqueuetype, String s)
        throws MetricsConfigurationException
    {
        if (batchqueuetype == null)
        {
            throw new MetricsConfigurationException("batchQueueType is null in configuration");
        }
        if (s == null)
        {
            throw new MetricsConfigurationException("directoryPrefix is null in configuration");
        } else
        {
            mBatchQueueType = batchqueuetype;
            mDirectoryPrefix = s;
            return;
        }
    }

    public BatchQueueType getBatchQueueType()
    {
        return mBatchQueueType;
    }

    public String getDirectoryPrefix()
    {
        return mDirectoryPrefix;
    }
}
