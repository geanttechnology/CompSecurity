// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;


// Referenced classes of package com.amazon.client.metrics.codec:
//            EncodedMetricEntry

public class ProtocolBuffersEncodedMetricEntry
    implements EncodedMetricEntry
{

    private DeviceMetricsMessage.MetricEntryMessage mMetricEntryMessage;

    public ProtocolBuffersEncodedMetricEntry(DeviceMetricsMessage.MetricEntryMessage metricentrymessage)
    {
        if (metricentrymessage == null)
        {
            throw new IllegalArgumentException("MetricEntryMessage is null");
        } else
        {
            mMetricEntryMessage = metricentrymessage;
            return;
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (getClass() == obj.getClass())
                {
                    obj = (ProtocolBuffersEncodedMetricEntry)obj;
                    return mMetricEntryMessage.equals(((ProtocolBuffersEncodedMetricEntry) (obj)).getEncodedMetricEntry());
                }
            }
        }
        return flag;
    }

    public DeviceMetricsMessage.MetricEntryMessage getEncodedMetricEntry()
    {
        return mMetricEntryMessage;
    }

    public volatile Object getEncodedMetricEntry()
    {
        return getEncodedMetricEntry();
    }

    public int getEncodedSize()
    {
        return mMetricEntryMessage.getSerializedSize();
    }

    public int hashCode()
    {
        return mMetricEntryMessage.hashCode();
    }

    public String toString()
    {
        return mMetricEntryMessage.toString();
    }
}
