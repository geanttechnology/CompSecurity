.class public Lcom/amazon/mShop/net/ClickedSlotsMetricsObserver;
.super Lcom/amazon/mShop/net/BaseSlotsMetricsObserver;
.source "ClickedSlotsMetricsObserver.java"


# static fields
.field static final METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    new-instance v0, Lcom/amazon/mShop/net/ClickedSlotsMetricsObserver$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/ClickedSlotsMetricsObserver$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/ClickedSlotsMetricsObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mShop/net/BaseSlotsMetricsObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public getAggregator()Lcom/amazon/mShop/net/MetricsAggregator;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/amazon/mShop/net/ClickedSlotsMetricsObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-object v0
.end method

.method public getEventAggregatorType()Lcom/amazon/mShop/net/MetricsAggregator$Type;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->ClickedSlotsMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    return-object v0
.end method
