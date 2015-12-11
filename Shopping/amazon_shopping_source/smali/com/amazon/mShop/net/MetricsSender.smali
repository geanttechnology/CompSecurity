.class public abstract Lcom/amazon/mShop/net/MetricsSender;
.super Ljava/lang/Object;
.source "MetricsSender.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/MetricsSender$SenderType;
    }
.end annotation


# static fields
.field private static sMetricsSenderMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/amazon/mShop/net/MetricsSender$SenderType;",
            "Lcom/amazon/mShop/net/MetricsSender;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/MetricsSender;->sMetricsSenderMap:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    return-void
.end method

.method public static getMetricsSenderByType(Lcom/amazon/mShop/net/MetricsSender$SenderType;)Lcom/amazon/mShop/net/MetricsSender;
    .locals 1
    .param p0, "type"    # Lcom/amazon/mShop/net/MetricsSender$SenderType;

    .prologue
    .line 49
    sget-object v0, Lcom/amazon/mShop/net/MetricsSender;->sMetricsSenderMap:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/MetricsSender;

    return-object v0
.end method

.method public static postAllMetrics(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/net/AggregatedMetrics;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 59
    .local p0, "aggregatedMetricsList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/AggregatedMetrics;>;"
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/AggregatedMetrics;

    .line 60
    .local v0, "aggregatedMetrics":Lcom/amazon/mShop/net/AggregatedMetrics;
    invoke-virtual {v0}, Lcom/amazon/mShop/net/AggregatedMetrics;->getMetricsSender()Lcom/amazon/mShop/net/MetricsSender;

    move-result-object v2

    .line 61
    .local v2, "sender":Lcom/amazon/mShop/net/MetricsSender;
    invoke-virtual {v2, v0}, Lcom/amazon/mShop/net/MetricsSender;->appendAggregatedMetrics(Lcom/amazon/mShop/net/AggregatedMetrics;)V

    goto :goto_0

    .line 65
    .end local v0    # "aggregatedMetrics":Lcom/amazon/mShop/net/AggregatedMetrics;
    .end local v2    # "sender":Lcom/amazon/mShop/net/MetricsSender;
    :cond_0
    sget-object v3, Lcom/amazon/mShop/net/MetricsSender;->sMetricsSenderMap:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/net/MetricsSender;

    .line 66
    .restart local v2    # "sender":Lcom/amazon/mShop/net/MetricsSender;
    invoke-virtual {v2}, Lcom/amazon/mShop/net/MetricsSender;->postMetrics()V

    goto :goto_1

    .line 68
    .end local v2    # "sender":Lcom/amazon/mShop/net/MetricsSender;
    :cond_1
    return-void
.end method

.method public static registerMetricsSender(Lcom/amazon/mShop/net/MetricsSender$SenderType;Lcom/amazon/mShop/net/MetricsSender;)V
    .locals 1
    .param p0, "senderType"    # Lcom/amazon/mShop/net/MetricsSender$SenderType;
    .param p1, "sender"    # Lcom/amazon/mShop/net/MetricsSender;

    .prologue
    .line 40
    sget-object v0, Lcom/amazon/mShop/net/MetricsSender;->sMetricsSenderMap:Ljava/util/Map;

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 41
    return-void
.end method


# virtual methods
.method public abstract appendAggregatedMetrics(Lcom/amazon/mShop/net/AggregatedMetrics;)V
.end method

.method public abstract postMetrics()V
.end method
