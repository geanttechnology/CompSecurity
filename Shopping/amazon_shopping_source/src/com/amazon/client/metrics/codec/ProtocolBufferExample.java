// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.codec;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtocolBufferExample
{

    public ProtocolBufferExample()
    {
    }

    public static DeviceMetricsMessage.MetricBatchMessage decodeSerializedMetrics()
        throws InvalidProtocolBufferException
    {
        byte abyte0[] = generateEncodedMetrics();
        DeviceMetricsMessage.MetricBatchMessage metricbatchmessage;
        try
        {
            metricbatchmessage = DeviceMetricsMessage.MetricBatchMessage.parseFrom(abyte0);
            metricbatchmessage.getDeviceSerialNumber();
            metricbatchmessage.getDeviceType();
            if (metricbatchmessage.getMetricEntryCount() > 0)
            {
                metricbatchmessage.getMetricEntry(0);
            }
            if (metricbatchmessage.getMetadataCount() > 0)
            {
                metricbatchmessage.getMetadata(0);
            }
        }
        catch (InvalidProtocolBufferException invalidprotocolbufferexception)
        {
            invalidprotocolbufferexception.printStackTrace();
            throw invalidprotocolbufferexception;
        }
        return metricbatchmessage;
    }

    public static byte[] generateEncodedMetrics()
    {
        Object obj = DeviceMetricsMessage.DataPointMessage.newBuilder().setName("CounterName").setValue("100").setSampleSize(10).setType(DeviceMetricsMessage.DataPointMessage.DataType.COUNTER).build();
        DeviceMetricsMessage.DataPointMessage datapointmessage = DeviceMetricsMessage.DataPointMessage.newBuilder().setName("testTimerName").setValue("150").setSampleSize(100).setType(DeviceMetricsMessage.DataPointMessage.DataType.TIMER).build();
        DeviceMetricsMessage.MetricEntryMessage.Builder builder = DeviceMetricsMessage.MetricEntryMessage.newBuilder();
        builder.setProgram("ProgramName").setSource("SourceName").setTimestamp(System.currentTimeMillis()).addDataPoint(((DeviceMetricsMessage.DataPointMessage) (obj))).addDataPoint(datapointmessage).addDataPoint(DeviceMetricsMessage.DataPointMessage.newBuilder().setName("REMOTE_ADDR").setValue("localhost").setSampleSize(1).setType(DeviceMetricsMessage.DataPointMessage.DataType.CLICKSTREAM).build()).addDataPoint(DeviceMetricsMessage.DataPointMessage.newBuilder().setName("page-type").setValue("some-device").setSampleSize(1).setType(DeviceMetricsMessage.DataPointMessage.DataType.CLICKSTREAM).build());
        obj = DeviceMetricsMessage.MetricBatchMessage.newBuilder();
        ((DeviceMetricsMessage.MetricBatchMessage.Builder) (obj)).setDeviceSerialNumber("testDSN").setDeviceType("TEST").setTag("tag");
        ((DeviceMetricsMessage.MetricBatchMessage.Builder) (obj)).addMetadata(DeviceMetricsMessage.KeyValue.newBuilder().setKey("key").setValue("value").build());
        ((DeviceMetricsMessage.MetricBatchMessage.Builder) (obj)).addMetricEntry(builder.build());
        return ((DeviceMetricsMessage.MetricBatchMessage.Builder) (obj)).build().toByteArray();
    }
}
