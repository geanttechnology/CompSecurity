// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.amazon.client.metrics.configuration.BatchQueueType;
import com.amazon.client.metrics.configuration.BatchTransmitterType;
import com.amazon.client.metrics.configuration.CodecType;
import com.amazon.client.metrics.configuration.HttpRequestSignerType;
import com.amazon.client.metrics.configuration.TransportType;

// Referenced classes of package com.amazon.client.metrics:
//            BaseMetricsServiceFactory

static class nerType
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
