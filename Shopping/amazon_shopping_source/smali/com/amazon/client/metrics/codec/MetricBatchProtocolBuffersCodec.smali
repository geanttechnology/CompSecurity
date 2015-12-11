.class public Lcom/amazon/client/metrics/codec/MetricBatchProtocolBuffersCodec;
.super Ljava/lang/Object;
.source "MetricBatchProtocolBuffersCodec.java"

# interfaces
.implements Lcom/amazon/client/metrics/codec/MetricBatchCodec;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public encode(Lcom/amazon/client/metrics/MetricBatch;)[B
    .locals 9
    .param p1, "metricEntryBatch"    # Lcom/amazon/client/metrics/MetricBatch;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/dp/framework/CodecException;
        }
    .end annotation

    .prologue
    .line 19
    if-nez p1, :cond_0

    .line 20
    new-instance v5, Lcom/dp/framework/CodecException;

    const-string/jumbo v6, "MetricEntryBatch is null"

    invoke-direct {v5, v6}, Lcom/dp/framework/CodecException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 22
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricBatch;->getBatchSizeInBytes()J

    move-result-wide v5

    const-wide/16 v7, 0x0

    cmp-long v5, v5, v7

    if-nez v5, :cond_1

    .line 23
    new-instance v5, Lcom/dp/framework/CodecException;

    const-string/jumbo v6, "MetricEntryBatch is empty"

    invoke-direct {v5, v6}, Lcom/dp/framework/CodecException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 25
    :cond_1
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v4

    .line 28
    .local v4, "metricBatchBuilder":Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;
    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricBatch;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->setDeviceSerialNumber(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    .line 29
    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricBatch;->getDeviceType()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_2

    .line 30
    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricBatch;->getDeviceType()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->setDeviceType(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    .line 33
    :cond_2
    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricBatch;->getDeviceInfoMap()Ljava/util/Map;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_3
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 34
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_3

    .line 35
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue$Builder;

    move-result-object v6

    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v6, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue$Builder;->setKey(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue$Builder;

    move-result-object v6

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v6, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue$Builder;->setValue(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue$Builder;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->addMetadata(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    goto :goto_0

    .line 41
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_4
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricBatch;->getMetricEntryCount()I

    move-result v5

    if-ge v2, v5, :cond_5

    .line 42
    invoke-virtual {p1, v2}, Lcom/amazon/client/metrics/MetricBatch;->getMetricEntry(I)Lcom/amazon/client/metrics/codec/EncodedMetricEntry;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/client/metrics/codec/EncodedMetricEntry;->getEncodedMetricEntry()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    invoke-virtual {v4, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->addMetricEntry(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    .line 41
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 46
    :cond_5
    invoke-virtual {v4}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->toByteArray()[B

    move-result-object v0

    .line 47
    .local v0, "encodedBatchBytes":[B
    if-nez v0, :cond_6

    .line 48
    new-instance v5, Lcom/dp/framework/CodecException;

    const-string/jumbo v6, "serialized batch is null"

    invoke-direct {v5, v6}, Lcom/dp/framework/CodecException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 50
    :cond_6
    array-length v5, v0

    if-nez v5, :cond_7

    .line 51
    new-instance v5, Lcom/dp/framework/CodecException;

    const-string/jumbo v6, "serialized batch is empty"

    invoke-direct {v5, v6}, Lcom/dp/framework/CodecException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 53
    :cond_7
    return-object v0
.end method
