// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.amazon.client.metrics.DataPointType;

// Referenced classes of package com.amazon.client.metrics.codec:
//            MetricEntryProtocolBuffersCodec

static class 
{

    static final int $SwitchMap$com$amazon$client$metrics$DataPointType[];

    static 
    {
        $SwitchMap$com$amazon$client$metrics$DataPointType = new int[DataPointType.values().length];
        try
        {
            $SwitchMap$com$amazon$client$metrics$DataPointType[DataPointType.CT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$amazon$client$metrics$DataPointType[DataPointType.TI.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$client$metrics$DataPointType[DataPointType.DV.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$client$metrics$DataPointType[DataPointType.CK.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
