.class public Lcom/amazon/device/analytics/events/DefaultEventRecorder;
.super Ljava/lang/Object;
.source "DefaultEventRecorder.java"

# interfaces
.implements Lcom/amazon/device/analytics/events/EventRecorder;
.implements Lcom/amazon/device/analytics/util/JSONSerializable;


# static fields
.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private final applicationKey:Ljava/lang/String;

.field private final eventTypeAttributes:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private final eventTypeMetrics:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Number;",
            ">;>;"
        }
    .end annotation
.end field

.field private final globalAttributes:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final globalMetrics:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Number;",
            ">;"
        }
    .end annotation
.end field

.field private observers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/device/analytics/events/observers/EventObserver;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const-class v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;)V
    .locals 1
    .param p1, "builder"    # Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->globalAttributes:Ljava/util/Map;

    .line 30
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->globalMetrics:Ljava/util/Map;

    .line 31
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->eventTypeAttributes:Ljava/util/Map;

    .line 32
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->eventTypeMetrics:Ljava/util/Map;

    .line 37
    invoke-virtual {p1}, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;->getObservers()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->observers:Ljava/util/List;

    .line 38
    invoke-virtual {p1}, Lcom/amazon/device/analytics/events/DefaultEventRecorderBuilder;->getApplicationKey()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->applicationKey:Ljava/lang/String;

    .line 39
    return-void
.end method


# virtual methods
.method public addGlobalAttribute(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 114
    if-nez p1, :cond_0

    .line 115
    sget-object v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v1, "Null key provided to addGlobalAttribute"

    invoke-virtual {v0, v1}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 125
    :goto_0
    return-void

    .line 119
    :cond_0
    if-nez p2, :cond_1

    .line 120
    sget-object v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->logger:Lcom/amazon/device/analytics/log/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Null value provided to addGlobalAttribute. key:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    goto :goto_0

    .line 124
    :cond_1
    iget-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->globalAttributes:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public createEvent(Ljava/lang/String;)Lcom/amazon/device/analytics/events/Event;
    .locals 2
    .param p1, "eventType"    # Ljava/lang/String;

    .prologue
    .line 105
    new-instance v0, Lcom/amazon/device/analytics/events/Event;

    iget-object v1, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->applicationKey:Ljava/lang/String;

    invoke-direct {v0, v1, p1}, Lcom/amazon/device/analytics/events/Event;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public getObservers()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/device/analytics/events/observers/EventObserver;",
            ">;"
        }
    .end annotation

    .prologue
    .line 264
    iget-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->observers:Ljava/util/List;

    if-nez v0, :cond_0

    .line 265
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->observers:Ljava/util/List;

    .line 267
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->observers:Ljava/util/List;

    return-object v0
.end method

.method public notifyObservers(Lcom/amazon/device/analytics/events/Event;)V
    .locals 4
    .param p1, "event"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 276
    sget-object v2, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v3, "Notifying EventObservers"

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 277
    sget-object v2, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->logger:Lcom/amazon/device/analytics/log/Logger;

    sget-object v3, Lcom/amazon/device/analytics/log/Logging$LogLevel;->VERBOSE:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/log/Logger;->isLoggingEnabled(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 278
    sget-object v2, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->logger:Lcom/amazon/device/analytics/log/Logger;

    invoke-virtual {p1}, Lcom/amazon/device/analytics/events/Event;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 280
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->getObservers()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/device/analytics/events/observers/EventObserver;

    .line 281
    .local v1, "observer":Lcom/amazon/device/analytics/events/observers/EventObserver;
    invoke-interface {v1, p1}, Lcom/amazon/device/analytics/events/observers/EventObserver;->notify(Lcom/amazon/device/analytics/events/Event;)V

    goto :goto_0

    .line 283
    .end local v1    # "observer":Lcom/amazon/device/analytics/events/observers/EventObserver;
    :cond_1
    return-void
.end method

.method public recordEvent(Lcom/amazon/device/analytics/events/Event;)V
    .locals 9
    .param p1, "event"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 47
    if-nez p1, :cond_0

    .line 48
    sget-object v4, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v5, "The provided event was null"

    invoke-virtual {v4, v5}, Lcom/amazon/device/analytics/log/Logger;->i(Ljava/lang/String;)V

    .line 97
    :goto_0
    return-void

    .line 53
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/device/analytics/events/Event;->copy()Lcom/amazon/device/analytics/events/Event;

    move-result-object v3

    .line 54
    .local v3, "recordEvent":Lcom/amazon/device/analytics/events/Event;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/device/analytics/events/Event;->setEventTimestamp(Ljava/lang/Long;)V

    .line 55
    invoke-static {}, Lcom/amazon/device/analytics/events/UniqueIdService;->getUniqueId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/device/analytics/events/Event;->setUniqueId(Ljava/lang/String;)V

    .line 58
    monitor-enter p0

    .line 59
    :try_start_0
    iget-object v4, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->eventTypeAttributes:Ljava/util/Map;

    invoke-virtual {v3}, Lcom/amazon/device/analytics/events/Event;->getEventType()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 60
    iget-object v4, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->eventTypeAttributes:Ljava/util/Map;

    invoke-virtual {v3}, Lcom/amazon/device/analytics/events/Event;->getEventType()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 61
    .local v0, "attr":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/amazon/device/analytics/events/Event;->hasAttribute(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 63
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 90
    .end local v0    # "attr":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v4

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4

    .line 68
    :cond_2
    :try_start_1
    iget-object v4, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->globalAttributes:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_3
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 69
    .restart local v0    # "attr":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/amazon/device/analytics/events/Event;->hasAttribute(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 71
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 75
    .end local v0    # "attr":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_4
    iget-object v4, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->eventTypeMetrics:Ljava/util/Map;

    invoke-virtual {v3}, Lcom/amazon/device/analytics/events/Event;->getEventType()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 76
    iget-object v4, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->eventTypeMetrics:Ljava/util/Map;

    invoke-virtual {v3}, Lcom/amazon/device/analytics/events/Event;->getEventType()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_5
    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 77
    .local v2, "metric":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Number;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/amazon/device/analytics/events/Event;->hasMetric(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_5

    .line 79
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v3, v4, v5}, Lcom/amazon/device/analytics/events/Event;->addMetric(Ljava/lang/String;Ljava/lang/Number;)V

    goto :goto_3

    .line 84
    .end local v2    # "metric":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Number;>;"
    :cond_6
    iget-object v4, p0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->globalMetrics:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_7
    :goto_4
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 85
    .restart local v2    # "metric":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Number;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/amazon/device/analytics/events/Event;->hasMetric(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_7

    .line 87
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Number;

    invoke-virtual {v3, v4, v5}, Lcom/amazon/device/analytics/events/Event;->addMetric(Ljava/lang/String;Ljava/lang/Number;)V

    goto :goto_4

    .line 90
    .end local v2    # "metric":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Number;>;"
    :cond_8
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 92
    sget-object v4, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->logger:Lcom/amazon/device/analytics/log/Logger;

    sget-object v5, Lcom/amazon/device/analytics/log/Logging$LogLevel;->VERBOSE:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {v4, v5}, Lcom/amazon/device/analytics/log/Logger;->isLoggingEnabled(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 93
    sget-object v4, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v5, "Recording Event: %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v3}, Lcom/amazon/device/analytics/events/Event;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 96
    :cond_9
    invoke-virtual {p0, v3}, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->notifyObservers(Lcom/amazon/device/analytics/events/Event;)V

    goto/16 :goto_0
.end method

.method public toJSONObject()Lorg/json/JSONObject;
    .locals 23

    .prologue
    .line 366
    new-instance v19, Lorg/json/JSONArray;

    invoke-direct/range {v19 .. v19}, Lorg/json/JSONArray;-><init>()V

    .line 367
    .local v19, "observersJSON":Lorg/json/JSONArray;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->observers:Ljava/util/List;

    move-object/from16 v20, v0

    if-eqz v20, :cond_1

    .line 368
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->observers:Ljava/util/List;

    move-object/from16 v20, v0

    invoke-interface/range {v20 .. v20}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v16

    .local v16, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_1

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lcom/amazon/device/analytics/events/observers/EventObserver;

    .line 369
    .local v18, "observer":Lcom/amazon/device/analytics/events/observers/EventObserver;
    const-class v20, Lcom/amazon/device/analytics/util/JSONSerializable;

    invoke-virtual/range {v18 .. v18}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v21

    invoke-virtual/range {v20 .. v21}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v20

    if-eqz v20, :cond_0

    .line 370
    check-cast v18, Lcom/amazon/device/analytics/util/JSONSerializable;

    .end local v18    # "observer":Lcom/amazon/device/analytics/events/observers/EventObserver;
    invoke-interface/range {v18 .. v18}, Lcom/amazon/device/analytics/util/JSONSerializable;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_0

    .line 372
    .restart local v18    # "observer":Lcom/amazon/device/analytics/events/observers/EventObserver;
    :cond_0
    move-object/from16 v0, v19

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_0

    .line 377
    .end local v16    # "i$":Ljava/util/Iterator;
    .end local v18    # "observer":Lcom/amazon/device/analytics/events/observers/EventObserver;
    :cond_1
    new-instance v14, Lorg/json/JSONArray;

    invoke-direct {v14}, Lorg/json/JSONArray;-><init>()V

    .line 378
    .local v14, "globalAttrs":Lorg/json/JSONArray;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->globalAttributes:Ljava/util/Map;

    move-object/from16 v20, v0

    if-eqz v20, :cond_2

    .line 379
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->globalAttributes:Ljava/util/Map;

    move-object/from16 v20, v0

    invoke-interface/range {v20 .. v20}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v16

    .restart local v16    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_2

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/Map$Entry;

    .line 381
    .local v7, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 382
    .local v3, "attr":Lorg/json/JSONObject;
    invoke-interface {v7}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    invoke-interface {v7}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 383
    invoke-virtual {v14, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 384
    .end local v3    # "attr":Lorg/json/JSONObject;
    :catch_0
    move-exception v20

    goto :goto_1

    .line 389
    .end local v7    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v16    # "i$":Ljava/util/Iterator;
    :cond_2
    new-instance v15, Lorg/json/JSONArray;

    invoke-direct {v15}, Lorg/json/JSONArray;-><init>()V

    .line 390
    .local v15, "globalMets":Lorg/json/JSONArray;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->globalMetrics:Ljava/util/Map;

    move-object/from16 v20, v0

    if-eqz v20, :cond_3

    .line 391
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->globalMetrics:Ljava/util/Map;

    move-object/from16 v20, v0

    invoke-interface/range {v20 .. v20}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v16

    .restart local v16    # "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_3

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map$Entry;

    .line 393
    .local v6, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Number;>;"
    :try_start_1
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 394
    .restart local v3    # "attr":Lorg/json/JSONObject;
    invoke-interface {v6}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    invoke-interface {v6}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 395
    invoke-virtual {v15, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_2

    .line 396
    .end local v3    # "attr":Lorg/json/JSONObject;
    :catch_1
    move-exception v20

    goto :goto_2

    .line 401
    .end local v6    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Number;>;"
    .end local v16    # "i$":Ljava/util/Iterator;
    :cond_3
    new-instance v12, Lorg/json/JSONObject;

    invoke-direct {v12}, Lorg/json/JSONObject;-><init>()V

    .line 402
    .local v12, "eventTypesAttributesJson":Lorg/json/JSONObject;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->eventTypeAttributes:Ljava/util/Map;

    move-object/from16 v20, v0

    if-eqz v20, :cond_5

    .line 403
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->eventTypeAttributes:Ljava/util/Map;

    move-object/from16 v20, v0

    invoke-interface/range {v20 .. v20}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :goto_3
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_5

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/util/Map$Entry;

    .line 404
    .local v9, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    new-instance v10, Lorg/json/JSONArray;

    invoke-direct {v10}, Lorg/json/JSONArray;-><init>()V

    .line 405
    .local v10, "eventTypeAttrs":Lorg/json/JSONArray;
    invoke-interface {v9}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/util/Map;

    invoke-interface/range {v20 .. v20}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v17

    .local v17, "i$":Ljava/util/Iterator;
    :goto_4
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_4

    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    .line 407
    .local v5, "attrEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_2
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 408
    .restart local v3    # "attr":Lorg/json/JSONObject;
    invoke-interface {v5}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 409
    invoke-virtual {v10, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    goto :goto_4

    .line 410
    .end local v3    # "attr":Lorg/json/JSONObject;
    :catch_2
    move-exception v20

    goto :goto_4

    .line 414
    .end local v5    # "attrEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_4
    :try_start_3
    invoke-interface {v9}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    move-object/from16 v0, v20

    invoke-virtual {v12, v0, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_3

    goto :goto_3

    .line 415
    :catch_3
    move-exception v20

    goto :goto_3

    .line 420
    .end local v9    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    .end local v10    # "eventTypeAttrs":Lorg/json/JSONArray;
    .end local v17    # "i$":Ljava/util/Iterator;
    :cond_5
    new-instance v13, Lorg/json/JSONObject;

    invoke-direct {v13}, Lorg/json/JSONObject;-><init>()V

    .line 421
    .local v13, "eventTypesMetricsJson":Lorg/json/JSONObject;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->eventTypeMetrics:Ljava/util/Map;

    move-object/from16 v20, v0

    if-eqz v20, :cond_7

    .line 422
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->eventTypeMetrics:Ljava/util/Map;

    move-object/from16 v20, v0

    invoke-interface/range {v20 .. v20}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :goto_5
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_7

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map$Entry;

    .line 423
    .local v8, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/Number;>;>;"
    new-instance v11, Lorg/json/JSONArray;

    invoke-direct {v11}, Lorg/json/JSONArray;-><init>()V

    .line 424
    .local v11, "eventTypeMets":Lorg/json/JSONArray;
    invoke-interface {v8}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/util/Map;

    invoke-interface/range {v20 .. v20}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v20

    invoke-interface/range {v20 .. v20}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v17

    .restart local v17    # "i$":Ljava/util/Iterator;
    :goto_6
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v20

    if-eqz v20, :cond_6

    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    .line 426
    .local v4, "attrEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Number;>;"
    :try_start_4
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3}, Lorg/json/JSONObject;-><init>()V

    .line 427
    .restart local v3    # "attr":Lorg/json/JSONObject;
    invoke-interface {v4}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v21

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v3, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 428
    invoke-virtual {v11, v3}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_4

    goto :goto_6

    .line 429
    .end local v3    # "attr":Lorg/json/JSONObject;
    :catch_4
    move-exception v20

    goto :goto_6

    .line 433
    .end local v4    # "attrEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Number;>;"
    :cond_6
    :try_start_5
    invoke-interface {v8}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/String;

    move-object/from16 v0, v20

    invoke-virtual {v13, v0, v11}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_5

    goto :goto_5

    .line 434
    :catch_5
    move-exception v20

    goto :goto_5

    .line 439
    .end local v8    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/Number;>;>;"
    .end local v11    # "eventTypeMets":Lorg/json/JSONArray;
    .end local v17    # "i$":Ljava/util/Iterator;
    :cond_7
    new-instance v20, Lcom/amazon/device/analytics/util/JSONBuilder;

    move-object/from16 v0, v20

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/amazon/device/analytics/util/JSONBuilder;-><init>(Ljava/lang/Object;)V

    const-string/jumbo v21, "applicationKey"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->applicationKey:Ljava/lang/String;

    move-object/from16 v22, v0

    invoke-virtual/range {v20 .. v22}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    move-result-object v20

    const-string/jumbo v21, "uniqueId"

    invoke-static {}, Lcom/amazon/device/analytics/events/UniqueIdService;->getUniqueId()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v20 .. v22}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    move-result-object v20

    const-string/jumbo v21, "observers"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v19

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    move-result-object v20

    const-string/jumbo v21, "globalAttributes"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v0, v1, v14}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    move-result-object v20

    const-string/jumbo v21, "globalMetrics"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v0, v1, v15}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    move-result-object v20

    const-string/jumbo v21, "eventTypeAttributes"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v0, v1, v12}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    move-result-object v20

    const-string/jumbo v21, "eventTypeMetrics"

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-virtual {v0, v1, v13}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Lcom/amazon/device/analytics/util/JSONBuilder;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v20

    return-object v20
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 355
    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/DefaultEventRecorder;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v1

    .line 357
    .local v1, "json":Lorg/json/JSONObject;
    const/4 v2, 0x4

    :try_start_0
    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 359
    :goto_0
    return-object v2

    .line 358
    :catch_0
    move-exception v0

    .line 359
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method
