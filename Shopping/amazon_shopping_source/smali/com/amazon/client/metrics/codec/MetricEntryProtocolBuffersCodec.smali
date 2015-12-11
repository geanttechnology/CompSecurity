.class public Lcom/amazon/client/metrics/codec/MetricEntryProtocolBuffersCodec;
.super Ljava/lang/Object;
.source "MetricEntryProtocolBuffersCodec.java"

# interfaces
.implements Lcom/amazon/client/metrics/codec/MetricEntryCodec;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/codec/MetricEntryProtocolBuffersCodec$1;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    return-void
.end method

.method private static getDataType(Lcom/amazon/client/metrics/DataPointType;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;
    .locals 2
    .param p0, "dataPointType"    # Lcom/amazon/client/metrics/DataPointType;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/dp/framework/CodecException;
        }
    .end annotation

    .prologue
    .line 44
    sget-object v0, Lcom/amazon/client/metrics/codec/MetricEntryProtocolBuffersCodec$1;->$SwitchMap$com$amazon$client$metrics$DataPointType:[I

    invoke-virtual {p0}, Lcom/amazon/client/metrics/DataPointType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 54
    new-instance v0, Lcom/dp/framework/CodecException;

    const-string/jumbo v1, "Invalid DataPoint type"

    invoke-direct {v0, v1}, Lcom/dp/framework/CodecException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 46
    :pswitch_0
    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->COUNTER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    .line 52
    :goto_0
    return-object v0

    .line 48
    :pswitch_1
    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->TIMER:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    goto :goto_0

    .line 50
    :pswitch_2
    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->DISCRETE:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    goto :goto_0

    .line 52
    :pswitch_3
    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;->CLICKSTREAM:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    goto :goto_0

    .line 44
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method


# virtual methods
.method public encode(Lcom/amazon/client/metrics/MetricEntry;)Lcom/amazon/client/metrics/codec/EncodedMetricEntry;
    .locals 7
    .param p1, "metricEntry"    # Lcom/amazon/client/metrics/MetricEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/dp/framework/CodecException;
        }
    .end annotation

    .prologue
    .line 19
    if-nez p1, :cond_0

    .line 20
    new-instance v4, Lcom/dp/framework/CodecException;

    const-string/jumbo v5, "Metric entry is null"

    invoke-direct {v4, v5}, Lcom/dp/framework/CodecException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 22
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->getDatapoints()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    if-nez v4, :cond_1

    .line 23
    new-instance v4, Lcom/dp/framework/CodecException;

    const-string/jumbo v5, "Metric entry contains no data points"

    invoke-direct {v4, v5}, Lcom/dp/framework/CodecException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 26
    :cond_1
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v4

    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->getProgram()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->setProgram(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v4

    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->getSource()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->setSource(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v4

    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->getTimestamp()J

    move-result-wide v5

    invoke-virtual {v4, v5, v6}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->setTimestamp(J)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v3

    .line 31
    .local v3, "metricEntryMessageBuilder":Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->getDatapoints()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/DataPoint;

    .line 32
    .local v0, "dataPoint":Lcom/amazon/client/metrics/DataPoint;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/DataPoint;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->setName(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/DataPoint;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->setValue(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/DataPoint;->getSamples()I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->setSampleSize(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/amazon/client/metrics/DataPoint;->getType()Lcom/amazon/client/metrics/DataPointType;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/client/metrics/codec/MetricEntryProtocolBuffersCodec;->getDataType(Lcom/amazon/client/metrics/DataPointType;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->setType(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$DataType;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v1

    .line 38
    .local v1, "dataPointMessage":Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;
    invoke-virtual {v3, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->addDataPoint(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    goto :goto_0

    .line 40
    .end local v0    # "dataPoint":Lcom/amazon/client/metrics/DataPoint;
    .end local v1    # "dataPointMessage":Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;
    :cond_2
    new-instance v4, Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;

    invoke-virtual {v3}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;-><init>(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)V

    return-object v4
.end method
