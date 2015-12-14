// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;

import amazon.communication.identity.EndpointIdentity;
import amazon.communication.identity.EndpointIdentityFactory;
import com.amazon.client.metrics.Priority;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.client.metrics.configuration:
//            MetricsBatchPipelineConfiguration, BatchQueueType, BatchTransmitterType, MetricsConfigurationException, 
//            BatchPipelineConfiguration, BatchQueueConfiguration, NetworkConfiguration, TransportType, 
//            HttpConfiguration, MetricsNetworkConfiguration, CodecConfiguration, CodecType

public class MetricsConfiguration
{
    public static final class Domain extends Enum
    {

        private static final Domain $VALUES[];
        public static final Domain DEVO;
        public static final Domain MASTER;
        public static final Domain PROD;
        private String mName;

        public static Domain valueOf(String s)
        {
            return (Domain)Enum.valueOf(com/amazon/client/metrics/configuration/MetricsConfiguration$Domain, s);
        }

        public static Domain[] values()
        {
            return (Domain[])$VALUES.clone();
        }

        public String getName()
        {
            return mName;
        }

        static 
        {
            DEVO = new Domain("DEVO", 0, "devo");
            MASTER = new Domain("MASTER", 1, "master");
            PROD = new Domain("PROD", 2, "prod");
            $VALUES = (new Domain[] {
                DEVO, MASTER, PROD
            });
        }

        private Domain(String s, int i, String s1)
        {
            super(s, i);
            mName = s1;
        }
    }


    protected static MetricsBatchPipelineConfiguration sPassThroughHighPriorityPipelineConfiguration;
    protected static MetricsBatchPipelineConfiguration sPassThroughNormalPriorityPipelineConfiguration;
    private final BatchQueueConfiguration mBatchQueueConfiguration;
    private CodecConfiguration mCodecConfiguration;
    private final HttpConfiguration mHttpConfiguration;
    private NetworkConfiguration mNetworkConfiguration;
    private Map mPipelineConfigurationMap;

    public MetricsConfiguration(NetworkConfiguration networkconfiguration, BatchQueueConfiguration batchqueueconfiguration, CodecConfiguration codecconfiguration, HttpConfiguration httpconfiguration, Map map)
        throws MetricsConfigurationException
    {
        if (networkconfiguration == null)
        {
            throw new MetricsConfigurationException("NetworkConfiguration is null");
        }
        if (batchqueueconfiguration == null)
        {
            throw new MetricsConfigurationException("BatchQueueConfiguration is null");
        }
        if (codecconfiguration == null)
        {
            throw new MetricsConfigurationException("CodecConfiguration is null");
        }
        if (httpconfiguration == null)
        {
            throw new MetricsConfigurationException("HttpConfiguration is null");
        }
        if (map == null || map.isEmpty())
        {
            throw new MetricsConfigurationException("PipelineConfiguration map is null");
        }
        mNetworkConfiguration = networkconfiguration;
        mBatchQueueConfiguration = batchqueueconfiguration;
        mCodecConfiguration = codecconfiguration;
        mHttpConfiguration = httpconfiguration;
        mPipelineConfigurationMap = map;
        networkconfiguration = mPipelineConfigurationMap.keySet().iterator();
        do
        {
            if (!networkconfiguration.hasNext())
            {
                break;
            }
            batchqueueconfiguration = (Priority)networkconfiguration.next();
            if (((BatchPipelineConfiguration)mPipelineConfigurationMap.get(batchqueueconfiguration)).getBatchQueueType() == null)
            {
                ((BatchPipelineConfiguration)mPipelineConfigurationMap.get(batchqueueconfiguration)).setBatchQueueType(mBatchQueueConfiguration.getBatchQueueType());
                ((BatchPipelineConfiguration)mPipelineConfigurationMap.get(batchqueueconfiguration)).setDirectoryPrefix(mBatchQueueConfiguration.getDirectoryPrefix());
            }
        } while (true);
    }

    public MetricsConfiguration(NetworkConfiguration networkconfiguration, CodecConfiguration codecconfiguration, HttpConfiguration httpconfiguration, Map map)
        throws MetricsConfigurationException
    {
        if (networkconfiguration == null)
        {
            throw new MetricsConfigurationException("NetworkConfiguration is null");
        }
        if (codecconfiguration == null)
        {
            throw new MetricsConfigurationException("CodecConfiguration is null");
        }
        if (httpconfiguration == null)
        {
            throw new MetricsConfigurationException("HttpConfiguration is null");
        }
        if (map == null || map.isEmpty())
        {
            throw new MetricsConfigurationException("PipelineConfiguration map is null");
        }
        mNetworkConfiguration = networkconfiguration;
        mCodecConfiguration = codecconfiguration;
        mHttpConfiguration = httpconfiguration;
        mPipelineConfigurationMap = map;
        networkconfiguration = (BatchPipelineConfiguration)mPipelineConfigurationMap.get(Priority.NORMAL);
        if (networkconfiguration != null)
        {
            mBatchQueueConfiguration = new BatchQueueConfiguration(networkconfiguration.getBatchQueueType(), networkconfiguration.getDirectoryPrefix());
            return;
        } else
        {
            networkconfiguration = (BatchPipelineConfiguration)mPipelineConfigurationMap.values().iterator().next();
            mBatchQueueConfiguration = new BatchQueueConfiguration(networkconfiguration.getBatchQueueType(), networkconfiguration.getDirectoryPrefix());
            return;
        }
    }

    public String getBatchQueueDirectoryName(Priority priority)
    {
        String s = (new StringBuilder()).append(((BatchPipelineConfiguration)mPipelineConfigurationMap.get(priority)).getDirectoryPrefix()).append(priority.toString()).toString();
        priority = s;
        if (getNetworkConfiguration().getTransportType().equals(TransportType.OUTPUT_STREAM))
        {
            priority = (new StringBuilder()).append("PASSTHROUGH_").append(s).append("_NonTComm").toString();
        }
        return priority;
    }

    public CodecConfiguration getCodecConfiguration()
    {
        return mCodecConfiguration;
    }

    public EndpointIdentity getEndpointIdentity()
    {
        if (getNetworkConfiguration().getTransportType().equals(TransportType.HTTP))
        {
            return EndpointIdentityFactory.createUrlEndpointIdentity(mHttpConfiguration.getUrlEndpoint());
        } else
        {
            return EndpointIdentityFactory.createServiceIdentity("DeviceMetricsService");
        }
    }

    public HttpConfiguration getHttpConfiguration()
    {
        return mHttpConfiguration;
    }

    public NetworkConfiguration getNetworkConfiguration()
    {
        return mNetworkConfiguration;
    }

    public BatchPipelineConfiguration getPipelineConfiguration(Priority priority)
    {
        return (BatchPipelineConfiguration)mPipelineConfigurationMap.get(priority);
    }

    public EndpointIdentity getStaticCredentialEndpointIdentity()
    {
        return EndpointIdentityFactory.createUrlEndpointIdentity(mHttpConfiguration.getStaticCredentialUrlEndpoint());
    }

    public void setPassThroughMode()
        throws MetricsConfigurationException
    {
        mNetworkConfiguration = new MetricsNetworkConfiguration(TransportType.OUTPUT_STREAM, mNetworkConfiguration.getNetworkTypes());
        mCodecConfiguration = new CodecConfiguration(CodecType.STRING, "1.0");
        mPipelineConfigurationMap.clear();
        mPipelineConfigurationMap.put(Priority.NORMAL, sPassThroughNormalPriorityPipelineConfiguration);
        mPipelineConfigurationMap.put(Priority.HIGH, sPassThroughHighPriorityPipelineConfiguration);
    }

    static 
    {
        sPassThroughNormalPriorityPipelineConfiguration = new MetricsBatchPipelineConfiguration(BatchQueueType.NON_VOLATILE, "", 10000L, 500L, 10, 0x10000, 0x500000, 0x10000, 0x240c8400L, 0x5265c00L, 0x927c0L, BatchTransmitterType.PERIODIC);
        sPassThroughHighPriorityPipelineConfiguration = new MetricsBatchPipelineConfiguration(BatchQueueType.SEMI_VOLATILE, "", 1000L, 500L, 1, 0x10000, 0x100000, 0x10000, 0x240c8400L, 0x5265c00L, 0x927c0L, BatchTransmitterType.URGENT);
    }
}
