.class final Lcom/amazon/mShop/net/CallObserver$1;
.super Lcom/amazon/mShop/net/MetricsAggregator;
.source "CallObserver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/CallObserver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 123
    invoke-direct {p0}, Lcom/amazon/mShop/net/MetricsAggregator;-><init>()V

    return-void
.end method


# virtual methods
.method public aggregate(Ljava/util/List;)Lcom/amazon/mShop/net/AggregatedMetrics;
    .locals 31
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;",
            ">;)",
            "Lcom/amazon/mShop/net/AggregatedMetrics;"
        }
    .end annotation

    .prologue
    .line 129
    .local p1, "events":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;>;"
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->getCurrentCarrierName()Ljava/lang/String;

    move-result-object v16

    .line 132
    .local v16, "carrier":Ljava/lang/String;
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 135
    .local v2, "aggregatedMetrics":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 138
    .local v5, "availability":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;>;"
    new-instance v13, Ljava/util/HashMap;

    invoke-direct {v13}, Ljava/util/HashMap;-><init>()V

    .line 141
    .local v13, "cacheHits":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;>;"
    new-instance v17, Ljava/util/ArrayList;

    invoke-direct/range {v17 .. v17}, Ljava/util/ArrayList;-><init>()V

    .line 143
    .local v17, "clientMetrics":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;>;"
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v21

    .local v21, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->hasNext()Z

    move-result v29

    if-eqz v29, :cond_a

    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;

    .line 144
    .local v19, "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    move-object/from16 v0, v19

    instance-of v0, v0, Lcom/amazon/mShop/net/CallObserver;

    move/from16 v29, v0

    if-eqz v29, :cond_0

    move-object/from16 v15, v19

    .line 146
    check-cast v15, Lcom/amazon/mShop/net/CallObserver;

    .line 147
    .local v15, "callObserver":Lcom/amazon/mShop/net/CallObserver;
    monitor-enter v15

    .line 151
    :try_start_0
    invoke-virtual {v15}, Lcom/amazon/mShop/net/CallObserver;->getServiceCallIdentifier()Lcom/amazon/mShop/net/ServiceCallIdentifier;

    move-result-object v27

    .line 152
    .local v27, "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    invoke-virtual/range {v27 .. v27}, Lcom/amazon/mShop/net/ServiceCallIdentifier;->getServiceName()Ljava/lang/String;

    move-result-object v26

    .line 153
    .local v26, "service":Ljava/lang/String;
    invoke-virtual/range {v27 .. v27}, Lcom/amazon/mShop/net/ServiceCallIdentifier;->getMethodName()Ljava/lang/String;

    move-result-object v25

    .line 168
    .local v25, "method":Ljava/lang/String;
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v29

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string/jumbo v30, "/"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    move-object/from16 v0, v29

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string/jumbo v30, "/"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    move-object/from16 v0, v29

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string/jumbo v30, "/Time"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    .line 170
    .local v23, "latencyMetricName":Ljava/lang/String;
    move-object/from16 v0, v23

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v22

    check-cast v22, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    .line 171
    .local v22, "latencyMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    if-nez v22, :cond_2

    .line 172
    new-instance v22, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    .end local v22    # "latencyMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-direct/range {v22 .. v22}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;-><init>()V

    .line 173
    .restart local v22    # "latencyMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-virtual/range {v22 .. v23}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setName(Ljava/lang/String;)V

    .line 174
    move-object/from16 v0, v23

    move-object/from16 v1, v22

    invoke-interface {v2, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 175
    const/16 v29, 0x1

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v29

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setCount(Ljava/lang/Integer;)V

    .line 176
    invoke-virtual {v15}, Lcom/amazon/mShop/net/CallObserver;->getTotalTime()I

    move-result v29

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v29

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setTime(Ljava/lang/Integer;)V

    .line 183
    :goto_1
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v29

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string/jumbo v30, "/"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    move-object/from16 v0, v29

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    .line 189
    .local v28, "serviceCallKey":Ljava/lang/String;
    invoke-virtual {v15}, Lcom/amazon/mShop/net/CallObserver;->isStatusFailed()Z

    move-result v20

    .line 190
    .local v20, "failed":Z
    move-object/from16 v0, v28

    invoke-interface {v5, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;

    .line 191
    .local v4, "availCounter":Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;
    if-nez v4, :cond_4

    .line 192
    new-instance v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;

    .end local v4    # "availCounter":Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;
    const/16 v29, 0x0

    move-object/from16 v0, v29

    invoke-direct {v4, v0}, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;-><init>(Lcom/amazon/mShop/net/CallObserver$1;)V

    .line 193
    .restart local v4    # "availCounter":Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;
    const/16 v29, 0x1

    move/from16 v0, v29

    iput v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->totalCount:I

    .line 194
    if-eqz v20, :cond_3

    const/16 v29, 0x0

    :goto_2
    move/from16 v0, v29

    iput v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->successCount:I

    .line 195
    invoke-virtual {v15}, Lcom/amazon/mShop/net/CallObserver;->getErrorMessage()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v29

    iput-object v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->errors:Ljava/lang/String;

    .line 196
    move-object/from16 v0, v28

    invoke-interface {v5, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 217
    :cond_1
    :goto_3
    invoke-virtual {v15}, Lcom/amazon/mShop/net/CallObserver;->getCacheHit()Z

    move-result v14

    .line 218
    .local v14, "cached":Z
    move-object/from16 v0, v28

    invoke-interface {v13, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;

    .line 219
    .local v10, "cacheHitCounter":Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;
    if-nez v10, :cond_8

    .line 220
    new-instance v10, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;

    .end local v10    # "cacheHitCounter":Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;
    const/16 v29, 0x0

    move-object/from16 v0, v29

    invoke-direct {v10, v0}, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;-><init>(Lcom/amazon/mShop/net/CallObserver$1;)V

    .line 221
    .restart local v10    # "cacheHitCounter":Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;
    const/16 v29, 0x1

    move/from16 v0, v29

    iput v0, v10, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;->totalCount:I

    .line 222
    if-eqz v14, :cond_7

    const/16 v29, 0x1

    :goto_4
    move/from16 v0, v29

    iput v0, v10, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;->hitCount:I

    .line 223
    move-object/from16 v0, v28

    invoke-interface {v13, v0, v10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 229
    :goto_5
    monitor-exit v15

    goto/16 :goto_0

    .end local v4    # "availCounter":Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;
    .end local v10    # "cacheHitCounter":Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;
    .end local v14    # "cached":Z
    .end local v20    # "failed":Z
    .end local v22    # "latencyMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    .end local v23    # "latencyMetricName":Ljava/lang/String;
    .end local v25    # "method":Ljava/lang/String;
    .end local v26    # "service":Ljava/lang/String;
    .end local v27    # "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    .end local v28    # "serviceCallKey":Ljava/lang/String;
    :catchall_0
    move-exception v29

    monitor-exit v15
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v29

    .line 178
    .restart local v22    # "latencyMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    .restart local v23    # "latencyMetricName":Ljava/lang/String;
    .restart local v25    # "method":Ljava/lang/String;
    .restart local v26    # "service":Ljava/lang/String;
    .restart local v27    # "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    :cond_2
    :try_start_1
    invoke-virtual/range {v22 .. v22}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getCount()Ljava/lang/Integer;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/Integer;->intValue()I

    move-result v29

    add-int/lit8 v29, v29, 0x1

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v29

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setCount(Ljava/lang/Integer;)V

    .line 179
    invoke-virtual/range {v22 .. v22}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->getTime()Ljava/lang/Integer;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/Integer;->intValue()I

    move-result v29

    invoke-virtual {v15}, Lcom/amazon/mShop/net/CallObserver;->getTotalTime()I

    move-result v30

    add-int v29, v29, v30

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v29

    move-object/from16 v0, v22

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setTime(Ljava/lang/Integer;)V

    goto/16 :goto_1

    .line 194
    .restart local v4    # "availCounter":Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;
    .restart local v20    # "failed":Z
    .restart local v28    # "serviceCallKey":Ljava/lang/String;
    :cond_3
    const/16 v29, 0x1

    goto :goto_2

    .line 198
    :cond_4
    iget v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->totalCount:I

    move/from16 v29, v0

    add-int/lit8 v29, v29, 0x1

    move/from16 v0, v29

    iput v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->totalCount:I

    .line 199
    iget v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->successCount:I

    move/from16 v30, v0

    if-eqz v20, :cond_5

    const/16 v29, 0x0

    :goto_6
    add-int v29, v29, v30

    move/from16 v0, v29

    iput v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->successCount:I

    .line 200
    invoke-virtual {v15}, Lcom/amazon/mShop/net/CallObserver;->getErrorMessage()Ljava/lang/String;

    move-result-object v18

    .line 201
    .local v18, "error":Ljava/lang/String;
    invoke-static/range {v18 .. v18}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v29

    if-nez v29, :cond_1

    .line 202
    iget-object v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->errors:Ljava/lang/String;

    move-object/from16 v29, v0

    invoke-static/range {v29 .. v29}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_6

    .line 203
    move-object/from16 v0, v18

    iput-object v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->errors:Ljava/lang/String;

    goto/16 :goto_3

    .line 199
    .end local v18    # "error":Ljava/lang/String;
    :cond_5
    const/16 v29, 0x1

    goto :goto_6

    .line 204
    .restart local v18    # "error":Ljava/lang/String;
    :cond_6
    iget-object v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->errors:Ljava/lang/String;

    move-object/from16 v29, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v29

    if-nez v29, :cond_1

    .line 207
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->errors:Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string/jumbo v30, ","

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    move-object/from16 v0, v29

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v29

    iput-object v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->errors:Ljava/lang/String;

    goto/16 :goto_3

    .line 222
    .end local v18    # "error":Ljava/lang/String;
    .restart local v10    # "cacheHitCounter":Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;
    .restart local v14    # "cached":Z
    :cond_7
    const/16 v29, 0x0

    goto/16 :goto_4

    .line 225
    :cond_8
    iget v0, v10, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;->totalCount:I

    move/from16 v29, v0

    add-int/lit8 v29, v29, 0x1

    move/from16 v0, v29

    iput v0, v10, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;->totalCount:I

    .line 226
    iget v0, v10, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;->hitCount:I

    move/from16 v30, v0

    if-eqz v14, :cond_9

    const/16 v29, 0x1

    :goto_7
    add-int v29, v29, v30

    move/from16 v0, v29

    iput v0, v10, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;->hitCount:I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_5

    :cond_9
    const/16 v29, 0x0

    goto :goto_7

    .line 232
    .end local v4    # "availCounter":Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;
    .end local v10    # "cacheHitCounter":Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;
    .end local v14    # "cached":Z
    .end local v15    # "callObserver":Lcom/amazon/mShop/net/CallObserver;
    .end local v19    # "event":Lcom/amazon/mShop/net/MetricsAggregator$MetricEvent;
    .end local v20    # "failed":Z
    .end local v22    # "latencyMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    .end local v23    # "latencyMetricName":Ljava/lang/String;
    .end local v25    # "method":Ljava/lang/String;
    .end local v26    # "service":Ljava/lang/String;
    .end local v27    # "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    .end local v28    # "serviceCallKey":Ljava/lang/String;
    :cond_a
    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v29

    move-object/from16 v0, v17

    move-object/from16 v1, v29

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 238
    invoke-interface {v5}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v29

    invoke-interface/range {v29 .. v29}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v21

    :goto_8
    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->hasNext()Z

    move-result v29

    if-eqz v29, :cond_b

    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 239
    .local v3, "avail":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;

    .line 243
    .restart local v4    # "availCounter":Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v29

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string/jumbo v30, "/"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Ljava/lang/String;

    move-object/from16 v0, v30

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string/jumbo v30, "/availability:critical"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 245
    .local v7, "availabilityMetricName":Ljava/lang/String;
    new-instance v6, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    invoke-direct {v6}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;-><init>()V

    .line 246
    .local v6, "availabilityMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-virtual {v6, v7}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setName(Ljava/lang/String;)V

    .line 247
    iget v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->successCount:I

    move/from16 v29, v0

    mul-int/lit8 v29, v29, 0x64

    iget v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->totalCount:I

    move/from16 v30, v0

    div-int v29, v29, v30

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v29

    move-object/from16 v0, v29

    invoke-virtual {v6, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setCount(Ljava/lang/Integer;)V

    .line 249
    iget-object v0, v4, Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;->errors:Ljava/lang/String;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    invoke-virtual {v6, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setInfo(Ljava/lang/String;)V

    .line 251
    move-object/from16 v0, v17

    invoke-interface {v0, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_8

    .line 257
    .end local v3    # "avail":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;>;"
    .end local v4    # "availCounter":Lcom/amazon/mShop/net/CallObserver$AvailabilityCounter;
    .end local v6    # "availabilityMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    .end local v7    # "availabilityMetricName":Ljava/lang/String;
    :cond_b
    invoke-interface {v13}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v29

    invoke-interface/range {v29 .. v29}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v21

    :goto_9
    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->hasNext()Z

    move-result v29

    if-eqz v29, :cond_c

    invoke-interface/range {v21 .. v21}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map$Entry;

    .line 258
    .local v8, "cache":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;>;"
    invoke-interface {v8}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;

    .line 262
    .local v9, "cacheCounter":Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;
    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v29

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string/jumbo v30, "/"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-interface {v8}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v29

    check-cast v29, Ljava/lang/String;

    move-object/from16 v0, v30

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string/jumbo v30, "/cacheHit"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 264
    .local v12, "cacheHitMetricName":Ljava/lang/String;
    new-instance v11, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;

    invoke-direct {v11}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;-><init>()V

    .line 265
    .local v11, "cacheHitMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    invoke-virtual {v11, v12}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setName(Ljava/lang/String;)V

    .line 266
    iget v0, v9, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;->hitCount:I

    move/from16 v29, v0

    mul-int/lit8 v29, v29, 0x64

    iget v0, v9, Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;->totalCount:I

    move/from16 v30, v0

    div-int v29, v29, v30

    invoke-static/range {v29 .. v29}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v29

    move-object/from16 v0, v29

    invoke-virtual {v11, v0}, Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;->setCount(Ljava/lang/Integer;)V

    .line 267
    move-object/from16 v0, v17

    invoke-interface {v0, v11}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_9

    .line 269
    .end local v8    # "cache":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;>;"
    .end local v9    # "cacheCounter":Lcom/amazon/mShop/net/CallObserver$CacheHitCounter;
    .end local v11    # "cacheHitMetric":Lcom/amazon/rio/j2me/client/services/mShop/ClientMetric;
    .end local v12    # "cacheHitMetricName":Ljava/lang/String;
    :cond_c
    new-instance v24, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;

    invoke-direct/range {v24 .. v24}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;-><init>()V

    .line 270
    .local v24, "mShopAggregatedMetrics":Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;
    move-object/from16 v0, v24

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/net/MShopAggregatedClientMetrics;->setMetrics(Ljava/util/List;)V

    .line 271
    return-object v24
.end method
