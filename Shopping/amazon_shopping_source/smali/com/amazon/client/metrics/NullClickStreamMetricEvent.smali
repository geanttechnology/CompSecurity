.class public Lcom/amazon/client/metrics/NullClickStreamMetricEvent;
.super Lcom/amazon/client/metrics/NullMetricEvent;
.source "NullClickStreamMetricEvent.java"

# interfaces
.implements Lcom/amazon/client/metrics/ClickStreamMetricsEvent;


# instance fields
.field private mCustomerId:Ljava/lang/String;

.field private mRequestId:Ljava/lang/String;

.field private mSessionId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-static {}, Lcom/amazon/client/metrics/MetricEventType;->getDefault()Lcom/amazon/client/metrics/MetricEventType;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    .line 15
    const-string/jumbo v0, " "

    iput-object v0, p0, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;->mRequestId:Ljava/lang/String;

    .line 16
    const-string/jumbo v0, " "

    iput-object v0, p0, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;->mSessionId:Ljava/lang/String;

    .line 17
    const-string/jumbo v0, " "

    iput-object v0, p0, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;->mCustomerId:Ljava/lang/String;

    .line 18
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V
    .locals 0
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 21
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/client/metrics/NullMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    .line 22
    return-void
.end method


# virtual methods
.method public getRequestId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/client/metrics/NullClickStreamMetricEvent;->mRequestId:Ljava/lang/String;

    return-object v0
.end method

.method public setECommerceInfo(Lcom/amazon/client/metrics/clickstream/ECommerceInfo;)V
    .locals 0
    .param p1, "eCommerceInfo"    # Lcom/amazon/client/metrics/clickstream/ECommerceInfo;

    .prologue
    .line 48
    return-void
.end method

.method public setImpressionTrackingData(Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;)V
    .locals 0
    .param p1, "impressionTrackingData"    # Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;

    .prologue
    .line 43
    return-void
.end method

.method public setUsageInfo(Lcom/amazon/client/metrics/clickstream/UsageInfo;)V
    .locals 0
    .param p1, "usageInfo"    # Lcom/amazon/client/metrics/clickstream/UsageInfo;

    .prologue
    .line 37
    return-void
.end method

.method public validateMetricEvent()Z
    .locals 1

    .prologue
    .line 31
    const/4 v0, 0x0

    return v0
.end method
