.class public Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;
.super Lcom/amazon/mShop/net/AggregatedMetrics;
.source "RefMarkersAggregatedMetrics.java"


# static fields
.field private static final METRICS_SENDER:Lcom/amazon/mShop/net/MetricsSender;


# instance fields
.field private final mRefMarkers:Ljava/util/List;
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
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    new-instance v0, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics$1;

    invoke-direct {v0}, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;->METRICS_SENDER:Lcom/amazon/mShop/net/MetricsSender;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/amazon/mShop/net/AggregatedMetrics;-><init>()V

    .line 40
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;->mRefMarkers:Ljava/util/List;

    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    .prologue
    .line 33
    invoke-static {}, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;->getRandomRequestId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getRandomRequestId()Ljava/lang/String;
    .locals 5

    .prologue
    const/16 v4, 0x11

    .line 146
    new-instance v0, Ljava/util/Random;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-direct {v0, v2, v3}, Ljava/util/Random;-><init>(J)V

    .line 147
    .local v0, "random":Ljava/util/Random;
    const-string/jumbo v1, ""

    .line 148
    .local v1, "value":Ljava/lang/String;
    :goto_0
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v2, v4, :cond_0

    .line 149
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const v3, 0x7fffffff

    invoke-virtual {v0, v3}, Ljava/util/Random;->nextInt(I)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 151
    :cond_0
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-le v2, v4, :cond_1

    .line 152
    const/4 v2, 0x0

    invoke-virtual {v1, v2, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 154
    :cond_1
    return-object v1
.end method


# virtual methods
.method public getMetricsSender()Lcom/amazon/mShop/net/MetricsSender;
    .locals 1

    .prologue
    .line 142
    sget-object v0, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;->METRICS_SENDER:Lcom/amazon/mShop/net/MetricsSender;

    return-object v0
.end method

.method public getRefMarkers()Ljava/util/List;
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
    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;->mRefMarkers:Ljava/util/List;

    return-object v0
.end method

.method public getSenderType()Lcom/amazon/mShop/net/MetricsSender$SenderType;
    .locals 1

    .prologue
    .line 137
    sget-object v0, Lcom/amazon/mShop/net/MetricsSender$SenderType;->RefMarkerSender:Lcom/amazon/mShop/net/MetricsSender$SenderType;

    return-object v0
.end method

.method public setRefmarkers(Ljava/util/List;)V
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
    .line 52
    .local p1, "refMarkers":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;->mRefMarkers:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 53
    return-void
.end method
