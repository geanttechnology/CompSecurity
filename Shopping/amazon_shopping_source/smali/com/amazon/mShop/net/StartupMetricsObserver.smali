.class public Lcom/amazon/mShop/net/StartupMetricsObserver;
.super Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
.source "StartupMetricsObserver.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;
    }
.end annotation


# static fields
.field static final METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

.field static sStartupPrefixMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mMetricsType:Ljava/lang/String;

.field private mStartupType:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 62
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/StartupMetricsObserver;->sStartupPrefixMap:Ljava/util/Map;

    .line 65
    sget-object v0, Lcom/amazon/mShop/net/StartupMetricsObserver;->sStartupPrefixMap:Ljava/util/Map;

    sget-object v1, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;->PUBLIC_URL_START:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    const-string/jumbo v2, "start:"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    sget-object v0, Lcom/amazon/mShop/net/StartupMetricsObserver;->sStartupPrefixMap:Ljava/util/Map;

    sget-object v1, Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;->PUBLIC_URL_FIRST_START:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    const-string/jumbo v2, "first-start"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    new-instance v0, Lcom/amazon/mShop/net/StartupMetricsObserver$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/StartupMetricsObserver$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/StartupMetricsObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;Ljava/lang/String;)V
    .locals 0
    .param p1, "startupType"    # Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;
    .param p2, "metricsType"    # Ljava/lang/String;

    .prologue
    .line 72
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;-><init>()V

    .line 73
    iput-object p1, p0, Lcom/amazon/mShop/net/StartupMetricsObserver;->mStartupType:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    .line 74
    iput-object p2, p0, Lcom/amazon/mShop/net/StartupMetricsObserver;->mMetricsType:Ljava/lang/String;

    .line 75
    return-void
.end method

.method public static logStartupMetrics(Ljava/lang/String;Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;)V
    .locals 1
    .param p0, "startupMetrics"    # Ljava/lang/String;
    .param p1, "startupType"    # Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    .prologue
    .line 83
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 84
    new-instance v0, Lcom/amazon/mShop/net/StartupMetricsObserver;

    invoke-direct {v0, p1, p0}, Lcom/amazon/mShop/net/StartupMetricsObserver;-><init>(Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;Ljava/lang/String;)V

    invoke-static {v0}, Lcom/amazon/mShop/net/MetricsCollector;->queueEvent(Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;)V

    .line 86
    :cond_0
    return-void
.end method


# virtual methods
.method public getAggregator()Lcom/amazon/mShop/net/MetricsAggregator;
    .locals 1

    .prologue
    .line 148
    sget-object v0, Lcom/amazon/mShop/net/StartupMetricsObserver;->METRICS_AGGREGATOR:Lcom/amazon/mShop/net/MetricsAggregator;

    return-object v0
.end method

.method public getEventAggregatorType()Lcom/amazon/mShop/net/MetricsAggregator$Type;
    .locals 1

    .prologue
    .line 143
    sget-object v0, Lcom/amazon/mShop/net/MetricsAggregator$Type;->StartupMetric:Lcom/amazon/mShop/net/MetricsAggregator$Type;

    return-object v0
.end method

.method public getMetricsType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/amazon/mShop/net/StartupMetricsObserver;->mMetricsType:Ljava/lang/String;

    return-object v0
.end method

.method public getStartupType()Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/mShop/net/StartupMetricsObserver;->mStartupType:Lcom/amazon/mShop/net/StartupMetricsObserver$StartupType;

    return-object v0
.end method
