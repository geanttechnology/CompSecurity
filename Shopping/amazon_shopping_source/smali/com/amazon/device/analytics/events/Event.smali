.class public final Lcom/amazon/device/analytics/events/Event;
.super Ljava/lang/Object;
.source "Event.java"

# interfaces
.implements Lcom/amazon/device/analytics/util/JSONSerializable;


# instance fields
.field private applicationKey:Ljava/lang/String;

.field private final attributes:Ljava/util/Map;
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

.field private eventType:Ljava/lang/String;

.field private final metrics:Ljava/util/Map;
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

.field private timestamp:Ljava/lang/Long;

.field private uniqueId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/device/analytics/events/Event;)V
    .locals 7
    .param p1, "copyEvent"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    const/4 v6, 0x0

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v5, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v5}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v5, p0, Lcom/amazon/device/analytics/events/Event;->attributes:Ljava/util/Map;

    .line 25
    new-instance v5, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v5}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v5, p0, Lcom/amazon/device/analytics/events/Event;->metrics:Ljava/util/Map;

    .line 26
    iput-object v6, p0, Lcom/amazon/device/analytics/events/Event;->timestamp:Ljava/lang/Long;

    .line 27
    iput-object v6, p0, Lcom/amazon/device/analytics/events/Event;->uniqueId:Ljava/lang/String;

    .line 41
    if-eqz p1, :cond_1

    .line 42
    invoke-virtual {p1}, Lcom/amazon/device/analytics/events/Event;->getApplicationKey()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/amazon/device/analytics/events/Event;->applicationKey:Ljava/lang/String;

    .line 43
    invoke-virtual {p1}, Lcom/amazon/device/analytics/events/Event;->getEventType()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/amazon/device/analytics/events/Event;->eventType:Ljava/lang/String;

    .line 44
    invoke-virtual {p1}, Lcom/amazon/device/analytics/events/Event;->getEventTimestamp()Ljava/lang/Long;

    move-result-object v5

    iput-object v5, p0, Lcom/amazon/device/analytics/events/Event;->timestamp:Ljava/lang/Long;

    .line 45
    invoke-virtual {p1}, Lcom/amazon/device/analytics/events/Event;->getUniqueId()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lcom/amazon/device/analytics/events/Event;->uniqueId:Ljava/lang/String;

    .line 46
    invoke-virtual {p1}, Lcom/amazon/device/analytics/events/Event;->getAllAttributes()Ljava/util/Map;

    move-result-object v0

    .line 47
    .local v0, "attrs":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 48
    .local v3, "kvp":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {p0, v5, v6}, Lcom/amazon/device/analytics/events/Event;->addAttribute(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 51
    .end local v3    # "kvp":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/device/analytics/events/Event;->getAllMetrics()Ljava/util/Map;

    move-result-object v4

    .line 52
    .local v4, "metrics":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Number;>;"
    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 53
    .local v2, "kvp":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Number;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Number;

    invoke-virtual {p0, v5, v6}, Lcom/amazon/device/analytics/events/Event;->addMetric(Ljava/lang/String;Ljava/lang/Number;)V

    goto :goto_1

    .line 56
    .end local v0    # "attrs":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "kvp":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Number;>;"
    .end local v4    # "metrics":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Number;>;"
    :cond_1
    iput-object v6, p0, Lcom/amazon/device/analytics/events/Event;->applicationKey:Ljava/lang/String;

    .line 57
    iput-object v6, p0, Lcom/amazon/device/analytics/events/Event;->eventType:Ljava/lang/String;

    .line 59
    :cond_2
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "applicationKey"    # Ljava/lang/String;
    .param p2, "eventType"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/events/Event;->attributes:Ljava/util/Map;

    .line 25
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/events/Event;->metrics:Ljava/util/Map;

    .line 26
    iput-object v1, p0, Lcom/amazon/device/analytics/events/Event;->timestamp:Ljava/lang/Long;

    .line 27
    iput-object v1, p0, Lcom/amazon/device/analytics/events/Event;->uniqueId:Ljava/lang/String;

    .line 30
    iput-object p1, p0, Lcom/amazon/device/analytics/events/Event;->applicationKey:Ljava/lang/String;

    .line 31
    iput-object p2, p0, Lcom/amazon/device/analytics/events/Event;->eventType:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/device/analytics/events/Event;)V
    .locals 0
    .param p1, "applicationKey"    # Ljava/lang/String;
    .param p2, "eventType"    # Ljava/lang/String;
    .param p3, "copyEvent"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 35
    invoke-direct {p0, p3}, Lcom/amazon/device/analytics/events/Event;-><init>(Lcom/amazon/device/analytics/events/Event;)V

    .line 36
    iput-object p1, p0, Lcom/amazon/device/analytics/events/Event;->applicationKey:Ljava/lang/String;

    .line 37
    iput-object p2, p0, Lcom/amazon/device/analytics/events/Event;->eventType:Ljava/lang/String;

    .line 38
    return-void
.end method


# virtual methods
.method public addAttribute(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/device/analytics/events/Event;->attributes:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    return-void
.end method

.method public addMetric(Ljava/lang/String;Ljava/lang/Number;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Number;

    .prologue
    .line 70
    if-eqz p2, :cond_0

    .line 71
    iget-object v0, p0, Lcom/amazon/device/analytics/events/Event;->metrics:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    :cond_0
    return-void
.end method

.method public copy()Lcom/amazon/device/analytics/events/Event;
    .locals 1

    .prologue
    .line 130
    new-instance v0, Lcom/amazon/device/analytics/events/Event;

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/events/Event;-><init>(Lcom/amazon/device/analytics/events/Event;)V

    return-object v0
.end method

.method public getAllAttributes()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 122
    iget-object v0, p0, Lcom/amazon/device/analytics/events/Event;->attributes:Ljava/util/Map;

    return-object v0
.end method

.method public getAllMetrics()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Number;",
            ">;"
        }
    .end annotation

    .prologue
    .line 126
    iget-object v0, p0, Lcom/amazon/device/analytics/events/Event;->metrics:Ljava/util/Map;

    return-object v0
.end method

.method public getApplicationKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/device/analytics/events/Event;->applicationKey:Ljava/lang/String;

    return-object v0
.end method

.method public getEventTimestamp()Ljava/lang/Long;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/device/analytics/events/Event;->timestamp:Ljava/lang/Long;

    return-object v0
.end method

.method public getEventType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/device/analytics/events/Event;->eventType:Ljava/lang/String;

    return-object v0
.end method

.method public getMetric(Ljava/lang/String;)Ljava/lang/Number;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/amazon/device/analytics/events/Event;->metrics:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Number;

    return-object v0
.end method

.method public getUniqueId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/amazon/device/analytics/events/Event;->uniqueId:Ljava/lang/String;

    return-object v0
.end method

.method public hasAttribute(Ljava/lang/String;)Z
    .locals 1
    .param p1, "attributeName"    # Ljava/lang/String;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/device/analytics/events/Event;->attributes:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public hasMetric(Ljava/lang/String;)Z
    .locals 1
    .param p1, "metricName"    # Ljava/lang/String;

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/device/analytics/events/Event;->metrics:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public setEventTimestamp(Ljava/lang/Long;)V
    .locals 0
    .param p1, "timestamp"    # Ljava/lang/Long;

    .prologue
    .line 96
    iput-object p1, p0, Lcom/amazon/device/analytics/events/Event;->timestamp:Ljava/lang/Long;

    .line 97
    return-void
.end method

.method public setUniqueId(Ljava/lang/String;)V
    .locals 0
    .param p1, "uniqueId"    # Ljava/lang/String;

    .prologue
    .line 104
    iput-object p1, p0, Lcom/amazon/device/analytics/events/Event;->uniqueId:Ljava/lang/String;

    .line 105
    return-void
.end method

.method public toJSONObject()Lorg/json/JSONObject;
    .locals 10

    .prologue
    .line 145
    new-instance v1, Lcom/amazon/device/analytics/util/JSONBuilder;

    invoke-direct {v1, p0}, Lcom/amazon/device/analytics/util/JSONBuilder;-><init>(Ljava/lang/Object;)V

    .line 147
    .local v1, "builder":Lcom/amazon/device/analytics/util/JSONBuilder;
    const-string/jumbo v7, "application_key"

    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/Event;->getApplicationKey()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v7, v8}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    .line 148
    const-string/jumbo v7, "event_type"

    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/Event;->getEventType()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v7, v8}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    .line 149
    const-string/jumbo v7, "timestamp"

    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/Event;->getEventTimestamp()Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v1, v7, v8}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    .line 150
    const-string/jumbo v7, "unique_id"

    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/Event;->getUniqueId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1, v7, v8}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    .line 152
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 153
    .local v0, "attributesJson":Lorg/json/JSONObject;
    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/Event;->getAllAttributes()Ljava/util/Map;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/Map$Entry;

    .line 155
    .local v4, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_0
    invoke-interface {v4}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-interface {v4}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v0, v7, v8}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 156
    :catch_0
    move-exception v7

    goto :goto_0

    .line 160
    .end local v4    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    new-instance v6, Lorg/json/JSONObject;

    invoke-direct {v6}, Lorg/json/JSONObject;-><init>()V

    .line 161
    .local v6, "metricsJson":Lorg/json/JSONObject;
    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/Event;->getAllMetrics()Ljava/util/Map;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_1
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map$Entry;

    .line 162
    .local v3, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Number;>;"
    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/Number;

    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    .line 163
    .local v2, "clz":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/lang/Number;>;"
    if-eqz v2, :cond_1

    .line 165
    :try_start_1
    invoke-interface {v3}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    new-instance v9, Ljava/math/BigDecimal;

    invoke-interface {v3}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Number;

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v9, v8}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v7, v9}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 166
    :catch_1
    move-exception v7

    goto :goto_1

    .line 172
    .end local v2    # "clz":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/lang/Number;>;"
    .end local v3    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/Number;>;"
    :cond_2
    invoke-virtual {v0}, Lorg/json/JSONObject;->length()I

    move-result v7

    if-lez v7, :cond_3

    .line 173
    const-string/jumbo v7, "attributes"

    invoke-virtual {v1, v7, v0}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    .line 177
    :cond_3
    invoke-virtual {v6}, Lorg/json/JSONObject;->length()I

    move-result v7

    if-lez v7, :cond_4

    .line 178
    const-string/jumbo v7, "metrics"

    invoke-virtual {v1, v7, v6}, Lcom/amazon/device/analytics/util/JSONBuilder;->withAttribute(Ljava/lang/String;Ljava/lang/Object;)Lcom/amazon/device/analytics/util/JSONBuilder;

    .line 180
    :cond_4
    invoke-virtual {v1}, Lcom/amazon/device/analytics/util/JSONBuilder;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v7

    return-object v7
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 135
    invoke-virtual {p0}, Lcom/amazon/device/analytics/events/Event;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v1

    .line 137
    .local v1, "json":Lorg/json/JSONObject;
    const/4 v2, 0x4

    :try_start_0
    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->toString(I)Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 139
    :goto_0
    return-object v2

    .line 138
    :catch_0
    move-exception v0

    .line 139
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method
