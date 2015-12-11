.class public interface abstract Lcom/amazon/client/metrics/ClickStreamMetricsEvent;
.super Ljava/lang/Object;
.source "ClickStreamMetricsEvent.java"

# interfaces
.implements Lcom/amazon/client/metrics/MetricEvent;


# virtual methods
.method public abstract getRequestId()Ljava/lang/String;
.end method

.method public abstract setECommerceInfo(Lcom/amazon/client/metrics/clickstream/ECommerceInfo;)V
.end method

.method public abstract setImpressionTrackingData(Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;)V
.end method

.method public abstract setUsageInfo(Lcom/amazon/client/metrics/clickstream/UsageInfo;)V
.end method

.method public abstract validateMetricEvent()Z
.end method
