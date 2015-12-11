// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import amazon.communication.authentication.RequestSigner;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import com.amazon.client.metrics.batch.creator.BatchCreator;
import com.amazon.client.metrics.batch.queue.ByteArrayQueue;
import com.amazon.client.metrics.batch.queue.NonVolatileBoundedByteArrayQueue;
import com.amazon.client.metrics.batch.queue.SemiVolatileBoundedByteArrayQueue;
import com.amazon.client.metrics.batch.queue.VolatileBoundedByteArrayQueue;
import com.amazon.client.metrics.batch.transmitter.BatchTransmitter;
import com.amazon.client.metrics.batch.transmitter.PeriodicBatchTransmitter;
import com.amazon.client.metrics.batch.transmitter.UploadResultBroadcaster;
import com.amazon.client.metrics.batch.transmitter.UrgentBatchTransmitter;
import com.amazon.client.metrics.codec.MetricBatchProtocolBuffersCodec;
import com.amazon.client.metrics.codec.MetricBatchToStringCodec;
import com.amazon.client.metrics.codec.MetricEntryProtocolBuffersCodec;
import com.amazon.client.metrics.codec.MetricEntryToStringCodec;
import com.amazon.client.metrics.configuration.BatchPipelineConfiguration;
import com.amazon.client.metrics.configuration.BatchQueueType;
import com.amazon.client.metrics.configuration.BatchTransmitterType;
import com.amazon.client.metrics.configuration.CodecConfiguration;
import com.amazon.client.metrics.configuration.CodecType;
import com.amazon.client.metrics.configuration.HttpConfiguration;
import com.amazon.client.metrics.configuration.HttpRequestSignerType;
import com.amazon.client.metrics.configuration.MetricsConfiguration;
import com.amazon.client.metrics.configuration.MetricsConfigurationException;
import com.amazon.client.metrics.configuration.MetricsConfigurationParser;
import com.amazon.client.metrics.configuration.NetworkConfiguration;
import com.amazon.client.metrics.configuration.TransportType;
import com.amazon.client.metrics.transport.HTTPMetricsTransport;
import com.amazon.client.metrics.transport.MetricsTransport;
import com.amazon.client.metrics.transport.OAuthHelper;
import com.amazon.client.metrics.transport.OAuthRequestSigner;
import com.amazon.client.metrics.transport.OutputStreamMetricsTransport;
import com.amazon.client.metrics.trigger.TriggerEvaluator;
import com.amazon.device.utils.DeviceUtil;
import com.amazon.dp.logger.DPLogger;
import com.dp.framework.CodecException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.client.metrics:
//            MetricsFactory, AndroidMetricsFactoryImpl, PeriodicMetricReporterImpl, PeriodicMetricReporter, 
//            Priority, AndroidDeviceInfoManager, DSNOverridingDeviceInfoManager, DSNRotatingDeviceInfoManager, 
//            MetricsService, DeviceInfoManager

public class BaseMetricsServiceFactory
{

    protected static final String METRIC_LOG_FILE_NAME = "metric-log";
    private static final String OVERRIDING_UUID_KEY = "secondaryUUID";
    protected static final int PERIODIC_METRIC_REPORTER_PERIOD_MINS = 5;
    protected static final String PREF_USE_PASS_THROUGH_MODE = "PREF_USE_PASS_THROUGH_MODE";
    public static final String PROGRAM_NAME_METRICS_SERVICE = "MetricsService";
    private static final String ROTATING_UUID_KEY = "rotatingUUID";
    public static final String SOURCE_NAME_RECORD_METRIC = "RecordMetric";
    protected static final String TRANSPORT_PREF_FILENAME = "transport-preferences";
    protected static final DPLogger log = new DPLogger("BaseMetricsServiceFactory");
    protected Context mContext;
    protected final DeviceUtil mDeviceUtil;
    protected MetricsConfiguration mMetricsConfiguration;
    protected MetricsFactory mMetricsFactory;
    protected final OAuthRequestSigner mOAuthRequestSigner;
    protected PeriodicMetricReporter mPeriodicMetricReporter;
    protected long mTransmissionOffsetMillis;

    public BaseMetricsServiceFactory(Context context, DeviceUtil deviceutil)
        throws MetricsConfigurationException
    {
        this(context, deviceutil, null);
    }

    public BaseMetricsServiceFactory(Context context, DeviceUtil deviceutil, MetricsConfiguration metricsconfiguration)
        throws MetricsConfigurationException
    {
        mOAuthRequestSigner = new OAuthRequestSigner();
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null");
        }
        mContext = context;
        mDeviceUtil = deviceutil;
        deviceutil = metricsconfiguration;
        if (metricsconfiguration == null)
        {
            deviceutil = getMetricsConfiguration(context);
        }
        mMetricsConfiguration = deviceutil;
        if (shouldUsePassThroughMode(context))
        {
            mMetricsConfiguration.setPassThroughMode();
        }
        log.verbose("createMetricsService", "Getting MetricsFactory via getSystemService().", new Object[0]);
        mMetricsFactory = (MetricsFactory)mContext.getSystemService("com.amazon.client.metrics.api");
        if (mMetricsFactory == null)
        {
            log.verbose("createMetricsService", "Could not obtain MetricsFactory via context.getSystemService(). Falling back on AndroidMetricsFactoryImpl.getInstance(context)", new Object[0]);
            mMetricsFactory = AndroidMetricsFactoryImpl.getInstance(context);
        }
        mPeriodicMetricReporter = new PeriodicMetricReporterImpl(mMetricsFactory, "MetricsService", "RecordMetric");
        mPeriodicMetricReporter.startRecordingPeriodically(5L, TimeUnit.MINUTES);
        mTransmissionOffsetMillis = (long)((Math.random() * 9.2233720368547758E+18D) / 1000D) * 1000L;
    }

    private HTTPMetricsTransport createHTTPMetricsTransport()
    {
        return new HTTPMetricsTransport(mContext, mMetricsConfiguration, mDeviceUtil, createRequestSigner());
    }

    private OutputStreamMetricsTransport createOutputStreamMetricsTransport()
        throws IOException
    {
        File file = new File(mContext.getCacheDir(), "metric-log");
        file.createNewFile();
        log.info("createOutputStreamMetricsService", (new StringBuilder()).append("Metric log file: ").append(file.getAbsolutePath()).toString(), new Object[0]);
        return new OutputStreamMetricsTransport(new BufferedOutputStream(new FileOutputStream(file)));
    }

    protected long addOffset(long l, long l1)
    {
        long l2 = l1 % l;
        l1 = l2;
        if (l2 < l / 2L)
        {
            l1 = l2 + l;
        }
        return l1;
    }

    protected BatchCreator createBatchCreator(ByteArrayQueue bytearrayqueue, Priority priority, DeviceInfoManager deviceinfomanager)
        throws CodecException
    {
        priority = getBatchPipelineConfiguration(priority);
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$client$metrics$configuration$BatchQueueType[];
            static final int $SwitchMap$com$amazon$client$metrics$configuration$BatchTransmitterType[];
            static final int $SwitchMap$com$amazon$client$metrics$configuration$CodecType[];
            static final int $SwitchMap$com$amazon$client$metrics$configuration$HttpRequestSignerType[];
            static final int $SwitchMap$com$amazon$client$metrics$configuration$TransportType[];

            static 
            {
                $SwitchMap$com$amazon$client$metrics$configuration$BatchTransmitterType = new int[BatchTransmitterType.values().length];
                try
                {
                    $SwitchMap$com$amazon$client$metrics$configuration$BatchTransmitterType[BatchTransmitterType.PERIODIC.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$configuration$BatchTransmitterType[BatchTransmitterType.URGENT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                $SwitchMap$com$amazon$client$metrics$configuration$BatchQueueType = new int[BatchQueueType.values().length];
                try
                {
                    $SwitchMap$com$amazon$client$metrics$configuration$BatchQueueType[BatchQueueType.VOLATILE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$configuration$BatchQueueType[BatchQueueType.NON_VOLATILE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$configuration$BatchQueueType[BatchQueueType.SEMI_VOLATILE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                $SwitchMap$com$amazon$client$metrics$configuration$CodecType = new int[CodecType.values().length];
                try
                {
                    $SwitchMap$com$amazon$client$metrics$configuration$CodecType[CodecType.PROTOCOL_BUFFERS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$configuration$CodecType[CodecType.STRING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                $SwitchMap$com$amazon$client$metrics$configuration$HttpRequestSignerType = new int[HttpRequestSignerType.values().length];
                try
                {
                    $SwitchMap$com$amazon$client$metrics$configuration$HttpRequestSignerType[HttpRequestSignerType.OAUTH.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$amazon$client$metrics$configuration$TransportType = new int[TransportType.values().length];
                try
                {
                    $SwitchMap$com$amazon$client$metrics$configuration$TransportType[TransportType.HTTP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$client$metrics$configuration$TransportType[TransportType.OUTPUT_STREAM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.client.metrics.configuration.CodecType[mMetricsConfiguration.getCodecConfiguration().getCodecType().ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported CodecType: ").append(mMetricsConfiguration.getCodecConfiguration().getCodecType()).toString());

        case 1: // '\001'
            return new BatchCreator(bytearrayqueue, new MetricBatchProtocolBuffersCodec(), new MetricEntryProtocolBuffersCodec(), priority, mPeriodicMetricReporter, deviceinfomanager);

        case 2: // '\002'
            return new BatchCreator(bytearrayqueue, new MetricBatchToStringCodec(), new MetricEntryToStringCodec(), priority, mPeriodicMetricReporter, deviceinfomanager);
        }
    }

    protected ByteArrayQueue createBatchQueue(Priority priority)
        throws IOException
    {
        BatchPipelineConfiguration batchpipelineconfiguration = getBatchPipelineConfiguration(priority);
        switch (_cls1..SwitchMap.com.amazon.client.metrics.configuration.BatchQueueType[mMetricsConfiguration.getPipelineConfiguration(priority).getBatchQueueType().ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported BatchQueueType: ").append(mMetricsConfiguration.getPipelineConfiguration(priority).getBatchQueueType()).toString());

        case 1: // '\001'
            return new VolatileBoundedByteArrayQueue(batchpipelineconfiguration, mPeriodicMetricReporter);

        case 2: // '\002'
            return new NonVolatileBoundedByteArrayQueue(batchpipelineconfiguration, mPeriodicMetricReporter, mContext.getDir(mMetricsConfiguration.getBatchQueueDirectoryName(priority), 0));

        case 3: // '\003'
            return new SemiVolatileBoundedByteArrayQueue(batchpipelineconfiguration, mPeriodicMetricReporter, mContext.getDir(mMetricsConfiguration.getBatchQueueDirectoryName(priority), 0));
        }
    }

    protected BatchTransmitter createBatchTransmitter(ByteArrayQueue bytearrayqueue, MetricsTransport metricstransport, UploadResultBroadcaster uploadresultbroadcaster, BatchPipelineConfiguration batchpipelineconfiguration)
    {
        long l = addOffset(batchpipelineconfiguration.getTransmissionPeriodMillis(), mTransmissionOffsetMillis);
        switch (_cls1..SwitchMap.com.amazon.client.metrics.configuration.BatchTransmitterType[batchpipelineconfiguration.getBatchTransmitterType().ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported PeriodicBatchTransmitterType ").append(batchpipelineconfiguration.getBatchTransmitterType()).toString());

        case 1: // '\001'
            return new PeriodicBatchTransmitter(bytearrayqueue, metricstransport, uploadresultbroadcaster, batchpipelineconfiguration, mPeriodicMetricReporter, l);

        case 2: // '\002'
            return new UrgentBatchTransmitter(bytearrayqueue, metricstransport, uploadresultbroadcaster, batchpipelineconfiguration, mPeriodicMetricReporter, l);
        }
    }

    protected MetricsService createMetricsService()
    {
        HashMap hashmap;
        ArrayList arraylist;
        int i;
        Object obj;
        MetricsTransport metricstransport;
        UploadResultBroadcaster uploadresultbroadcaster;
        AndroidDeviceInfoManager androiddeviceinfomanager;
        Priority apriority[];
        Priority priority;
        BatchPipelineConfiguration batchpipelineconfiguration;
        ByteArrayQueue bytearrayqueue;
        int j;
        try
        {
            metricstransport = createMetricsTransport();
            uploadresultbroadcaster = new UploadResultBroadcaster(mContext);
            hashmap = new HashMap(Priority.values().length);
            arraylist = new ArrayList(Priority.values().length);
            androiddeviceinfomanager = new AndroidDeviceInfoManager(mDeviceUtil);
            apriority = Priority.values();
            j = apriority.length;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            log.error("createMetricsService", "could not serialize device info", new Object[] {
                obj
            });
            throw new RuntimeException(((Throwable) (obj)));
        }
        catch (IOException ioexception)
        {
            log.error("createMetricsService", "'could not create batch queue", new Object[] {
                ioexception
            });
            throw new RuntimeException(ioexception);
        }
        i = 0;
_L5:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        priority = apriority[i];
        batchpipelineconfiguration = getBatchPipelineConfiguration(priority);
        if (batchpipelineconfiguration != null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        log.warn("createMetricsService", "Skipping batch pipeline setup for ", new Object[] {
            priority, " because no configuration is provided."
        });
        break MISSING_BLOCK_LABEL_389;
        bytearrayqueue = createBatchQueue(priority);
        bytearrayqueue.setQueueName(priority.toString());
        if (!priority.equals(Priority.RESERVED_FOR_NON_ANONYMOUS_METRICS)) goto _L2; else goto _L1
_L1:
        obj = createBatchCreator(bytearrayqueue, priority, new DSNOverridingDeviceInfoManager(mContext, mDeviceUtil, "secondaryUUID"));
_L3:
        hashmap.put(priority, obj);
        arraylist.add(createBatchTransmitter(bytearrayqueue, metricstransport, uploadresultbroadcaster, batchpipelineconfiguration));
        break MISSING_BLOCK_LABEL_389;
_L2:
label0:
        {
            if (!priority.equals(Priority.RESERVED_FOR_LOCATION_SERVICE))
            {
                break label0;
            }
            obj = createBatchCreator(bytearrayqueue, priority, new DSNRotatingDeviceInfoManager(mContext, mDeviceUtil, "rotatingUUID"));
        }
          goto _L3
        obj = createBatchCreator(bytearrayqueue, priority, androiddeviceinfomanager);
          goto _L3
        log.verbose("createMetricsService", "Triggering intial push for stored metrics on service startup", new Object[0]);
        for (obj = arraylist.iterator(); ((Iterator) (obj)).hasNext(); ((BatchTransmitter)((Iterator) (obj)).next()).transmitBatches(false)) { }
        MetricsService metricsservice = new MetricsService(hashmap, arraylist, createTriggerEvaluator());
        return metricsservice;
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected MetricsTransport createMetricsTransport()
    {
        switch (_cls1..SwitchMap.com.amazon.client.metrics.configuration.TransportType[mMetricsConfiguration.getNetworkConfiguration().getTransportType().ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported TransportType: ").append(mMetricsConfiguration.getNetworkConfiguration().getTransportType()).toString());

        case 1: // '\001'
            return createHTTPMetricsTransport();

        case 2: // '\002'
            break;
        }
        OutputStreamMetricsTransport outputstreammetricstransport;
        try
        {
            outputstreammetricstransport = createOutputStreamMetricsTransport();
        }
        catch (IOException ioexception)
        {
            log.error("createMetricsTransport", "postInitialize failed", new Object[] {
                ioexception
            });
            throw new RuntimeException(ioexception);
        }
        return outputstreammetricstransport;
    }

    protected RequestSigner createRequestSigner()
    {
        switch (_cls1..SwitchMap.com.amazon.client.metrics.configuration.HttpRequestSignerType[mMetricsConfiguration.getHttpConfiguration().getHttpRequestSignerType().ordinal()])
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported TransportType: ").append(mMetricsConfiguration.getHttpConfiguration().getHttpRequestSignerType()).toString());

        case 1: // '\001'
            return mOAuthRequestSigner;
        }
    }

    protected TriggerEvaluator createTriggerEvaluator()
    {
        return null;
    }

    protected BatchPipelineConfiguration getBatchPipelineConfiguration(Priority priority)
    {
        return mMetricsConfiguration.getPipelineConfiguration(priority);
    }

    protected MetricsConfiguration getMetricsConfiguration(Context context)
        throws MetricsConfigurationException
    {
        try
        {
            context = (new MetricsConfigurationParser(context.getAssets().open("metrics_configuration"), context.getApplicationInfo())).parseConfiguration();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new MetricsConfigurationException("An IOException was thrown loading the metrics configuration", context);
        }
        return context;
    }

    public PeriodicMetricReporter getPeriodicMetricReporter()
    {
        return mPeriodicMetricReporter;
    }

    protected String getSessionID()
    {
        log.debug("BaseMetricsServiceFactory_getSessionID", "SessionID", new Object[] {
            mDeviceUtil.fetchSessionID()
        });
        return mDeviceUtil.fetchSessionID();
    }

    public void setOAuthHelper(OAuthHelper oauthhelper)
    {
        mOAuthRequestSigner.setOAuthHelper(oauthhelper);
    }

    protected boolean shouldUsePassThroughMode(Context context)
    {
        log.verbose("shouldUsePassThroughMode", "Looking up transport preferences at transport-preferences", new Object[0]);
        boolean flag = context.getSharedPreferences("transport-preferences", 0).getBoolean("PREF_USE_PASS_THROUGH_MODE", false);
        log.verbose("shouldUsePassThroughMode", "usePassThroughMode", new Object[] {
            Boolean.valueOf(flag)
        });
        return flag;
    }

    public void shutdown()
    {
        if (mPeriodicMetricReporter != null)
        {
            mPeriodicMetricReporter.shutdown();
        }
    }

}
