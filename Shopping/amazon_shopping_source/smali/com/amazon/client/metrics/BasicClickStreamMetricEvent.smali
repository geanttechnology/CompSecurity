.class public Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;
.super Lcom/amazon/client/metrics/BasicMetricEvent;
.source "BasicClickStreamMetricEvent.java"

# interfaces
.implements Lcom/amazon/client/metrics/ClickStreamMetricsEvent;


# instance fields
.field private mECommerceInfo:Lcom/amazon/client/metrics/clickstream/ECommerceInfo;

.field private mImpressionTrackingData:Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;

.field private final mRequestId:Ljava/lang/String;

.field private mUsageInfo:Lcom/amazon/client/metrics/clickstream/UsageInfo;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;

    .prologue
    .line 27
    invoke-static {}, Lcom/amazon/client/metrics/MetricEventType;->getDefault()Lcom/amazon/client/metrics/MetricEventType;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V

    .line 28
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;)V
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;

    .prologue
    .line 31
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)V

    .line 32
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)V
    .locals 1
    .param p1, "program"    # Ljava/lang/String;
    .param p2, "source"    # Ljava/lang/String;
    .param p3, "metricEventType"    # Lcom/amazon/client/metrics/MetricEventType;
    .param p4, "allowRunningTimers"    # Z

    .prologue
    .line 36
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/client/metrics/BasicMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/client/metrics/MetricEventType;Z)V

    .line 37
    invoke-direct {p0}, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->generateRequestId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->mRequestId:Ljava/lang/String;

    .line 38
    return-void
.end method

.method private addDatapointsToList(Ljava/util/List;Lcom/amazon/client/metrics/clickstream/ClickStreamInfo;)V
    .locals 3
    .param p2, "infoObject"    # Lcom/amazon/client/metrics/clickstream/ClickStreamInfo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;",
            "Lcom/amazon/client/metrics/clickstream/ClickStreamInfo;",
            ")V"
        }
    .end annotation

    .prologue
    .line 94
    .local p1, "datapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    if-nez p2, :cond_1

    .line 100
    :cond_0
    return-void

    .line 97
    :cond_1
    invoke-interface {p2}, Lcom/amazon/client/metrics/clickstream/ClickStreamInfo;->getDataPoints()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/DataPoint;

    .line 98
    .local v0, "dp":Lcom/amazon/client/metrics/DataPoint;
    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private generateRequestId()Ljava/lang/String;
    .locals 6

    .prologue
    .line 74
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "-"

    const-string/jumbo v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 75
    .local v2, "temp":Ljava/lang/String;
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    .line 76
    .local v0, "rand":Ljava/util/Random;
    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    invoke-virtual {v3}, Ljava/util/Date;->getTime()J

    move-result-wide v3

    invoke-virtual {v0, v3, v4}, Ljava/util/Random;->setSeed(J)V

    .line 77
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, -0x14

    invoke-virtual {v0, v3}, Ljava/util/Random;->nextInt(I)I

    move-result v1

    .line 78
    .local v1, "start":I
    add-int/lit8 v3, v1, 0x14

    invoke-virtual {v2, v1, v3}, Ljava/lang/String;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method


# virtual methods
.method public getAsDataPoints()Ljava/util/List;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/DataPoint;",
            ">;"
        }
    .end annotation

    .prologue
    .line 83
    invoke-super {p0}, Lcom/amazon/client/metrics/BasicMetricEvent;->getAsDataPoints()Ljava/util/List;

    move-result-object v1

    .line 84
    .local v1, "listDatapoints":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/client/metrics/DataPoint;>;"
    const/4 v0, 0x1

    .line 85
    .local v0, "defaultSample":I
    iget-object v2, p0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->mUsageInfo:Lcom/amazon/client/metrics/clickstream/UsageInfo;

    invoke-direct {p0, v1, v2}, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->addDatapointsToList(Ljava/util/List;Lcom/amazon/client/metrics/clickstream/ClickStreamInfo;)V

    .line 86
    iget-object v2, p0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->mImpressionTrackingData:Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;

    invoke-direct {p0, v1, v2}, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->addDatapointsToList(Ljava/util/List;Lcom/amazon/client/metrics/clickstream/ClickStreamInfo;)V

    .line 87
    iget-object v2, p0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->mECommerceInfo:Lcom/amazon/client/metrics/clickstream/ECommerceInfo;

    invoke-direct {p0, v1, v2}, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->addDatapointsToList(Ljava/util/List;Lcom/amazon/client/metrics/clickstream/ClickStreamInfo;)V

    .line 89
    new-instance v2, Lcom/amazon/client/metrics/DataPoint;

    sget-object v3, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->REQUEST_ID:Lcom/amazon/client/metrics/clickstream/ClickStreamData;

    invoke-virtual {v3}, Lcom/amazon/client/metrics/clickstream/ClickStreamData;->getName()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->mRequestId:Ljava/lang/String;

    sget-object v5, Lcom/amazon/client/metrics/DataPointType;->DV:Lcom/amazon/client/metrics/DataPointType;

    invoke-direct {v2, v3, v4, v0, v5}, Lcom/amazon/client/metrics/DataPoint;-><init>(Ljava/lang/String;Ljava/lang/String;ILcom/amazon/client/metrics/DataPointType;)V

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 90
    return-object v1
.end method

.method public getRequestId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->mRequestId:Ljava/lang/String;

    return-object v0
.end method

.method public setECommerceInfo(Lcom/amazon/client/metrics/clickstream/ECommerceInfo;)V
    .locals 0
    .param p1, "eCommerceInfo"    # Lcom/amazon/client/metrics/clickstream/ECommerceInfo;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->mECommerceInfo:Lcom/amazon/client/metrics/clickstream/ECommerceInfo;

    .line 66
    return-void
.end method

.method public setImpressionTrackingData(Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;)V
    .locals 0
    .param p1, "impressionTrackingData"    # Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->mImpressionTrackingData:Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;

    .line 61
    return-void
.end method

.method public setUsageInfo(Lcom/amazon/client/metrics/clickstream/UsageInfo;)V
    .locals 0
    .param p1, "usageInfo"    # Lcom/amazon/client/metrics/clickstream/UsageInfo;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->mUsageInfo:Lcom/amazon/client/metrics/clickstream/UsageInfo;

    .line 56
    return-void
.end method

.method public validateMetricEvent()Z
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->mUsageInfo:Lcom/amazon/client/metrics/clickstream/UsageInfo;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->mImpressionTrackingData:Lcom/amazon/client/metrics/clickstream/ImpressionTrackingData;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/client/metrics/BasicClickStreamMetricEvent;->mECommerceInfo:Lcom/amazon/client/metrics/clickstream/ECommerceInfo;

    if-nez v0, :cond_0

    .line 48
    const/4 v0, 0x0

    .line 50
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method
