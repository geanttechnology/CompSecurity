.class public Lcom/amazon/client/metrics/codec/MetricEntryToStringCodec;
.super Ljava/lang/Object;
.source "MetricEntryToStringCodec.java"

# interfaces
.implements Lcom/amazon/client/metrics/codec/MetricEntryCodec;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public encode(Lcom/amazon/client/metrics/MetricEntry;)Lcom/amazon/client/metrics/codec/EncodedMetricEntry;
    .locals 2
    .param p1, "metricEntry"    # Lcom/amazon/client/metrics/MetricEntry;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/dp/framework/CodecException;
        }
    .end annotation

    .prologue
    .line 14
    new-instance v0, Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;

    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/client/metrics/codec/StringEncodedMetricEntry;-><init>(Ljava/lang/String;)V

    return-object v0
.end method
