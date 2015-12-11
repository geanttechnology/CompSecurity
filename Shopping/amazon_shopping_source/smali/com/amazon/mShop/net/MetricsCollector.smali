.class public Lcom/amazon/mShop/net/MetricsCollector;
.super Ljava/lang/Object;
.source "MetricsCollector.java"


# static fields
.field private static final sCollectingThread:Ljava/lang/Thread;

.field private static final sCompletedEventsQueue:Ljava/util/concurrent/LinkedBlockingQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/LinkedBlockingQueue",
            "<",
            "Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 78
    new-instance v0, Ljava/util/concurrent/LinkedBlockingQueue;

    const/16 v1, 0x1f4

    invoke-direct {v0, v1}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsCollector;->sCompletedEventsQueue:Ljava/util/concurrent/LinkedBlockingQueue;

    .line 114
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amazon/mShop/net/MetricsCollector$1;

    invoke-direct {v1}, Lcom/amazon/mShop/net/MetricsCollector$1;-><init>()V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    sput-object v0, Lcom/amazon/mShop/net/MetricsCollector;->sCollectingThread:Ljava/lang/Thread;

    .line 203
    sget-object v0, Lcom/amazon/mShop/net/MetricsCollector;->sCollectingThread:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 204
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000()Ljava/util/concurrent/LinkedBlockingQueue;
    .locals 1

    .prologue
    .line 63
    sget-object v0, Lcom/amazon/mShop/net/MetricsCollector;->sCompletedEventsQueue:Ljava/util/concurrent/LinkedBlockingQueue;

    return-object v0
.end method

.method static synthetic access$100(Ljava/util/Collection;)V
    .locals 0
    .param p0, "x0"    # Ljava/util/Collection;

    .prologue
    .line 63
    invoke-static {p0}, Lcom/amazon/mShop/net/MetricsCollector;->collect(Ljava/util/Collection;)V

    return-void
.end method

.method private static collect(Ljava/util/Collection;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 220
    .local p0, "events":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    invoke-static {p0}, Lcom/amazon/mShop/net/MetricsAggregator;->aggregate(Ljava/util/Collection;)Ljava/util/List;

    move-result-object v0

    .line 222
    .local v0, "aggregatedMetricsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/AggregatedMetrics;>;"
    invoke-static {v0}, Lcom/amazon/mShop/net/MetricsSender;->postAllMetrics(Ljava/util/List;)V

    .line 224
    return-void
.end method

.method public static queueEvent(Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;)V
    .locals 1
    .param p0, "event"    # Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;

    .prologue
    .line 89
    sget-object v0, Lcom/amazon/mShop/net/MetricsCollector;->sCompletedEventsQueue:Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-virtual {v0, p0}, Ljava/util/concurrent/LinkedBlockingQueue;->offer(Ljava/lang/Object;)Z

    .line 90
    return-void
.end method
