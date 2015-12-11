// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.google.protobuf.ExtensionRegistry;
import java.util.List;

// Referenced classes of package com.amazon.client.metrics.codec:
//            DeviceMetricsMessage

static final class yValue.Builder
    implements com.google.protobuf.tor.InternalDescriptorAssigner
{

    public ExtensionRegistry assignDescriptors(com.google.protobuf.tor tor)
    {
        com.google.protobuf.tor _tmp = DeviceMetricsMessage.access$5002(tor);
        com.google.protobuf.tor _tmp1 = DeviceMetricsMessage.access$002((com.google.protobuf.csMessage.access._cls002)DeviceMetricsMessage.getDescriptor().getMessageTypes().get(0));
        com.google.protobuf.ccessorTable _tmp2 = DeviceMetricsMessage.access$102(new com.google.protobuf.ccessorTable(DeviceMetricsMessage.access$000(), new String[] {
            "DeviceSerialNumber", "DeviceType", "Tag", "Metadata", "MetricEntry"
        }, com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage, com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder));
        com.google.protobuf.csMessage.access._cls000 _tmp3 = DeviceMetricsMessage.access$1502((com.google.protobuf.csMessage.access._cls1502)DeviceMetricsMessage.getDescriptor().getMessageTypes().get(1));
        com.google.protobuf.ccessorTable _tmp4 = DeviceMetricsMessage.access$1602(new com.google.protobuf.ccessorTable(DeviceMetricsMessage.access$1500(), new String[] {
            "Timestamp", "Program", "Source", "DataPoint"
        }, com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage, com/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder));
        com.google.protobuf.csMessage.access._cls1500 _tmp5 = DeviceMetricsMessage.access$2802((com.google.protobuf.csMessage.access._cls2802)DeviceMetricsMessage.getDescriptor().getMessageTypes().get(2));
        com.google.protobuf.ccessorTable _tmp6 = DeviceMetricsMessage.access$2902(new com.google.protobuf.ccessorTable(DeviceMetricsMessage.access$2800(), new String[] {
            "Name", "Value", "SampleSize", "Type"
        }, com/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage, com/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder));
        com.google.protobuf.csMessage.access._cls2800 _tmp7 = DeviceMetricsMessage.access$4002((com.google.protobuf.csMessage.access._cls4002)DeviceMetricsMessage.getDescriptor().getMessageTypes().get(3));
        com.google.protobuf.ccessorTable _tmp8 = DeviceMetricsMessage.access$4102(new com.google.protobuf.ccessorTable(DeviceMetricsMessage.access$4000(), new String[] {
            "Key", "Value"
        }, com/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue, com/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue$Builder));
        return null;
    }

    yValue.Builder()
    {
    }
}
