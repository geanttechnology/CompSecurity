.class public Lcom/amazon/mShop/net/CountMetricObserver;
.super Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
.source "CountMetricObserver.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/CountMetricObserver$MetricType;
    }
.end annotation


# static fields
.field static final METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

.field private static sMetricPrefixMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/mShop/net/CountMetricObserver$MetricType;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mCount:I

.field private mMetric:Ljava/lang/String;

.field private mMetricType:Lcom/amazon/mShop/net/CountMetricObserver$MetricType;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 20
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/CountMetricObserver;->sMetricPrefixMap:Ljava/util/Map;

    .line 22
    sget-object v0, Lcom/amazon/mShop/net/CountMetricObserver;->sMetricPrefixMap:Ljava/util/Map;

    sget-object v1, Lcom/amazon/mShop/net/CountMetricObserver$MetricType;->FLOW_SCAN:Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    const-string/jumbo v2, "Scan:"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 123
    new-instance v0, Lcom/amazon/mShop/net/CountMetricObserver$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/CountMetricObserver$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/CountMetricObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/net/CountMetricObserver$MetricType;Ljava/lang/String;I)V
    .locals 0
    .param p1, "type"    # Lcom/amazon/mShop/net/CountMetricObserver$MetricType;
    .param p2, "metric"    # Ljava/lang/String;
    .param p3, "count"    # I

    .prologue
    .line 106
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;-><init>()V

    .line 107
    iput-object p1, p0, Lcom/amazon/mShop/net/CountMetricObserver;->mMetricType:Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    .line 108
    iput-object p2, p0, Lcom/amazon/mShop/net/CountMetricObserver;->mMetric:Ljava/lang/String;

    .line 109
    iput p3, p0, Lcom/amazon/mShop/net/CountMetricObserver;->mCount:I

    .line 110
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/net/CountMetricObserver;)Lcom/amazon/mShop/net/CountMetricObserver$MetricType;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/net/CountMetricObserver;

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/amazon/mShop/net/CountMetricObserver;->getMetricType()Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100()Ljava/util/Map;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/amazon/mShop/net/CountMetricObserver;->sMetricPrefixMap:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/net/CountMetricObserver;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/net/CountMetricObserver;

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/amazon/mShop/net/CountMetricObserver;->getMetric()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/net/CountMetricObserver;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/net/CountMetricObserver;

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/amazon/mShop/net/CountMetricObserver;->getCount()I

    move-result v0

    return v0
.end method

.method private getCount()I
    .locals 1

    .prologue
    .line 184
    iget v0, p0, Lcom/amazon/mShop/net/CountMetricObserver;->mCount:I

    return v0
.end method

.method private getMetric()Ljava/lang/String;
    .locals 1

    .prologue
    .line 180
    iget-object v0, p0, Lcom/amazon/mShop/net/CountMetricObserver;->mMetric:Ljava/lang/String;

    return-object v0
.end method

.method private getMetricType()Lcom/amazon/mShop/net/CountMetricObserver$MetricType;
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/amazon/mShop/net/CountMetricObserver;->mMetricType:Lcom/amazon/mShop/net/CountMetricObserver$MetricType;

    return-object v0
.end method

.method public static logCountMetrics(Lcom/amazon/mShop/net/CountMetricObserver$MetricType;Ljava/lang/String;I)V
    .locals 1
    .param p0, "type"    # Lcom/amazon/mShop/net/CountMetricObserver$MetricType;
    .param p1, "metric"    # Ljava/lang/String;
    .param p2, "count"    # I

    .prologue
    .line 118
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    if-lez p2, :cond_0

    .line 119
    new-instance v0, Lcom/amazon/mShop/net/CountMetricObserver;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mShop/net/CountMetricObserver;-><init>(Lcom/amazon/mShop/net/CountMetricObserver$MetricType;Ljava/lang/String;I)V

    invoke-static {v0}, Lcom/amazon/mShop/net/MetricsCollector;->queueEvent(Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;)V

    .line 121
    :cond_0
    return-void
.end method


# virtual methods
.method public getAggregator()Lcom/amazon/mShop/net/MetricsAggregator;
    .locals 1

    .prologue
    .line 172
    sget-object v0, Lcom/amazon/mShop/net/CountMetricObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-object v0
.end method

.method public getEventAggregatorType()Lcom/amazon/mShop/net/MetricsAggregator$Type;
    .locals 1

    .prologue
    .line 167
    sget-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->CountMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    return-object v0
.end method
