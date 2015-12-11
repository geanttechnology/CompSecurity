.class public abstract Lcom/amazon/mShop/net/AggregatedMetrics;
.super Ljava/lang/Object;
.source "AggregatedMetrics.java"


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    invoke-virtual {p0}, Lcom/amazon/mShop/net/AggregatedMetrics;->getSenderType()Lcom/amazon/mShop/net/MetricsSender$SenderType;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/net/MetricsSender;->getMetricsSenderByType(Lcom/amazon/mShop/net/MetricsSender$SenderType;)Lcom/amazon/mShop/net/MetricsSender;

    move-result-object v0

    if-nez v0, :cond_0

    .line 16
    invoke-virtual {p0}, Lcom/amazon/mShop/net/AggregatedMetrics;->getSenderType()Lcom/amazon/mShop/net/MetricsSender$SenderType;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/mShop/net/AggregatedMetrics;->getMetricsSender()Lcom/amazon/mShop/net/MetricsSender;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/mShop/net/MetricsSender;->registerMetricsSender(Lcom/amazon/mShop/net/MetricsSender$SenderType;Lcom/amazon/mShop/net/MetricsSender;)V

    .line 18
    :cond_0
    return-void
.end method


# virtual methods
.method public abstract getMetricsSender()Lcom/amazon/mShop/net/MetricsSender;
.end method

.method public abstract getSenderType()Lcom/amazon/mShop/net/MetricsSender$SenderType;
.end method
