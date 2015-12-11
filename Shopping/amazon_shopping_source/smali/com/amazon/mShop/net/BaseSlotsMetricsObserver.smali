.class public abstract Lcom/amazon/mShop/net/BaseSlotsMetricsObserver;
.super Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
.source "BaseSlotsMetricsObserver.java"


# instance fields
.field private eventAddedToQueue:Z

.field private mSlotTokens:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;-><init>()V

    .line 21
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/net/BaseSlotsMetricsObserver;->eventAddedToQueue:Z

    return-void
.end method


# virtual methods
.method public getSlotTokens()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/net/BaseSlotsMetricsObserver;->mSlotTokens:Ljava/util/List;

    return-object v0
.end method

.method public postSlotTokens(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p1, "tokens":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-boolean v0, p0, Lcom/amazon/mShop/net/BaseSlotsMetricsObserver;->eventAddedToQueue:Z

    if-nez v0, :cond_0

    .line 25
    iput-object p1, p0, Lcom/amazon/mShop/net/BaseSlotsMetricsObserver;->mSlotTokens:Ljava/util/List;

    .line 26
    invoke-static {p0}, Lcom/amazon/mShop/net/MetricsCollector;->queueEvent(Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;)V

    .line 27
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/net/BaseSlotsMetricsObserver;->eventAddedToQueue:Z

    .line 29
    :cond_0
    return-void
.end method
