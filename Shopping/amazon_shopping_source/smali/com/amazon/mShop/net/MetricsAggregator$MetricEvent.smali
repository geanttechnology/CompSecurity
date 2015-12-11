.class public abstract Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
.super Ljava/lang/Object;
.source "MetricsAggregator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/MetricsAggregator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "MetricEvent"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 165
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 166
    invoke-virtual {p0}, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;->getEventAggregatorType()Lcom/amazon/mShop/net/MetricsAggregator$Type;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/net/MetricsAggregator;->getAggregatorForType(Lcom/amazon/mShop/net/MetricsAggregator$Type;)Lcom/amazon/mShop/net/MetricsAggregator;

    move-result-object v0

    if-nez v0, :cond_0

    .line 167
    invoke-virtual {p0}, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;->getEventAggregatorType()Lcom/amazon/mShop/net/MetricsAggregator$Type;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;->getAggregator()Lcom/amazon/mShop/net/MetricsAggregator;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/mShop/net/MetricsAggregator;->registerAggregator(Lcom/amazon/mShop/net/MetricsAggregator$Type;Lcom/amazon/mShop/net/MetricsAggregator;)V

    .line 169
    :cond_0
    return-void
.end method


# virtual methods
.method public abstract getAggregator()Lcom/amazon/mShop/net/MetricsAggregator;
.end method

.method public abstract getEventAggregatorType()Lcom/amazon/mShop/net/MetricsAggregator$Type;
.end method
