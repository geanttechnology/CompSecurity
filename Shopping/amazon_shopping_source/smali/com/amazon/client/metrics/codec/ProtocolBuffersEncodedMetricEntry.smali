.class public Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;
.super Ljava/lang/Object;
.source "ProtocolBuffersEncodedMetricEntry.java"

# interfaces
.implements Lcom/amazon/client/metrics/codec/EncodedMetricEntry;


# instance fields
.field private mMetricEntryMessage:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)V
    .locals 2
    .param p1, "metricEntryMessage"    # Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    if-nez p1, :cond_0

    .line 16
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "MetricEntryMessage is null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 18
    :cond_0
    iput-object p1, p0, Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;->mMetricEntryMessage:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    .line 19
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 33
    if-ne p0, p1, :cond_1

    .line 34
    const/4 v1, 0x1

    .line 43
    :cond_0
    :goto_0
    return v1

    .line 36
    :cond_1
    if-eqz p1, :cond_0

    .line 39
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-ne v2, v3, :cond_0

    move-object v0, p1

    .line 42
    check-cast v0, Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;

    .line 43
    .local v0, "other":Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;
    iget-object v1, p0, Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;->mMetricEntryMessage:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;->getEncodedMetricEntry()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0
.end method

.method public getEncodedMetricEntry()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;->mMetricEntryMessage:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    return-object v0
.end method

.method public bridge synthetic getEncodedMetricEntry()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 10
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;->getEncodedMetricEntry()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public getEncodedSize()I
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;->mMetricEntryMessage:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getSerializedSize()I

    move-result v0

    return v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;->mMetricEntryMessage:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/ProtocolBuffersEncodedMetricEntry;->mMetricEntryMessage:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
