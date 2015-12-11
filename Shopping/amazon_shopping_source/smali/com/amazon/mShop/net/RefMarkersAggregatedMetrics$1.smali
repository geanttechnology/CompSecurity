.class final Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics$1;
.super Lcom/amazon/mShop/net/MetricsSender;
.source "RefMarkersAggregatedMetrics.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


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
.method constructor <init>()V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsSender;-><init>()V

    .line 56
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics$1;->mRefMarkers:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public appendAggregatedMetrics(Lcom/amazon/mShop/net/AggregatedMetrics;)V
    .locals 3
    .param p1, "aggregatedMetrics"    # Lcom/amazon/mShop/net/AggregatedMetrics;

    .prologue
    .line 59
    instance-of v1, p1, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;

    if-eqz v1, :cond_0

    move-object v0, p1

    .line 60
    check-cast v0, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;

    .line 62
    .local v0, "refMarkersAggregatedMetrics":Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;
    iget-object v1, p0, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics$1;->mRefMarkers:Ljava/util/List;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;->getRefMarkers()Ljava/util/List;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 64
    .end local v0    # "refMarkersAggregatedMetrics":Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;
    :cond_0
    return-void
.end method

.method public postMetrics()V
    .locals 22

    .prologue
    .line 68
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics$1;->mRefMarkers:Ljava/util/List;

    move-object/from16 v18, v0

    invoke-interface/range {v18 .. v18}, Ljava/util/List;->size()I

    move-result v18

    if-nez v18, :cond_0

    .line 132
    :goto_0
    return-void

    .line 72
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 73
    .local v3, "context":Landroid/content/Context;
    sget v18, Lcom/amazon/mShop/android/lib/R$string;->config_refmarker_clickstream_host:I

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v19

    move/from16 v0, v18

    move-object/from16 v1, v19

    invoke-static {v3, v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 77
    .local v6, "host":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/net/CookieBridge;->getCurrentSessionId()Ljava/lang/String;

    move-result-object v16

    .line 78
    .local v16, "sessionId":Ljava/lang/String;
    invoke-static/range {v16 .. v16}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v18

    if-eqz v18, :cond_1

    .line 79
    const-string/jumbo v16, "123-1234567-1234567"

    .line 84
    :cond_1
    const-string/jumbo v18, "MSH%s"

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    # invokes: Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;->getRandomRequestId()Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics;->access$000()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    .line 87
    .local v13, "requestId":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v18

    sget v19, Lcom/amazon/mShop/android/lib/R$string;->config_marketplace_obfuscated_id:I

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v20

    invoke-static/range {v18 .. v20}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 93
    .local v9, "marketPlaceId":Ljava/lang/String;
    new-instance v12, Ljava/util/HashMap;

    invoke-direct {v12}, Ljava/util/HashMap;-><init>()V

    .line 94
    .local v12, "refMarkerMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics$1;->mRefMarkers:Ljava/util/List;

    move-object/from16 v18, v0

    invoke-interface/range {v18 .. v18}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_3

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 95
    .local v11, "refMarker":Ljava/lang/String;
    const-string/jumbo v18, ":"

    move-object/from16 v0, v18

    invoke-virtual {v11, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v18

    const/16 v19, 0x0

    aget-object v4, v18, v19

    .line 96
    .local v4, "featureName":Ljava/lang/String;
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v18

    add-int/lit8 v18, v18, 0x1

    move/from16 v0, v18

    invoke-virtual {v11, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v14

    .line 97
    .local v14, "resourceID":Ljava/lang/String;
    invoke-interface {v12, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_2

    .line 98
    invoke-interface {v12, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/List;

    .line 99
    .local v8, "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v8, v14}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 101
    .end local v8    # "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_2
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 102
    .restart local v8    # "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v8, v14}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 103
    invoke-interface {v12, v4, v8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 107
    .end local v4    # "featureName":Ljava/lang/String;
    .end local v8    # "list":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v11    # "refMarker":Ljava/lang/String;
    .end local v14    # "resourceID":Ljava/lang/String;
    :cond_3
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    .line 108
    .local v2, "buffer":Ljava/lang/StringBuffer;
    invoke-interface {v12}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v18

    invoke-interface/range {v18 .. v18}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v18

    if-eqz v18, :cond_5

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 109
    .restart local v4    # "featureName":Ljava/lang/String;
    invoke-interface {v12, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Ljava/util/List;

    .line 112
    .local v15, "resourceIDList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v15}, Ljava/util/List;->size()I

    move-result v18

    move/from16 v0, v18

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v0, v18

    invoke-interface {v15, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v18

    check-cast v18, [Ljava/lang/String;

    const-string/jumbo v19, ","

    invoke-static/range {v18 .. v19}, Lcom/amazon/mShop/util/Util;->join([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 113
    .local v5, "formatedRefMarkers":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/StringBuffer;->length()I

    move-result v18

    if-lez v18, :cond_4

    .line 114
    const-string/jumbo v18, "/"

    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v18

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v19

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string/jumbo v20, ":"

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 116
    :cond_4
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v18

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, ":"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 122
    .end local v4    # "featureName":Ljava/lang/String;
    .end local v5    # "formatedRefMarkers":Ljava/lang/String;
    .end local v15    # "resourceIDList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_5
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v18

    sget v19, Lcom/amazon/mShop/android/lib/R$string;->config_refmarker_marketplaceName:I

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v20

    invoke-static/range {v18 .. v20}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 125
    .local v10, "marketPlaceName":Ljava/lang/String;
    const-string/jumbo v18, "https://%1$s/1/action-impressions/1/OP/mshop/action/%2$s?requestId=%3$s&marketplaceId=%4$s&session=%5$s&marketplace=%6$s"

    const/16 v19, 0x6

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    aput-object v6, v19, v20

    const/16 v20, 0x1

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v21

    aput-object v21, v19, v20

    const/16 v20, 0x2

    aput-object v13, v19, v20

    const/16 v20, 0x3

    aput-object v9, v19, v20

    const/16 v20, 0x4

    aput-object v16, v19, v20

    const/16 v20, 0x5

    aput-object v10, v19, v20

    invoke-static/range {v18 .. v19}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v17

    .line 126
    .local v17, "url":Ljava/lang/String;
    invoke-static/range {v17 .. v17}, Lcom/amazon/mShop/net/HttpFetcher;->fetch(Ljava/lang/String;)V

    .line 130
    invoke-interface {v12}, Ljava/util/Map;->clear()V

    .line 131
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/mShop/net/RefMarkersAggregatedMetrics$1;->mRefMarkers:Ljava/util/List;

    move-object/from16 v18, v0

    invoke-interface/range {v18 .. v18}, Ljava/util/List;->clear()V

    goto/16 :goto_0
.end method
