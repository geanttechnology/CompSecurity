.class public Lcom/amazon/mShop/net/NetworkInfoMetricObserver;
.super Lcom/amazon/mShop/net/PageMetricsObserver;
.source "NetworkInfoMetricObserver.java"


# static fields
.field private static final DEBUG:Z

.field private static final NETWORK_METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->DEBUG:Z

    .line 49
    new-instance v0, Lcom/amazon/mShop/net/NetworkInfoMetricObserver$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/NetworkInfoMetricObserver$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->NETWORK_METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "identifier"    # Ljava/lang/String;

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/amazon/mShop/net/PageMetricsObserver;-><init>(Ljava/lang/String;)V

    .line 37
    return-void
.end method

.method static synthetic access$000()Z
    .locals 1

    .prologue
    .line 14
    sget-boolean v0, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->DEBUG:Z

    return v0
.end method

.method public static start(Ljava/lang/String;)Lcom/amazon/mShop/net/NetworkInfoMetricObserver;
    .locals 1
    .param p0, "identifier"    # Ljava/lang/String;

    .prologue
    .line 25
    new-instance v0, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;-><init>(Ljava/lang/String;)V

    .line 27
    .local v0, "observer":Lcom/amazon/mShop/net/NetworkInfoMetricObserver;
    invoke-virtual {v0}, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->onStart()V

    .line 28
    return-object v0
.end method


# virtual methods
.method public getAggregator()Lcom/amazon/mShop/net/MetricsAggregator;
    .locals 1

    .prologue
    .line 41
    sget-object v0, Lcom/amazon/mShop/net/NetworkInfoMetricObserver;->NETWORK_METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-object v0
.end method

.method public getEventAggregatorType()Lcom/amazon/mShop/net/MetricsAggregator$Type;
    .locals 1

    .prologue
    .line 46
    sget-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->NetworkInfoMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    return-object v0
.end method
