.class public interface abstract Lcom/amazon/client/metrics/MetricsFactory;
.super Ljava/lang/Object;
.source "MetricsFactory.java"


# static fields
.field public static final SYSTEM_SERVICE_KEY:Ljava/lang/String; = "com.amazon.dp.metrics.MetricsFactory"


# virtual methods
.method public abstract createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;
.end method

.method public abstract createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;
.end method

.method public abstract createClickStreamMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/ClickStreamMetricsEvent;
.end method

.method public abstract createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;
.end method

.method public abstract createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)Lcom/amazon/client/metrics/MetricEvent;
.end method

.method public abstract createConcurrentMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/MetricEvent;
.end method

.method public abstract createMetricEvent(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/client/metrics/MetricEvent;
.end method

.method public abstract createMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)Lcom/amazon/client/metrics/MetricEvent;
.end method

.method public abstract createMetricEvent(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)Lcom/amazon/client/metrics/MetricEvent;
.end method

.method public abstract getSessionID()Ljava/lang/String;
.end method

.method public abstract record(Lcom/amazon/client/metrics/MetricEvent;)V
.end method

.method public abstract record(Lcom/amazon/client/metrics/MetricEvent;Lcom/amazon/client/metrics/Priority;)V
.end method
