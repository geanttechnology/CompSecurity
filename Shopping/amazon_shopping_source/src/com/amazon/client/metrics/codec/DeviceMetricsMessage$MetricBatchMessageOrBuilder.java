// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics.codec:
//            DeviceMetricsMessage

public static interface 
    extends MessageOrBuilder
{

    public abstract String getDeviceSerialNumber();

    public abstract String getDeviceType();

    public abstract  getMetadata(int i);

    public abstract int getMetadataCount();

    public abstract List getMetadataList();

    public abstract  getMetadataOrBuilder(int i);

    public abstract List getMetadataOrBuilderList();

    public abstract  getMetricEntry(int i);

    public abstract int getMetricEntryCount();

    public abstract List getMetricEntryList();

    public abstract  getMetricEntryOrBuilder(int i);

    public abstract List getMetricEntryOrBuilderList();

    public abstract String getTag();

    public abstract boolean hasDeviceSerialNumber();

    public abstract boolean hasDeviceType();

    public abstract boolean hasTag();
}
